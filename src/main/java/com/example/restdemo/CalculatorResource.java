package com.example.restdemo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/calculator")
public class CalculatorResource {

    /**
     * This GET method takes two query parameters as input from the client side and returns the addition of the two numbers.
     * Query parameters are added to the url using '?' and multiple query parameters can be added, separated by '&' sign
     * @param a The first number
     * @param b The second number
     * @return Summation of a and b
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/addition")
    public double add(@QueryParam("num1") double a, @QueryParam("num2") double b){
        return a+b;
    }

    /**
     * This GET method takes two path parameters as input and returns the subrtraction between the two numbers
     * @param a The first number
     * @param b The second number
     * @return Subtraction between a and b
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/subtraction/{num1}/{num2}")
    public double subtract(@PathParam("num1") double a, @PathParam("num2") double b){
        return a-b;
    }
}
