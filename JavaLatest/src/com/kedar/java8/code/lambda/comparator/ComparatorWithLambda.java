package com.kedar.java8.code.lambda.comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Kedar Erande
 */
public class ComparatorWithLambda {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Stud1", 20));
        students.add(new Student("Stud2", 10));
        students.add(new Student("Stud3", 40));
        students.add(new Student("Stud4", 30));

        Collections.sort(students, Comparator.comparingInt(Student::getMarks));

        students.forEach(s -> System.out.println(s.getName() + "   " + s.getMarks()));
    }
}
