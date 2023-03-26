package com.bilgeadam.join.manytomany.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer id;
 private  String title;
/* @ManyToMany
 private List<Student> students;*/

    public Course( String title) {
        this.title = title;
    }
}
