package com.bilgeadam.hibernateexample2.repository;


import com.bilgeadam.hibernateexample1.entity.User;
import com.bilgeadam.hibernateexample2.entity.Ogretmen;
import com.bilgeadam.hibernateexample2.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

//Dao--> Data Access Object (Veri Erişim Nesnesi)
// repository katmanı --> crud işlemlerinin yapıldığı katmandır,
// genellikle isimlendirmeler entity class'ının adı + Repository/Dao şeklindedir (OgretmenDao/OgretmenRepository)
public class OgretmenDao implements ICrud<Ogretmen> {
    @Override
    public void save(Ogretmen ogretmen) {
//Bir Transaction basitçe bir iş birimini(thread) temsil eder.Session ile ilişkilendirilerek kullanılır.
//SessionFactory' de tanımlanan yapılandırma ayarları ile session üzerinden yapılacak işlemleri(save,update,delete) birbirinden soyutlar
//Bu sayede yapılacak olan işlem arka tarafta bağımlılığından ayrılıyor ve yalnızca yapılacak işlem
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(ogretmen);
            transaction.commit();// = session.getTransaction().commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        }

    }

    @Override
    public void update(Ogretmen ogretmen) {

    }

    @Override
    public void delete(Ogretmen ogretmen) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void getById(int id) {

    }
}
