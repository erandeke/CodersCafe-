package com.kedar.college.design.collegedesignschema.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Data
@Entity
public class Course extends BaseModel {

    private String courseName;
    @ManyToMany
    private List<Students> students;
}
