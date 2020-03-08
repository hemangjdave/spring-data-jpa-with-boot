package com.techrevolution.jpawithhibernateindepth.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
//@NoArgsConstructor
public class Review {

    @Id
    @GeneratedValue
    private Long id;
    private String ratings;
    private String description;

    @ManyToOne
    private Course course;

    public Review(String ratings, String description) {
        this.ratings = ratings;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", ratings='" + ratings + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
