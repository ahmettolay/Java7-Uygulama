package com.bilgeadam.hibernateexample1.repository;

import com.bilgeadam.hibernateexample1.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.Query;

import java.util.List;

public class UserRepository implements ICrud<User> {

    protected SessionFactory sessionFactory;
    Session session;

    public void setup() {


        // hibernate.cfg.xml dosyasındaki
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        } catch (Exception e) {
            StandardServiceRegistryBuilder.destroy(registry);
        } finally {
            //Yukarıdaki satırlarda (try-catch) hata olsun veya olmasın çalışacak kod bloğudur.
        }

    }


    @Override
    public void save(User user) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction(); //oturum oluşturur. veri tabanında bir değişiklik yapımadığında yazılması gerekmez(örneğin her türlü 'get' işlemi)
            session.save(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }


    }

    @Override
    public void update(User user) {
        Session session = sessionFactory.openSession();
        try {           //Transaction=işlem
            session.beginTransaction();//oturum oluşturur. veri tabanında bir değişiklik yapımadığında yazılması gerekmez(örneğin her türlü 'get' işlemi)
            session.update(user);
            session.getTransaction().commit();// yapılan işlemi veri tabanına commitler(işler). commit= işlemek
            session.close(); //opsiyonel
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback(); // eğer session.getTransaction() ile işlem yapılırken catch e düşerse yapılan işlem geri alınır
            }// roolback= geri almak.
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void delete(User user) {
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void deleteById(int id) {
        User user = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            user = session.find(User.class, id);// veri tabanındaki id sini verdiğimiz veriyi user a atıyor User{id=3, username='c', password='c', city='c', address='c'}  nesnesini oluturuyor
            //user =session.load(User.class, id);
            /*Query query=session.create@uery("from user where id= :id);
            query.setParameter("Id",id);
             user=query.getResultList().get(0)*/
            session.delete(user);
            System.out.println(user);
            session.getTransaction().commit();
            session.close();
        } catch (Exception ex) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<User> findAll() {
        List<User> userList = null;
        Session session = sessionFactory.openSession();//
        try {
            session.beginTransaction();
            Query query = (Query) session.createQuery("FROM User"); //"from "+User.class.getName()
            userList = query.getResultList();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return userList;
    }

    @Override
    public void getById(int id) {
        User user = null;
        try {
            session = sessionFactory.openSession();
            session.beginTransaction();
            user = session.find(User.class, id);
            session.getTransaction().commit();
            session.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void exit() {
        sessionFactory.close();

    }
}
