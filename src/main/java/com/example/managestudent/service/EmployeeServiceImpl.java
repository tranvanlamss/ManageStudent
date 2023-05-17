package com.example.managestudent.service;

import com.example.managestudent.entity.Employee;
import com.example.managestudent.repository.ManageCustomRepository;
import com.example.managestudent.repository.ManageRepository;
import com.example.managestudent.response.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.Math.ceil;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final ManageCustomRepository manageCustomRepository;

    private final ManageRepository repository;

    public EmployeeServiceImpl(ManageRepository repository, ManageCustomRepository manageCustomRepository) {
        this.repository = repository;
        this.manageCustomRepository = manageCustomRepository;
    }

    @Override
    public Integer calculateTotalSalary(Integer emp_id) {
        repository.calculateTotalSalary(emp_id);
        return emp_id;
    }

    @Override
    public MessageResponse filterEmployee(String firstName, String lastName, String email, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        List<Employee> list = manageCustomRepository.filterEmployee(firstName, lastName, email, pageable);
        if (list.size() == 0){
            return MessageResponse.empty();
        }

        Long totalElement = manageCustomRepository.countTotalElement(firstName, lastName, email);

        Long totalPages = (totalElement + size - 1) / size;

        MessageResponse resp = new MessageResponse();
        resp.setResult(list);
        resp.setResponseCode("SUCCESS");
        resp.setPage(page);
        resp.setSize(size);
        resp.setTotalPage(totalPages);
        resp.setTotalElement(totalElement);
        return resp;
    }
}
