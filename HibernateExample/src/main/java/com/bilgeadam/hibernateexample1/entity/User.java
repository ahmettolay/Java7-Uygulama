package com.bilgeadam.hibernateexample1.entity;

import javax.persistence.*;

@Entity
@Table(name ="users")
public class User {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="username")
    private  String username;

    @Column(name="password")
    private String password;

    @Column(name="city")
    private  String city;

    @Column (name ="address")
    private String address;


    public User() {

    }

    public User(String username, String password, String city, String address) {
        this.username = username;
        this.password = password;
        this.city = city;
        this.address = address;
    }

    public User(int id, String username, String password, String city, String address) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.city = city;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
