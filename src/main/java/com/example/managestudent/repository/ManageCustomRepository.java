package com.example.managestudent.repository;

import com.example.managestudent.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ManageCustomRepository {
    List<Employee> filterEmployee(String firstName, String lastName, String email, Pageable pageable);

    Long countTotalElement(String firstName, String lastName, String email);
}
