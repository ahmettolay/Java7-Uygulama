package com.bilgeadam.hibernateexample3.manager;

import com.bilgeadam.hibernateexample3.entity.Student;
import com.bilgeadam.hibernateexample3.repository.StudentDao;

import java.util.List;

public class StudentManager {
    static StudentDao studentDao = new StudentDao();

    public static void main(String[] args) {

        nameQueryFindAllStudents(4);
       // update();
       //delete();
    }

    public static void save() {
        Student student = new Student("Emre2", "Kazancı2", "emre@asdasd2", 123452);
        try {
            studentDao.save(student);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void update(){
        Student student = new Student(1,"Emre", "Kazancı", "emre@asdasd", 12345);
        try {
           studentDao.update(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void delete(){
        Student student = new Student(1);
        try {
            studentDao.delete(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public  static void startLike(String word){
        try{
            studentDao.startLike(word);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  static  void  greaterThan(int number){
        try{
            studentDao.greaterThan(number);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public static  void betweenStudentNumbers(int number1,int number2){
        try{
            studentDao.betweenStudentNumbers(number1,number2);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  static  void   nativeSQLQuery1(){
        List<Student> list=studentDao.nativeSQLQuery1();
        list.forEach(System.out::println);
    }

    public  static  void   nativeSQLQuery2(){
        studentDao.nativeSQLQuery2();
    }

    public static  void  nameQueryFindAllStudents(int id){
        studentDao.namedQueryFindById(id);
    }
}
