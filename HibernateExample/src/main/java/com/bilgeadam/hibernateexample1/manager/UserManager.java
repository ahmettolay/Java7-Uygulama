package com.bilgeadam.hibernateexample1.manager;

import com.bilgeadam.hibernateexample1.entity.User;
import com.bilgeadam.hibernateexample1.repository.UserRepository;

import java.util.List;

public class UserManager {
    static UserRepository userRepository = new UserRepository();

    public static void main(String[] args) {



        userRepository.setup();
        // save(user);
       // userRepository.delete(user);
        //System.out.println(userRepository.findAll());
        findAll();
        System.out.println(User.class.getName());
       // deleteById(3);

        userRepository.exit();


    }

    public static void save() {
        User user =new User();
        userRepository.save(user);

    }

    public static void update() {
        User user =new User(3,"ce","c","c","c");
        try{
            userRepository.update(user);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }


    }


    public static void delete() {
        User user =new User();
        userRepository.delete(user);
    }

    public static void deleteById(int id) {

        userRepository.deleteById(id);
    }

    public static void findAll() {
        List<User> userList=null;
        userList= userRepository.findAll();
        userList.stream().forEach(System.out::println);


    }

    public static void getById(int id) {
        userRepository.getById(id);
    }
}
