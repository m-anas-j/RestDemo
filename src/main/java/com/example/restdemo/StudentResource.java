package com.example.restdemo;

import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/student")
public class StudentResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<StudentBean> getStudents()
    {
        StudentBean student1 = new StudentBean(1,"Anas","4th");
        StudentBean student2 = new StudentBean(2,"Saidul","5th");
        ArrayList<StudentBean> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        return studentList;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public StudentBean getStudentById(@PathParam("id") int studentId)
    {
        StudentBean student = new StudentBean(studentId,"Jawad","6th");
        return student;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addStudent(JsonObject studentJsonObject)
    {
        StudentBean student = new StudentBean();
        student.setId(studentJsonObject.getInt("id"));
        student.setName(studentJsonObject.getString("name"));
        student.setSemester(studentJsonObject.getString("semester"));

        //Call to a function that adds this record to the database
        System.out.println("Student added with following info: " + student.toString());
    }


}
