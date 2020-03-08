package com.techrevolution.jpawithhibernateindepth.repository;

import com.techrevolution.jpawithhibernateindepth.entity.Passport;
import com.techrevolution.jpawithhibernateindepth.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
public class OneToOneBnStudentAndPassportShould {

    private final EntityManager entityManager;

    @Autowired
    public OneToOneBnStudentAndPassportShould(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Test
    public void onlyFetchStudentNotPassport(){
        Student student = entityManager.find(Student.class, 20001L);
        log.info("Student with id:--20001 is:--{}" , student);

        Passport passport = student.getPassport();
        log.info("Passport of student id:--20001 is:--{}", passport);

    }

    @Test
    public void onlyFetchPassportNotStudent(){
        Passport passport = entityManager.find(Passport.class, 40002L);
        log.info("Passport with id:--40002L is:--{}", passport);
    }

}
