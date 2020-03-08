package com.techrevolution.jpawithhibernateindepth.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NamedQueries(
        value =
                {
                        @NamedQuery(name = "all_course_query", query = "from Course c"),
                        @NamedQuery(name = "all_course_query_with_like", query = "from Course c where c.name like '%Spring%'")

                }
)
@NoArgsConstructor
public class Course {

    @Setter
    @Getter
    @Id
    @GeneratedValue
    private Long id;

    @Setter
    @Getter
    private String name;

    @Getter
    @Setter
    @OneToMany(mappedBy = "course")
    private List<Review> reviewList = new ArrayList<>();

    @Getter
    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<Student> studentList = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public Course(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean addStudent(Student student) {
        return studentList.add(student);
    }

    public boolean removeStudent(Student student) {
        return studentList.remove(student);
    }

    public boolean addReview(Review review) {
        return reviewList.add(review);
    }

    public boolean removeReview(Review review) {
        return reviewList.remove(review);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
