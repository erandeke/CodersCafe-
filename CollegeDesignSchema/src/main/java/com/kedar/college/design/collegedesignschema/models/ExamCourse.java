package com.kedar.college.design.collegedesignschema.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Date;

@Data
@Entity
public class ExamCourse extends BaseModel {
    @ManyToOne
    private Exam exam;
    @ManyToOne
    private Course course;
    private Date date;
}
