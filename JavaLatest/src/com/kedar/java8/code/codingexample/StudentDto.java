package com.kedar.java8.code.codingexample;

/**
 * @author Kedar Erande
 */
public class StudentDto {
    private int studentId;
    private String studentName;
    private double marks;

    public StudentDto(int studentId, String studentName, double marks) {
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
}
