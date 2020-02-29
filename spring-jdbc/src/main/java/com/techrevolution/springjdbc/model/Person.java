package com.techrevolution.springjdbc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "person")
@Slf4j
@NamedQuery(name = "find-all-person" , query = "from Person")
public class Person {

    @Id
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "birth_date")
    private Date birth_date;

    public Person() {
        log.info("creating person instance.....");
    }

    public Person(int id, String name, String location, Date birth_date) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.birth_date = birth_date;
    }

    public Person(String name, String location, Date birth_date) {
        this.name = name;
        this.location = location;
        this.birth_date = birth_date;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", birth_date=" + birth_date +
                '}';
    }
}
