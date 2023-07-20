package com.javatechie.controller;

import com.javatechie.dto.StoreDTO;
import com.javatechie.dto.UserDTO;
import com.javatechie.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @PostMapping("/create")
    public HttpEntity<Object> create(@ModelAttribute StoreDTO storeDTO) {
        return ResponseEntity.ok(storeService.createStore(storeDTO));
    }

    @GetMapping("/filter")
    public HttpEntity<Object> filter(@RequestParam(required = false) Integer page,
                                     @RequestParam(required = false) Integer size,
                                     @RequestParam(required = false) String  storeName) {
        if (page == null || page <= 0) {
            page = 0;
        }
        if (size == null || size <= 0) {
            size = 120;
        }
        var messageResponse = storeService.filterStore(storeName, page , size);
        return ResponseEntity.ok(messageResponse);
    }
}
