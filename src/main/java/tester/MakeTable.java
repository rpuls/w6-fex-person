/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import entity.Person;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author rasmus
 */
public class MakeTable {

    public static void main(String[] args) {
        Persistence.generateSchema("pu", null);
//        Person p1 = new Person("kurt","kurtsen","99889988");
//        Person p2 = new Person("lars","larsen","33443344");
//        Person p3 = new Person("hans","hansen","77667766");
//        Person p4 = new Person("ÆØÅ","æøå","12121212");
//        EntityManager em = Persistence.createEntityManagerFactory("pu").createEntityManager();
//        em.getTransaction().begin();
//        em.persist(p1);
//        em.persist(p2);
//        em.persist(p3);
//        em.persist(p4);
//        em.getTransaction().commit();
    }
}
