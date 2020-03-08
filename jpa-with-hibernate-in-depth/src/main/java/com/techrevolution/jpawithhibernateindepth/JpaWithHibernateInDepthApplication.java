package com.techrevolution.jpawithhibernateindepth;

import com.techrevolution.jpawithhibernateindepth.entity.Course;
import com.techrevolution.jpawithhibernateindepth.entity.Passport;
import com.techrevolution.jpawithhibernateindepth.repository.CourseRepository;
import com.techrevolution.jpawithhibernateindepth.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@Slf4j
public class JpaWithHibernateInDepthApplication implements CommandLineRunner{

	private final CourseRepository courseRepository;

	@Autowired
	public JpaWithHibernateInDepthApplication(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(JpaWithHibernateInDepthApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Course with 10001 id is:--{}", courseRepository.findById(10001));
		log.info("Inserting new course:--{}" ,
				courseRepository.saveOrUpdateCourse(
						new Course("Effective java")
				)
		);

		log.info("Updating course:--{}" , courseRepository.saveOrUpdateCourse(
				new Course(10002L ,"Spring boot in depth in 28Minutes")
		));

//		log.info("Deleting course with id:--10001 and status is:--{}", courseRepository.deleteByid(10001));

	}
}
