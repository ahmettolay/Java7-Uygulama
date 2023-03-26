package com.bilgeadam.hibernateexample2.util;

import com.bilgeadam.hibernateexample2.entity.Ogretmen;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

// util --> projelerde bir kere oluşturlup devamlı olarak farklı paket veya classlar tarafından kullanılacak aksiyonların bulunduğupakettir.
//Burada sınıf oluşturulur ve içerisinde ihtiyaca göre dolduruur ve devamlı kullanılır.
public class HibernateUtil {

    //hibernate.cfg.xml kullanmadan hibernate framework 'ünün sağladığı kütüphanelerden yararlanarak veritabanı işlemleri
    /*Temel amacı 'session' örneklerinin oluşturulmasını sağlamaktır
    session --> Uygulama ile veri tabloları arasındaki ilişki(Ogretmen class  <-->  ogretmen tablosu(postgresql))
    SessionFactory sınıfını ,nesne ile ilişik kurmaya yarayan tüm metadaları içerir.
    Geliştiricinin isteklerine karşılık veren thread(iş parçacıpı), oluşturan session örneklerini gelip buradan alır*/

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                //Hibernate'i ön yüklemek için bir nesne oluşturuyor.
                //Buradaki amaç bütün işlemleri tek bir yerde yapıp ardından SessinonFactory 'yi tek adımda oluşturmaktır.
                //
                Configuration configuration = new Configuration();

                // Properties sınıfı kalıcı özellik kümesidir.(Hibernate.cfg.xml --> değerlerinin tanımlandığı sınıf)
                //Burada anahtader ve değer mantığı vardır . Hashtable'dan inherit olduğu için put metodu kullanarak içerisinde
                //key value çifti tutulabilir.
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "org.postgresql.Driver");
                settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/hibernate2");
                settings.put(Environment.USER, "postgres");
                settings.put(Environment.PASS, "1234");

                settings.put(Environment.HBM2DDL_AUTO, "update");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.FORMAT_SQL, "true");

                configuration.setProperties(settings);
                //ORM işlemine tabi tutulacak anotasyon içeren sınıflar  burada tanımlanır.
                configuration.addAnnotatedClass(Ogretmen.class);

                //En temel olarak servis hizmetlerini barındırıyor . Ve bu hizmetlerin bağımlılıklarını yönetir.
                //Hibernate bağlantısının arka tarafta bir service aracılıgıyla gerçekleşmesini sağlar.
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
