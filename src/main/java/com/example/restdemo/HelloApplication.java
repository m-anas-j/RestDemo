package com.example.restdemo;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * This class is the starting point of all RESTful services in this application. Any RESTful request from the client side will be
 * received by this class. You can assume that this class create a JAX RS servlet that is responsible for handling RESTful requests.
 * Thus, the URL path to send RESTful requests becomes: http://localhost:8080/RestDemo/api/ followed by whichever resource the client wants to request.
 */
@ApplicationPath("/api")
public class HelloApplication extends Application {

}