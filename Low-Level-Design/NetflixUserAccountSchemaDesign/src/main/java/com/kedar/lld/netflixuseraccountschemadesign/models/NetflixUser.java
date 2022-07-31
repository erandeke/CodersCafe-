package com.kedar.lld.netflixuseraccountschemadesign.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class NetflixUser extends BaseModel {
    private String netflixUserName;
    private String email;

    @ManyToOne //doubt this is m:m or m:1
    private Profiles profiles;

}
