package com.techrevolution.springjdbc.dao;

import com.techrevolution.springjdbc.model.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PersonJpaDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Person> findAllPerson(){
        Query namedQuery = entityManager.createNamedQuery("find-all-person");
        return namedQuery.getResultList();
    }

    public Person findById(int id) {
        return entityManager.find(Person.class, id);
    }

    public void deleteById(int id) {

        Person person = entityManager.find(Person.class, id);
        entityManager.remove(person);
    }

    public Person updateById(Person person) {
        return entityManager.merge(person);
    }

    public Person insertPerson(Person person) {
        return entityManager.merge(person);
    }

}
