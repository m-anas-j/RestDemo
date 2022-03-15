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

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello Anas! The list of students you have requested is as follows:";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String baseURI = "http://localhost:8080/RestDemo/api/student";

        //Sending a GET request to read information about any specific student
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

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id-field"));
        String name = request.getParameter("name-field");
        String semester = request.getParameter("semester-field");

        //The target URI of the resource
        String baseURI = "http://localhost:8080/RestDemo/api/student";

        JsonObject student = Json.createObjectBuilder()
                .add("id",id)
                .add("name",name)
                .add("semester",semester)
                .build();

        //Sending a POST request to the resource to add a student
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseURI);
        target.request().post(Entity.entity(student, MediaType.APPLICATION_JSON));


        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "This is a post request " + student.toString() + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}