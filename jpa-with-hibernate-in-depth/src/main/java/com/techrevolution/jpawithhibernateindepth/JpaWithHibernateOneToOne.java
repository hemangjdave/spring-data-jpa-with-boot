package com.techrevolution.jpawithhibernateindepth;

import com.techrevolution.jpawithhibernateindepth.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@Slf4j
public class JpaWithHibernateOneToOne implements CommandLineRunner{

	private StudentRepository studentRepository;

	@Autowired
	public JpaWithHibernateOneToOne(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(JpaWithHibernateOneToOne.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("Inserting new student with passport-->>");
		studentRepository.saveStudent();
	}
}
