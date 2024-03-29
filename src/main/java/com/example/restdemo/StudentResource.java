package com.example.restdemo;

import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/student")
public class StudentResource {
    private StudentService studentService = StudentService.getMyStudentService();
    /**
     * This GET method returns the list of all students as an array of JSON objects
     * @return Array of JSON objects
     */
    @GET
    @Path("/student-list")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<StudentBean> getStudents()
    {
//        StudentBean student1 = new StudentBean(1,"Anas","4th");
////        StudentBean student2 = new StudentBean(2,"Saidul","5th");
////        ArrayList<StudentBean> studentList = new ArrayList<>();
////        studentList.add(student1);
////        studentList.add(student2);
////        return studentList;
        return studentService.getStudentList();
    }

    /**
     * A GET request that takes an ID as path parameter and returns the information about the student with that ID.
     * Even though the student is returned as a StudentBean object, it will be received as a JSON object on the client side.
     * @param studentId The student ID entered as a path parameter
     * @return Information about the queried student
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public StudentBean getStudentById(@PathParam("id") int studentId)
    {
        StudentBean student = new StudentBean(studentId,"Jawad","6th");
        return student;
    }

    /**
     * A method that takes POST requests from client - when a client sends information about a student in the form of a JSON object,
     * that object is received by this method and added as an entry in a database.
     * @param studentJsonObject the student JSON object being sent from the client side
     */
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

        //Adding the student to the database
        studentService.addStudent(student);
    }

    /**
     * A method that takes POST requests from client side HTML Form - when a client sends information about a student in the HTML form,
     * that information is received by this method and added as an entry in a database.
     * @param id Student ID taken as a Form parameter from the client side
     * @param name Student Name taken as a Form parameter from the client side
     * @param semester Student Semester taken as a Form parameter from the client side
     */
    @POST
    @Path("/new-student")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public StudentBean addStudent(@FormParam("id-field") int id, @FormParam("name-field") String name, @FormParam("semester-field") String semester)
    {
        StudentBean newStudent = new StudentBean();
        newStudent.setId(id);
        newStudent.setName(name);
        newStudent.setSemester(semester);
        studentService.addStudent(newStudent);
        System.out.println(newStudent);
        return newStudent;
    }


}
