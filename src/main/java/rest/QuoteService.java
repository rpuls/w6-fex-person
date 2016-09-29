/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import static rest.PersonService.facade;

/**
 * REST Web Service
 *
 * @author rasmus
 */
@Path("quote")
public class QuoteService {
    
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    private static Map<Integer, String> quotes = new HashMap() {
        {
            put(1, "RESTful programming is very tough, and the code is fragile");
            put(2, "Servlet.init() exception is very strange and stupid");
            put(3, "AJAX is smart and very useful!");
        }
    };
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of QuoteService
     */
    public QuoteService() {
    }

    /**
     * Retrieves representation of an instance of rest.QuoteService
     * @return an instance of java.lang.String
     */
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getQuote() {
//        String quote;
//        Random generator = new Random();
//        quote = quotes.get(1);
//        //randomValue = entries[generator.nextInt(entries.length)].getValue();
//        //return gson.toJson(quote);
//        return "[]";
//
//    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        Random generator = new Random();
        String quote;
        quote = quotes.get(generator.nextInt(quotes.size())+1);
        return gson.toJson(quote);
    }

    /**
     * PUT method for updating or creating an instance of QuoteService
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
