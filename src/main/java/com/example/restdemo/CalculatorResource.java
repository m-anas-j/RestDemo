package com.example.restdemo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/calculator")
public class CalculatorResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/addition")
    public double add(@QueryParam("num1") double a, @QueryParam("num2") double b){
        return a+b;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/subtraction/{num1}/{num2}")
    public double subtract(@PathParam("num1") double a, @PathParam("num2") double b){
        return a-b;
    }
}
