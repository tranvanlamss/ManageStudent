package com.example.managestudent.service;

import com.example.managestudent.response.MessageResponse;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {
     Integer calculateTotalSalary(Integer emp_id);

     MessageResponse filterEmployee(String firstName, String lastName, String email, Integer page, Integer size);
}
