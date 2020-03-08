package com.techrevolution.jpawithhibernateindepth;

import com.techrevolution.jpawithhibernateindepth.entity.inheritance.Employee;
import com.techrevolution.jpawithhibernateindepth.entity.inheritance.FullTimeEmployee;
import com.techrevolution.jpawithhibernateindepth.entity.inheritance.PartTimeEmployee;
import com.techrevolution.jpawithhibernateindepth.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
@Slf4j
public class JpaWithHibernateInheritance implements CommandLineRunner {

	private final EmployeeRepository employeeRepository;

	@Autowired
	public JpaWithHibernateInheritance(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public static void main(String[] args) {
        SpringApplication.run(JpaWithHibernateInheritance.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

		Employee employee1 = new PartTimeEmployee("Niraj", new BigDecimal("50"));
		Employee employee2 = new FullTimeEmployee("Hemang", new BigDecimal("10000"));

		employeeRepository.insert(employee1);
		employeeRepository.insert(employee2);

		log.info("All Employees are:--{}" , employeeRepository.getAllEmployee());

	}
}
