/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import entity.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rasmus
 */
public class PersonFacadeTest {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_test");
    static IPersonFacade facade = new PersonFacade(emf);

    public PersonFacadeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createQuery("delete from Person").executeUpdate();
            Person p1 = new Person("p1FN","p1LN","123");
            Person p2 = new Person("p2FN","p2LN","321");
            em.persist(p1);
            em.persist(p2);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of EntityManagerFactory method, of class PersonFacade.
     */
//    @Test
//    public void testEntityManagerFactory() {
//        System.out.println("EntityManagerFactory");
//        PersonFacade instance = null;
//        EntityManagerFactory expResult = null;
//        EntityManagerFactory result = instance.EntityManagerFactory();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getEntityManager method, of class PersonFacade.
//     */
//    @Test
//    public void testGetEntityManager() {
//        System.out.println("getEntityManager");
//        PersonFacade instance = null;
//        EntityManager expResult = null;
//        EntityManager result = instance.getEntityManager();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of addPerson method, of class PersonFacade.
     */
    @Test
    public void testAddPerson() {
        Person p = new Person("testName", "testLastName", "test 88008800");
        Person result = facade.addPerson(p);
        assertNotNull(result.getId());
        EntityManager em = emf.createEntityManager();
        try {
            Person result2 = em.find(Person.class, result.getId());
            assertEquals("testName", result2.getFirstName());
        } finally {
            em.close();
        }
    }

//    /**
//     * Test of deletePerson method, of class PersonFacade.
//     */
//    @Test
//    public void testDeletePerson() {
//        System.out.println("deletePerson");
//        int id = 0;
//        PersonFacade instance = null;
//        Person expResult = null;
//        Person result = instance.deletePerson(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPerson method, of class PersonFacade.
//     */
//    @Test
//    public void testGetPerson() {
//        System.out.println("getPerson");
//        int id = 0;
//        PersonFacade instance = null;
//        Person expResult = null;
//        Person result = instance.getPerson(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPersons method, of class PersonFacade.
//     */
    @Test
    public void testGetPersons() {
        List<Person> persons = facade.getPersons();
        assertEquals(2, persons.size());
    }
//
//    /**
//     * Test of editPerson method, of class PersonFacade.
//     */
//    @Test
//    public void testEditPerson() {
//        System.out.println("editPerson");
//        Person p = null;
//        PersonFacade instance = null;
//        Person expResult = null;
//        Person result = instance.editPerson(p);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
