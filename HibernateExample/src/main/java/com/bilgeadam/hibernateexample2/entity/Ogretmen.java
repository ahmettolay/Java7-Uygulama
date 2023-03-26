package com.bilgeadam.hibernateexample2.entity;

// entity katmanı --> veritabanında oluşturulan tabloların iliskikurduğu classların bulunduğu katmandır.
//Bu katmandaki class ların veri tabanı ile ilişki kurması gerekli değildir.
//İçerisinde property'si olan her türlü class bu katmana yazılır ve bu katmandaki classlara entity classlar denir.


import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity // bir veri tabanı class'ıdır.
@Table(name ="teacher")
public class Ogretmen {
    @Id /*Primary key olduğunu gösterir.*/
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Integer id;
    @Column(nullable = false) // öğretmen tablosundaki name kolonu boş olamaz
    private  String name;
    @Column(nullable = false,length = 20) // en fazla 20 karakter uzunluğunda olabilir.
    private  String surName;

    @Column(nullable = false,columnDefinition = "int default 18") // default olarak columnDefinition = "int default 18" 18 yaşnda olacak
    private  int age;
    @ColumnDefault(value = "2")  // ilgili kolonun default değerini belirtmek için kullanılır
    @Column(nullable = true)
    private int serviceYear;


    public Ogretmen() {
    }
    public Ogretmen(String name, String surName) {
        this.name = name;
        this.surName = surName;
        this.setAge(getAge());
        this.setServiceYear(getServiceYear());

    }
    public Ogretmen(String name, String surName, int age) {
        this.name = name;
        this.surName = surName;
        this.age = age;
    }

    public Ogretmen(String name, String surName, int age, int serviceYear) {
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.serviceYear = serviceYear;
    }

    public Ogretmen(Integer id, String name, String surName, int age, int serviceYear) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.age = age;
        this.serviceYear = serviceYear;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age=18;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getServiceYear() {
        return serviceYear=2;
    }

    public void setServiceYear(int serviceYear) {
        this.serviceYear = serviceYear;
    }


    @Override
    public String toString() {
        return "Ogretmen{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", age=" + age +
                ", serviceYear=" + serviceYear +
                '}';
    }
}
