package com.example.restdemo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello, user! This is a RESTful GET call.";
    }

    /**
     * You can use this method to print your own name in the form of a RESTful GET call. The name value is taken as input as a path parameter.
     * @param name A path parameter that takes the user's name as input
     * @return A string containing a simple greeting targeted towards the entered username.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{nameParam}")
    public String doGreeting(@PathParam("nameParam") String name)
    {
        return "Hello, " + name;
    }
}