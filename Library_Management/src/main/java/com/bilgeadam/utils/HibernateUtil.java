package com.bilgeadam.utils;





import com.bilgeadam.entity.Author;
import com.bilgeadam.entity.Book;
import com.bilgeadam.entity.BookDetail;
import com.bilgeadam.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory=null;


    public static SessionFactory getSessionFactory() {
        try {

            Configuration configuration = new Configuration();
            configuration.addAnnotatedClass(Author.class);
            configuration.addAnnotatedClass(Book.class);
            configuration.addAnnotatedClass(BookDetail.class);
            configuration.addAnnotatedClass(User.class);
            sessionFactory=configuration.configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception e){
            e.printStackTrace();
        }

        return sessionFactory;
    }


}
