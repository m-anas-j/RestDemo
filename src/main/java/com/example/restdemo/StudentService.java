package com.example.restdemo;

import java.util.ArrayList;

public class StudentService {
    private static StudentService myStudentService = new StudentService();
    private ArrayList<StudentBean> studentList = new ArrayList<>();
    public static StudentService getMyStudentService()
    {
        return myStudentService;
    }
    public void addStudent(StudentBean newStudent)
    {
        studentList.add(newStudent);
    }
    public ArrayList<StudentBean> getStudentList()
    {
        return studentList;
    }

}
