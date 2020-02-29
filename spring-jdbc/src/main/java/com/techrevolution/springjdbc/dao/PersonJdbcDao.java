package com.techrevolution.springjdbc.dao;

import com.techrevolution.springjdbc.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

//@Repository
public class PersonJdbcDao {


    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonJdbcDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> findAllPerson(){
        return jdbcTemplate.query("select * from person",
                new BeanPropertyRowMapper<>(Person.class));
    }

    public Person findById(int id) {

        return jdbcTemplate.queryForObject("select * from person where id=?",
                new Object[]{id}, new BeanPropertyRowMapper<>(Person.class));

    }

    public int deleteById(int id) {
        return jdbcTemplate.update("delete from person where id= ?", id);
    }

    public int updateById(Person person) {

        return jdbcTemplate.update(
                "update person set location=? where id=?",
                person.getLocation(),
                person.getId()
        );

    }

    public int insertPerson(Person person) {
        String query = "insert into person values(? , ? ,?, ?)";

        return jdbcTemplate.update(query ,
                person.getId() ,
                person.getName() ,
                person.getLocation() ,
                person.getBirth_date()
        );
    }

}
