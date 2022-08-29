package com.kedar.java8.code.codingexample;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Kedar Erande
 */
public class EntityMapper {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "Stud-1", 100));
        list.add(new Student(2, "Stud-2", 20));
        list.add(new Student(3, "Stud-3", 50));

        Set<StudentDto> studentDtoSet = list.stream().filter(s -> s.getMarks() > 20).map(s -> {
            StudentDto studentDto = new StudentDto(s.getStudentId(), s.getStudentName(), s.getMarks());
            return studentDto;
        }).collect(Collectors.toSet());

        studentDtoSet.stream().forEach(s -> System.out.println(s.getStudentId() + " " + s.getStudentName()));
    }
}
