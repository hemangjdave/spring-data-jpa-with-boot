package com.techrevolution.jpawithhibernateindepth.repository;

import com.techrevolution.jpawithhibernateindepth.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;

@Repository
@Transactional
@Slf4j
public class CourseRepository {

    private final EntityManager entityManager;

    @Autowired
    public CourseRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Course findById(long id) {
        return entityManager.find(Course.class, id);
    }

    public Course saveOrUpdateCourse(@NotNull Course course) {

        if (course.getId() == null) {
             entityManager.persist(course);
        } else {
             entityManager.merge(course);
        }
        return course;
    }

    public boolean deleteByid(long id) {
        Course course = findById(id);

        try {
            entityManager.remove(course);
            return true;
        } catch (RuntimeException iAE) {
            log.info("Error occured in removing course:--{}", iAE.getMessage());
            return false;
        }
    }
}
