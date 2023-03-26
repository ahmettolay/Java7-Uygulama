package com.bilgeadam.join.school_manytoone.repository;

import com.bilgeadam.join.school_manytoone.entity.Sinif;
import com.bilgeadam.join.school_manytoone.utils.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class SinifDao {
    public void  save(Sinif sinif){
        try{
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(sinif);
            session.getTransaction().commit();
            session.close();

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Kayıt başarısız");
        }

    }
    public void getAll(){
        List<Object[]> list = null;
        try{
            EntityManager entityManager =HibernateUtil.getSessionFactory().createEntityManager();
            String query = "select o.okuladi, s.siniflokasyon, l.lablokasyon, d.dolapno from school_manytoone.sinif as s\n" +
                    "inner join school_manytoone.lab as l on s.lab_labid=l.labid\n" +
                    "inner join school_manytoone.okul as o on o.id = s.okul_id\n" +
                    "inner join school_manytoone.sinif_dolap as sd on sd.sinif_id = s.id\n" +
                    "inner join school_manytoone.dolap as d on  d.id = sd.dolaplar_id";
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
