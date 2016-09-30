/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import facade.IPersonFacade;
import facade.PersonFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author rasmus
 */
@Path("person")
public class PersonService {

    static IPersonFacade facade = new PersonFacade(Persistence.createEntityManagerFactory("pu"));
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PersonService
     */
    public PersonService() {
    }

    /**
     * Retrieves representation of an instance of rest.PersonService
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String getPersons() {
        List<Person> persons = facade.getPersons();
        return gson.toJson(persons);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addPerson(String content) {
        Person p = gson.fromJson(content, Person.class);
        Person newPerson = facade.addPerson(p);
        return gson.toJson(newPerson);
    }
//
//    @GET
//    @Path("{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getPerson(@PathParam("id") int id) {
//        Person p = facade.getPerson(id);
//        return gson.toJson(p);
//    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of PersonService
     *
     * @param content representation for the resource
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    }
}
