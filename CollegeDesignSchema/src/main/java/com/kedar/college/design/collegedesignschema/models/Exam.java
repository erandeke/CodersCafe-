package com.kedar.college.design.collegedesignschema.models;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Exam  extends  BaseModel{
    private int duration;
}
