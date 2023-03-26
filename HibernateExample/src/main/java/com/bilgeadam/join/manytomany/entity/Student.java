package com.bilgeadam.join.manytomany.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;
    private  String firsName;
    private String lastName;
    private  String gender;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Course> courses;


    public Student(String firsName, String lastName, String gender, List<Course> courses) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.gender = gender;
        this.courses = courses;
    }
}
