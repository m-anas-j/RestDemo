package com.example.restdemo;

import java.io.Serializable;

/**
 * A simple javabean that represents a student entity.
 */

public class StudentBean implements Serializable {
    private int id;
    private String name;
    private String semester;

    public StudentBean() {
    }

    public StudentBean(int id, String name, String semester) {
        this.id = id;
        this.name = name;
        this.semester = semester;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "StudentBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", semester='" + semester + '\'' +
                '}';
    }
}
