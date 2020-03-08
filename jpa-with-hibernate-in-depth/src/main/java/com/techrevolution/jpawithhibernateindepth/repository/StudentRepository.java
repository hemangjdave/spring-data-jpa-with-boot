package com.techrevolution.jpawithhibernateindepth.repository;

import com.techrevolution.jpawithhibernateindepth.entity.Passport;
import com.techrevolution.jpawithhibernateindepth.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
@Slf4j
public class StudentRepository {

    private final EntityManager entityManager;

    @Autowired
    public StudentRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveStudent() {
        Passport passport = new Passport("Z123456");
        entityManager.persist(passport);

        Student student = new Student("Tejas Shah");
        student.setPassport(passport);
        entityManager.persist(student);
    }

}
