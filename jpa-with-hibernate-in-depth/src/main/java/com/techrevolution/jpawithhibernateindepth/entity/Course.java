package com.techrevolution.jpawithhibernateindepth.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NamedQueries(
        value =
                {
                        @NamedQuery(name = "all_course_query", query = "from Course c"),
                        @NamedQuery(name = "all_course_query_with_like", query = "from Course c where c.name like '%Spring%'")

                }
)
public class Course {

    @Getter
    @Id
    @GeneratedValue
    private Long id;

    @Setter
    @Getter
    private String name;

    protected Course() {
    }

    public Course(String name) {
        this.name = name;
    }

    public Course(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
