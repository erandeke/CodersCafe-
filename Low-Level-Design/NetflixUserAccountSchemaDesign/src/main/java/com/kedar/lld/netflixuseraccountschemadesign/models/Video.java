package com.kedar.lld.netflixuseraccountschemadesign.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@Getter
@Setter
public class Video extends BaseModel {
    private String videoName;
    private String videoDescription;
    @ManyToMany
    private List<Actor> actors;
}
