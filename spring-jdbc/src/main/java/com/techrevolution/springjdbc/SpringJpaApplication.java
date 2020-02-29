package com.techrevolution.springjdbc;

import com.techrevolution.springjdbc.dao.PersonJpaDao;
import com.techrevolution.springjdbc.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
@Slf4j
public class SpringJpaApplication implements CommandLineRunner {

	private final PersonJpaDao personJpaDao;

	@Autowired
	public SpringJpaApplication(PersonJpaDao personJpaDao) {
		this.personJpaDao = personJpaDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) {

		log.info("Person with id 10004 is with jpa:--{}" , personJpaDao.findById(10004));

		log.info("Person with id 10004 will be deleted:--");

		personJpaDao.deleteById(10004);

		Person person = new Person("Vaibhav", "Rajkot", new Date());

		log.info("Inserting new Person :--{}", personJpaDao.insertPerson(person));

		Person updatePerson = new Person(10001, "Hemang", "Pune", new Date());

		log.info("Updating person :--{}", personJpaDao.updateById(updatePerson));

		log.info("All person in the database is:--{}", personJpaDao.findAllPerson());

	}
}
