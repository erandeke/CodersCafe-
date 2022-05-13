
package com.kedar.lld.collegecoursedatabaseschemadesign.models;

import lombok.Data;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@Entity
public class Course extends BaseModel {

    private String courseName;
    @ManyToMany
    private List<Students> students;
}
