package com.techrevolution.jpawithhibernateindepth.repository;

import com.techrevolution.jpawithhibernateindepth.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
public class JpqlBasicTestShould {

    private final EntityManager entityManager;

    @Autowired
    public JpqlBasicTestShould(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Test
    public void fetchAllCourses(){
        List<Course> resultList = entityManager.createNamedQuery("all_course_query", Course.class).getResultList();
        resultList.forEach(c -> log.info("Course is:--{}", c));
    }

    @Test
    public void giveAllResultWithLikeOperator() {
        TypedQuery<Course> query = entityManager.createNamedQuery("all_course_query_with_like", Course.class);
        List<Course> resultList = query.getResultList();
        resultList.forEach(course -> log.info("Course with like operator:--{}", course));
    }
}
