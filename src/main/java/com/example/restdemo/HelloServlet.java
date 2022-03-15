package com.example.restdemo;

import java.io.*;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * This servlet is responsible for handling the form action of the form shown in the index page
 */
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello, user! The list of students you have requested is as follows:";
    }

    /**
     * The doGet() method handles a simple GET request from the index page on the client side that allows the client to view the list of all students.
     * @param request The HttpServletRequest object
     * @param response The HttpServletResponse object
     * @throws IOException
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        //Location of the resource
        String baseURI = "http://localhost:8080/RestDemo/api/student";

        //Sending a GET request to read information about the list of students
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseURI);
        JsonArray studentList = target.request(MediaType.APPLICATION_JSON).get(JsonArray.class);

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println(studentList);
        out.println("</body></html>");
    }

    /**
     * When a client wants to add a student through the form in the index page using a RESTful call, this method is invoked.
     * At first a JSON object is created using the information provided by the client in the HTML form.
     * The JSON object is then sent to the corresponding RESTful resource.
     * @param request The HttpServletRequest object
     * @param response The HttpServletResponse object
     * @throws IOException
     */
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id-field"));
        String name = request.getParameter("name-field");
        String semester = request.getParameter("semester-field");

        //The target URI of the resource
        String baseURI = "http://localhost:8080/RestDemo/api/student";

        //Creating a JSON object that represents the student information the client wants to add
        JsonObject student = Json.createObjectBuilder()
                .add("id",id)
                .add("name",name)
                .add("semester",semester)
                .build();

        /*
        Sending a POST request to the resource to add a student
         */

        //Creating a Client object
        Client client = ClientBuilder.newClient();
        //Creating a WebTarget object
        WebTarget target = client.target(baseURI);
        //Finally, calling the POST method on the WebTarget object
        target.request().post(Entity.entity(student, MediaType.APPLICATION_JSON));


        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "This is a post request. The student being created is as follows: <br> </h1>" + student.toString());
        out.println("</body></html>");
    }

    public void destroy() {
    }
}