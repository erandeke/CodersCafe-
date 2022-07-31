package com.kedar.lld.netflixuseraccountschemadesign.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class VideoProfile extends BaseModel {

    @ManyToOne
    private Video video;

    @ManyToOne //doubt
    private Profiles profiles;

    private StatusType statusType;

}
