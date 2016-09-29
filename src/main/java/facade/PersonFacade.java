/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author rasmus
 */
public class PersonFacade implements IPersonFacade {

    EntityManagerFactory emf;

    public PersonFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManagerFactory EntityManagerFactory() {
        return emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public void addEntityManagerFactory(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Person addPerson(Person p) {
        EntityManager em = getEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        }finally{
            em.close();
        }
    }

    @Override
    public Person deletePerson(int id) {
        return new Person();
    }

    @Override
    public Person getPerson(int id) {
        EntityManager em = getEntityManager();
        try{
            return em.find(Person.class, id);
        } finally{
            em.close();
        }
    }

    @Override
    public List<Person> getPersons() {
        EntityManager em = getEntityManager();
        try {
            Query query = em.createQuery("select p from Person p");
            List<Person> persons = query.getResultList();
            return persons;
        } finally {
            em.close();
        }
    }

    @Override
    public Person editPerson(Person p) {
        return new Person();
    }

}
