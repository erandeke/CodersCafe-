package com.kedar.java8.code.lambda.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Kedar Erande
 */
public class ComparatorWithoutLambda {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Stud1", 20));
        students.add(new Student("Stud2", 10));
        students.add(new Student("Stud3", 40));
        students.add(new Student("Stud4", 30));

        //Arrange the Students according to their marks in the sorted order

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getMarks() - o2.getMarks();
            }
        });

        //print the result in asc

        for (Student s : students) {
            System.out.println("Student name" + "  " + s.getName() + " " + "mark allocated" + "  " + s.getMarks());
        }
    }
}

