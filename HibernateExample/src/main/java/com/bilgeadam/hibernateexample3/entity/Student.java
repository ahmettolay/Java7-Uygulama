package com.bilgeadam.hibernateexample3.entity;

import com.bilgeadam.hibernateexample3.util.HibernateUtil;
import org.hibernate.Session;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

//JPQL(Java Persistance Query Language)
//HQL (Hibernate Query Languade)

/*
NamedQuery
name --> kullanabilmek için bir isim girilmelidir.
query --> tabloya yapılacak sorgu yazlır (JPQL,HQL)
Avantajı --> NativeSQL ve diger tiplere göre --> Cach'leme yapmaktadır.
Aynı sorgu veritabanında hiç bir değişiklik olmadan gelirse cash 'den önceki sorgu sonucunu getirir
Nadir ve sık değişiklik vapılmayan çok yüksek maliyetli sorgularda tercih edilir(Aydan aya güncellenen tablolar)
Ancak her gün güncellenen verilerde kullanılmaz Yani özel durumlarda */
@NamedQueries({
        @NamedQuery(name="Student.findAll",query = "Select s From Student s"), //JPQL yazım biçimidir
        @NamedQuery(name="Student.findById",query = "Select s From Student s where s.id=:id") //JPQL yazım biçimidir
})
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;

    private String email;
    @Column(name = "studentnumber")
    private int studentNumber;

    public Student() {
    }

    public Student(int id) {
        this.id = id;
    }

    public Student(String firstName, String lastName, String email, int studentNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studentNumber = studentNumber;
    }

    public Student(int id, String firstName, String lastName, String email, int studentNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studentNumber = studentNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", studentNumber=" + studentNumber +
                '}';
    }
}
