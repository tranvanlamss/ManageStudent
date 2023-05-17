package com.example.managestudent.repository;

import com.example.managestudent.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ManageCustomImplRepository implements ManageCustomRepository{
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Employee> filterEmployee(String firstName, String lastName, String email, Pageable pageable) {
        StringBuilder sql = new StringBuilder("SELECT * FROM employees WHERE 1 = 1");

        if (firstName != null && !firstName.isEmpty()) {
            sql.append(" AND first_name LIKE %:firstName%");
        }
        if (lastName != null && !lastName.isEmpty()) {
            sql.append(" AND last_name LIKE %:lastName%");
        }
        if (email != null && !email.isEmpty()) {
            sql.append(" AND email LIKE %:email%");
        }

        Query query = entityManager.createNativeQuery(sql.toString(), Employee.class);

        if (firstName != null && !firstName.isEmpty()) {
            query.setParameter("firstName", firstName);
        }
        if (lastName != null && !lastName.isEmpty()) {
            query.setParameter("lastName", lastName);
        }
        if (email != null && !email.isEmpty()) {
            query.setParameter("email", email);
        }

        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        return query.getResultList();
    }

    @Override
    public Long countTotalElement(String firstName, String lastName, String email) {
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM employees WHERE 1 = 1");

        if (firstName != null && !firstName.isEmpty()) {
            sql.append(" AND first_name LIKE %:firstName%");
        }
        if (lastName != null && !lastName.isEmpty()) {
            sql.append(" AND last_name LIKE %:lastName%");
        }
        if (email != null && !email.isEmpty()) {
            sql.append(" AND email LIKE %:email%");
        }

        Query query = entityManager.createNativeQuery(sql.toString());

        if (firstName != null && !firstName.isEmpty()) {
            query.setParameter("firstName", firstName);
        }
        if (lastName != null && !lastName.isEmpty()) {
            query.setParameter("lastName", lastName);
        }
        if (email != null && !email.isEmpty()) {
            query.setParameter("email", email);
        }

        return ((Number) query.getSingleResult()).longValue();
    }


}
