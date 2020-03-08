package com.techrevolution.jpawithhibernateindepth;

import com.techrevolution.jpawithhibernateindepth.entity.Course;
import com.techrevolution.jpawithhibernateindepth.entity.Review;
import com.techrevolution.jpawithhibernateindepth.repository.CourseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

//@SpringBootApplication
@Slf4j
public class JpaWithHibernateOneToManyAndViceVersa implements CommandLineRunner {

    private final CourseRepository courseRepository;

    @Autowired
    public JpaWithHibernateOneToManyAndViceVersa(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(JpaWithHibernateOneToManyAndViceVersa.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Inserting new Course:--");
        courseRepository.saveCourseWithReviews();



        log.info("Inserting new course with static list.>>>>");
        Review review1 = new Review("5" , "Awesome Course");
        Review review2 = new Review("5" , "Great Course");
        Course course = new Course("Java concurrency in practice..");
        List<Review> reviews = new ArrayList<>();
        reviews.add(review1);
        reviews.add(review2);
        courseRepository.saveCourseWithDynamicList(reviews, course);

    }
}
