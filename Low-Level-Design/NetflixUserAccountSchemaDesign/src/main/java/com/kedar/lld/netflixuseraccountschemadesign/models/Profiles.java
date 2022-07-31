package com.kedar.lld.netflixuseraccountschemadesign.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
public class Profiles extends BaseModel {
    private String profileName;
    private ProfileType statusType;

}
