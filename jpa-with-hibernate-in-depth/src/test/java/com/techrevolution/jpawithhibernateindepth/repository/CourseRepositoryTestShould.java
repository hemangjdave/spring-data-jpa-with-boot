package com.techrevolution.jpawithhibernateindepth.repository;

import com.techrevolution.jpawithhibernateindepth.entity.Course;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Slf4j
public class CourseRepositoryTestShould {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseRepositoryTestShould(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Test
    public void returnTheCourseForGivenId() {
        Course course = courseRepository.findById(10001L);
        log.info("Cours is:---{}", course);
        assertEquals("JPA and Hibernate in depth", course.getName());
        assertTrue(course.getName() != null);
        assertTrue(course.getName().length() > 0);
    }

    @Test
    @DirtiesContext
    public void deleteCourseById(){
        courseRepository.deleteByid(10002);
        assertNull(courseRepository.findById(10002));
    }

    @Test
    @DirtiesContext
    public void saveGivenCourse(){
        Course course = courseRepository.saveOrUpdateCourse(new Course("Java Concurrency in practice"));
        Course insertedCourse = courseRepository.findById(2L);
        assertEquals(insertedCourse.getName() , course.getName());
    }

    @Test
    @DirtiesContext
    public void updateGivenCourse(){
        Course course = courseRepository.findById(10001L);
        course.setName("JPA and Hibernate in depth to test");
        courseRepository.saveOrUpdateCourse(course);

        Course updatedCourse = courseRepository.findById(10001L);
        assertEquals(updatedCourse.getName() , "JPA and Hibernate in depth to test");

    }

}
