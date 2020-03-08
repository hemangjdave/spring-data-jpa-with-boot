package com.techrevolution.jpawithhibernateindepth.repository;

import com.techrevolution.jpawithhibernateindepth.entity.inheritance.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {

    private final EntityManager entityManager;

    @Autowired
    public EmployeeRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void insert(Employee employee) {
        entityManager.persist(employee);
    }


    public List<Employee> getAllEmployee() {
        return entityManager.
                createNamedQuery("getAllEmployee", Employee.class)
                .getResultList();
    }
}
