package com.kedar.java8.code.streams.filters;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Kedar Erande
 */
/*
 Prob: Use the filterApi of the stream
 */
public class WithFilterApiOfStream {
    private final static Integer LIMIT = 20;

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Stud1", 20));
        students.add(new Student("Stud2", 10));
        students.add(new Student("Stud3", 40));
        students.add(new Student("Stud4", 30));

        students.stream().filter(s -> s.getMarks() > LIMIT).forEach(s -> System.out.println(s.getName()));
    }
}
