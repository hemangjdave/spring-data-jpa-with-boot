package com.techrevolution.jpawithhibernateindepth.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    private Long id;
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;

    @ManyToMany(mappedBy = "studentList")
    @Setter(AccessLevel.NONE)
    private final List<Course> list = new ArrayList<>();

    public void add(Course course) {
        list.add(course);
    }

    public void remove(Course course) {
        list.remove(course);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
