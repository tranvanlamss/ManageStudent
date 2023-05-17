package com.example.managestudent.controller;

import com.example.managestudent.response.MessageResponse;
import com.example.managestudent.service.EmployeeService;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/calculate-total-salary/{emp_id}")
    public ResponseEntity<Integer> total(@PathVariable Integer emp_id) {
        Integer total = employeeService.calculateTotalSalary(emp_id);
       return ResponseEntity.ok(total);

    }

    @GetMapping("")
    public HttpEntity<Object> filter(@RequestParam(required = false) Integer page,
                                     @RequestParam(required = false) Integer size,
                                     @RequestParam(required = false) String  firstName,
                                     @RequestParam(required = false) String lastName,
                                     @RequestParam(required = false) String email) {
        if (page == null || page <= 0) {
            page = 0;
        }
        if (size == null || size <= 0) {
            size = 120;
        }
        var messageResponse = employeeService.filterEmployee(firstName, lastName, email, page, size);
        return ResponseEntity.ok(messageResponse);

    }
}
