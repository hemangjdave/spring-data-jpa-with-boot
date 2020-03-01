package com.techrevolution.jpawithhibernateindepth.repository;

import com.techrevolution.jpawithhibernateindepth.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
public class JpqlNativeQueryTestShould {

    private final EntityManager entityManager;

    @Autowired
    public JpqlNativeQueryTestShould(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Test
    public void fetchAllCourseWithNativeQuery() {
        Query nativeQuery = entityManager.createNativeQuery("select * from Course", Course.class);
        List<Course> resultList = nativeQuery.getResultList();
        log.info("All the result with native query:--{}", resultList);
    }

    @Test
    public void fetchAllCourseWithWhereClause() {
        Query nativeQuery = entityManager.createNativeQuery("select * from Course where id=?", Course.class);
        nativeQuery.setParameter(1, 10001L);
        List<Course> resultList = nativeQuery.getResultList();
        log.info("All the course with like operator:--{}", resultList);
    }

    @Test
    public void fetchResultWithTypedParameter(){
        Query nativeQuery = entityManager.createNativeQuery("select * from Course where id=:id", Course.class);
        nativeQuery.setParameter("id", 10001L);
        List<Course> resultList = nativeQuery.getResultList();
        log.info("All the course with like operator:--{}", resultList);
    }

}
