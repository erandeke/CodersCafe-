package com.kedar.college.design.collegedesignschema.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
public class Students extends  BaseModel {
    private String name;
    private String email;
    private String password;
    private String college;
    @ManyToMany(mappedBy = "students") //this will avoid creating multiple mapping tables
    private List<Course> course;
}
