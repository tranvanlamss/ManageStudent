package com.example.managestudent.repository;

import com.example.managestudent.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;


public interface ManageRepository extends JpaRepository<Employee, Integer>{
    @Procedure(value = "CalculateTotalSalary")
    void calculateTotalSalary(@Param("emp_id") Integer emp_id);

}
