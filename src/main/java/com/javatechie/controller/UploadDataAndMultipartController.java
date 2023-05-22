package com.javatechie.controller;


import com.javatechie.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("/api/v1/file")
public class UploadDataAndMultipartController {

    @Autowired
    private MediaService mediaService;

    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void createNewObjectWithImage(@RequestParam("model") String model,
                                         @RequestParam(value = "file", required = false) MultipartFile file){
        System.out.println(model);
        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getContentType());
        System.out.println(file);
        mediaService.addIpfs(file, "lamtv", "lamtv");
    }
}
