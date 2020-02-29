package com.techrevolution.springjdbc;

import com.techrevolution.springjdbc.dao.PersonJdbcDao;
import com.techrevolution.springjdbc.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import java.util.Date;

//@SpringBootApplication
@Slf4j
public class SpringJdbcApplication implements CommandLineRunner {

	private final PersonJdbcDao personJdbcDao;

	@Autowired
	public SpringJdbcApplication(PersonJdbcDao personJdbcDao) {
		this.personJdbcDao = personJdbcDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		log.info("All Person from person table:--{}" , personJdbcDao.findAllPerson());

		log.info("Person with id 10004 is:--{}" , personJdbcDao.findById(10004));

		log.info("Person with id 10004 will be deleted:--{}" , personJdbcDao.deleteById(10004));

		Person person = new Person(10001, "Hemang", "Pune", new Date());

		log.info("Updating id:--10001 with location from ahmedabad to pune:--{}",
				personJdbcDao.updateById(person)
		);

		Person newPerson = new Person(10005, "Sagar", "Rajkot", new Date());

		log.info("Inserting new person:--{}", personJdbcDao.insertPerson(newPerson));

	}
}
