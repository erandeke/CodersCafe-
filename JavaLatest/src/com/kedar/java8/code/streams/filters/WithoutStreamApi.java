package com.kedar.java8.code.streams.filters;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kedar Erande
 */
/*
  Prob : Without using stream filter api - we need to get the students
  whose marks are greater than 20
 */
public class WithoutStreamApi {
    private final static Integer LIMIT = 20;

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Stud1", 20));
        students.add(new Student("Stud2", 10));
        students.add(new Student("Stud3", 40));
        students.add(new Student("Stud4", 30));

        for (Student s : students) {
            if (s.getMarks() > LIMIT) {
                System.out.println("Student is" + " " + s.getName());
            }
        }

    }
}