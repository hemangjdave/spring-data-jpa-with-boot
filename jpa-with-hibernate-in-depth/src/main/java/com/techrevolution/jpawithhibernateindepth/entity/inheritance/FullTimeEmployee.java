package com.techrevolution.jpawithhibernateindepth.entity.inheritance;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.math.BigDecimal;


@Entity
@NoArgsConstructor
@Getter
public class FullTimeEmployee extends Employee{

    private BigDecimal salary;

    public FullTimeEmployee(String name, BigDecimal salary) {
        super(name);
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "salary=" + salary +
                "} " + super.toString();
    }
}
