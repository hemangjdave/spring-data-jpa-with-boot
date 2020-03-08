package com.techrevolution.jpawithhibernateindepth.repository;

import com.techrevolution.jpawithhibernateindepth.entity.Course;
import com.techrevolution.jpawithhibernateindepth.entity.Review;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotNull;
import java.util.List;

@Repository
@Transactional
@Slf4j
@NoArgsConstructor
public class CourseRepository {

    private  EntityManager entityManager;

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

    public void saveCourseWithReviews(){
        Review review1 = new Review("5" , "Awesome Course");
        Review review2 = new Review("5" , "Great Course");
        Course course = new Course("Effective Java");
        course.addReview(review1);
        review1.setCourse(course);
        course.addReview(review2);
        review2.setCourse(course);
        entityManager.persist(course);
        entityManager.persist(review1);
        entityManager.persist(review2);
    }

    public void saveCourseWithDynamicList(List<Review> reviewList , Course course){

        for (Review review : reviewList) {
            course.addReview(review);
            review.setCourse(course);
            entityManager.persist(course);
            entityManager.persist(review);
        }

    }
}
