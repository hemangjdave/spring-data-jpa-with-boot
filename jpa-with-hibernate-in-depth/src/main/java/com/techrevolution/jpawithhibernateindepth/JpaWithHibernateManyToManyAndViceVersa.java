package com.techrevolution.jpawithhibernateindepth;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
@Slf4j
public class JpaWithHibernateManyToManyAndViceVersa implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JpaWithHibernateManyToManyAndViceVersa.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
