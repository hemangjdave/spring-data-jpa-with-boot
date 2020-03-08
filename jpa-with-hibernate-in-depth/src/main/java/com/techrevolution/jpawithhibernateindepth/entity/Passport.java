package com.techrevolution.jpawithhibernateindepth.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Passport {

    @Id
    @GeneratedValue
    private Long id;
    private String number;

    @OneToOne(fetch = FetchType.LAZY , mappedBy = "passport")
    private Student student;

    public Passport(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", number='" + number + '\'' +
                '}';
    }
}
