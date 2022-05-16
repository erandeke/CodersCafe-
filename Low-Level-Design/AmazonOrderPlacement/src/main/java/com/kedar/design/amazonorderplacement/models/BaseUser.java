package com.kedar.design.amazonorderplacement.models;

import lombok.Data;

import java.util.Date;

@Data
public class BaseUser {

    private String id;

    //register account

    private Date createdAt;

    private Date lastModified;

}
