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
        return "Hello, Anas! This is a RESTful GET call.";
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{nameParam}")
    public String doGreeting(@PathParam("nameParam") String name)
    {
        return "Hello, " + name;
    }
}