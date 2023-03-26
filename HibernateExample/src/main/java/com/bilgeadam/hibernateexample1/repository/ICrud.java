package com.bilgeadam.hibernateexample1.repository;

import com.bilgeadam.hibernateexample1.entity.User;

import java.util.List;

public interface ICrud <T> {

    void save(T t);
    void update (T t);
    void delete (T t);
   void deleteById(int id);
    List<User> findAll();
   void getById(int id);


}
