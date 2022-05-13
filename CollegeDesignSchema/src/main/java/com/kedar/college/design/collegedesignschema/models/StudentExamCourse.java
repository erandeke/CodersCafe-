package com.kedar.college.design.collegedesignschema.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Data
@Entity
public class StudentExamCourse extends BaseModel {
    // 1 SEC -> 1 student
    // M  <-  1 student

    @ManyToOne
    private Students student;

    // 1SEC -> 1Exam course
    // M SEC -> 1Exam Course
    @ManyToOne
    private ExamCourse examCourse;

    private int marks;
}
