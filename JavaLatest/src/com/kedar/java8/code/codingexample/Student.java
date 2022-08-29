package com.kedar.java8.code.codingexample;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kedar Erande
 */
/*
 Convert the entity in dto
 */
public class Student {
    private int studentId;
    private String studentName;
    private double marks;

    public Student(int studentId, String studentName, double marks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.marks = marks;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}
