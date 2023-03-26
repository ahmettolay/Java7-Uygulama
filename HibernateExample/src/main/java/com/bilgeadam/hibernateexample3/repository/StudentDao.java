//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.bilgeadam.hibernateexample3.repository;

import com.bilgeadam.hibernateexample3.entity.Student;
import com.bilgeadam.hibernateexample3.util.HibernateUtil;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDao {
    public StudentDao() {
    }

    public void save(Student student) throws Exception {
        Transaction transaction = null;

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            try {
                transaction = session.beginTransaction();
                session.save(student);
                transaction.commit();
            } catch (Throwable var7) {
                if (session != null) {
                    try {
                        session.close();
                    } catch (Throwable var6) {
                        var7.addSuppressed(var6);
                    }
                }

                throw var7;
            }

            if (session != null) {
                session.close();
            }

        } catch (Exception var8) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw new Exception("kayıt başarısız!");
        }
    }

    public void update(Student student) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            try {
                session.beginTransaction();
                String hql = "Update Student set firstName= :firstName, lastName= :lastName, email= :email, studentNumber= :studentNumber where id = :id";
                Query query = session.createQuery(hql);
                query.setParameter("id", student.getId());
                query.setParameter("lastName", student.getLastName());
                query.setParameter("firstName", student.getFirstName());
                query.setParameter("studentNumber", student.getStudentNumber());
                query.setParameter("email", student.getEmail());
                query.executeUpdate();
                session.getTransaction().commit();
            } catch (Throwable var6) {
                if (session != null) {
                    try {
                        session.close();
                    } catch (Throwable var5) {
                        var6.addSuppressed(var5);
                    }
                }

                throw var6;
            }

            if (session != null) {
                session.close();
            }
        } catch (Exception var7) {
            System.out.println(var7.getMessage());
        }

    }

    public void delete(Student student) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            try {
                session.beginTransaction();
                String hql = "delete from Student where id= :id";
                Query query = session.createQuery(hql);
                query.setParameter("id", student.getId());
                query.executeUpdate();
                session.getTransaction().commit();
            } catch (Throwable var6) {
                if (session != null) {
                    try {
                        session.close();
                    } catch (Throwable var5) {
                        var6.addSuppressed(var5);
                    }
                }

                throw var6;
            }

            if (session != null) {
                session.close();
            }
        } catch (Exception var7) {
            System.out.println(var7.getMessage());
        }

    }

    public void deleteById(int id) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            try {
                session.beginTransaction();
                String hql = "delete from Student where id= :id";
                Query query = session.createQuery(hql);
                query.setParameter("id", id);
                query.executeUpdate();
                session.getTransaction().commit();
            } catch (Throwable var6) {
                if (session != null) {
                    try {
                        session.close();
                    } catch (Throwable var5) {
                        var6.addSuppressed(var5);
                    }
                }

                throw var6;
            }

            if (session != null) {
                session.close();
            }
        } catch (Exception var7) {
            System.out.println(var7.getMessage());
        }

    }

    public void startLike(String word) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            try {
                session.beginTransaction();
                String hql = "from Student where LOWER(firstName) like :word";
                org.hibernate.query.Query<Student> query = session.createQuery(hql, Student.class);
                query.setParameter("word", word.toLowerCase() + "%");
                List<Student> students = query.getResultList();
                PrintStream var10001 = System.out;
                Objects.requireNonNull(var10001);
                students.forEach(var10001::println);
            } catch (Throwable var7) {
                if (session != null) {
                    try {
                        session.close();
                    } catch (Throwable var6) {
                        var7.addSuppressed(var6);
                    }
                }

                throw var7;
            }

            if (session != null) {
                session.close();
            }
        } catch (Exception var8) {
            System.out.println(var8.getMessage());
        }

    }

    public void greaterThan(int number) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            try {
                session.beginTransaction();
                String hql = "from Student where studentNumber > :key";
                org.hibernate.query.Query<Student> query = session.createQuery(hql, Student.class);
                query.setParameter("key", number);
                List<Student> students = query.getResultList();
                PrintStream var10001 = System.out;
                Objects.requireNonNull(var10001);
                students.forEach(var10001::println);
            } catch (Throwable var7) {
                if (session != null) {
                    try {
                        session.close();
                    } catch (Throwable var6) {
                        var7.addSuppressed(var6);
                    }
                }

                throw var7;
            }

            if (session != null) {
                session.close();
            }
        } catch (Exception var8) {
            System.out.println(var8.getMessage());
        }

    }

    public void betweenStudentNumbers(int number1, int number2) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            try {
                session.beginTransaction();
                String hql = "from Student where studentNumber between :no1 and :no2";
                org.hibernate.query.Query<Student> query = session.createQuery(hql, Student.class);
                query.setParameter("no1", number1);
                query.setParameter("no2", number2);
                List<Student> students = query.getResultList();
                PrintStream var10001 = System.out;
                Objects.requireNonNull(var10001);
                students.forEach(var10001::println);
            } catch (Throwable var8) {
                if (session != null) {
                    try {
                        session.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }
                }

                throw var8;
            }

            if (session != null) {
                session.close();
            }
        } catch (Exception var9) {
            System.out.println(var9.getMessage());
        }

    }
        public void nativeSQLQuery12(int id) {
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        Student student=(Student) entityManager.createNativeQuery("select first_name  from student where id=:id ", Student.class).getSingleResult();


    }
    public List<Student> nativeSQLQuery1() {
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        List<Student> studentList = entityManager.createNativeQuery("select id, first_name, lastname, email, studentnumber from student", Student.class).getResultList();
        return studentList;
    }

    public void nativeSQLQuery2() {
        EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
        List<Object[]> studentList = entityManager.createNativeQuery("select id, first_name, lastname, email, studentnumber from student").getResultList();
        Iterator var3 = studentList.iterator();

        while(var3.hasNext()) {
            Object[] item = (Object[])var3.next();
            PrintStream var10000 = System.out;
            String var10001 = String.valueOf(item[0]);
            var10000.println("ID: " + var10001 + ", First Name: " + String.valueOf(item[1]) + ", Last Name: " + String.valueOf(item[2]) + ", Email: " + String.valueOf(item[3]) + ", Student Number: " + String.valueOf(item[4]));
        }

    }

    public void namedQueryFindAllStudents() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
        TypedQuery<Student> typedQuery = entityManager.createNamedQuery("Student.findAll", Student.class);
        List<Student> list = typedQuery.getResultList();
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        list.forEach(var10001::println);
    }

    public void namedQueryFindById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        EntityManager entityManager = session.getEntityManagerFactory().createEntityManager();
        TypedQuery<Student> typedQuery = entityManager.createNamedQuery("Student.findById", Student.class);
        typedQuery.setParameter("id", id);
        List<Student> list = typedQuery.getResultList();
        PrintStream var10001 = System.out;
        Objects.requireNonNull(var10001);
        list.forEach(var10001::println);
    }


    public void getAll(){
        List<Object[]> list = null;
        try{
            EntityManager entityManager = HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select o.okuladi, s.siniflokasyon, l.lablokasyon, d.dolapno from sinif as s \n" +
                    "\n" +
                    "inner join sinif_okul as so on so.sinif_id = s.id\n" +
                    "inner join okul as o ON o.id = so.okul_id\n" +
                    "\n" +
                    "inner join sinif_dolap as sd ON sd.sinif_id = s.id\n" +
                    "inner join dolap as d ON d.id = sd.dolaplar_id\n" +
                    "\n" +
                    "inner join lab as l on s.lab_labid = l.labid";
            list = entityManager.createNativeQuery(query).getResultList();
            for (Object[] item : list){
                System.out.println(
                        "Okul Adı: " + item[0] + ", "
                                + "Sınıf Lokasyonu: " + item[1] + ", "
                                + "Lab Lokasyonu: " + item[2] + ", "
                                + "Sınıf Dolap Sayıyı: " + item[3] + ", "
                );
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
