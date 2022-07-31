package com.kedar.lld.collegecoursedatabaseschemadesign.models;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class Exam  extends  BaseModel{
    private int duration;
}
