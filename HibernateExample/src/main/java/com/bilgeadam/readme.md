# Baslık 
# ORM

### **ORM (Object-Relation Mapping )** bir veri tabanı ile programlama dilleri arasında bir köprü oluşturan bir teknolojidir. Bu teknoloji sayesinde veri tabanındaki verileri nesnelere dönüştürür ve programlama diline uygun hale getirir veya birbirleri ile ilişkili nesneler doğrudan ilişkisel veri tabanlarına haritalanabilmektedir. Bu sayede , veritabanı işlemlerini daha anlaşılır ve kolay bir şekilde yapabiliriz.Database bağımsız bir yazılım geliştirmemizi sağlar.

- ### **Databasedeki** tablolarımızdan ilgili classlar oluşturmamıza **DatabaseFirst** denir.

- ### **Classlardan**  database tabloları oluşturmamıza **CodeFirst** denir.

- **ORM** olarak şu teknolojileri kullanara veri tabanına **CRUD** ilşlemleri yapabiliriz.

  **JPA, Hibernate, Ibatis, Jdbctemplate ,DataJpa**

![ORM](C:\Users\TOLAY\Desktop\Typora\ORM.JPG)

- ***NOT*** : ORM bu konseptin bir adıdır, bir araç değildir. Hibarnate bir ORM aracıdır ve  Eclipselik, OpenJPA, TopLink gibi birçok farklı ORM aracı bulunmaktadır. Hibernate, Java dünyasındaki popüler ORM araçlarında biridir.



# Hibernate

### Hibernate, JPA'nın en popüler uygulamalarından biridir. Hibarnate, Java programlarında veritabanı işlerini yapmak için kullanılan bir ORM framewok'üdür. Hibarnete sayesinde, Java programlarında veri tabnanı işlerini daha etkin bir şekilde yapabiliriz.

## Entity

- JPA standardı sayesinde ORM toolları arasında kolaylıkla geçiş yapabiliriz. Çünkü JPA kullanımını öğrendikten sonra diğer ORM toolları da bu standart üzerine gelişmiştir.
- Object Releation Mapping'de önemli kavramlardan birisi Entity'dir.
- Veritabanında kalıcı olacak nesneye **Entity** denir.
- Nesnenin **Entity** sayılabilmesi veritabanı tarafından tanınabilmesi için class tanımının hemen üstinde **"@Entity"** annotation ile tanımlanmalıdır.Entity sınıfımız bir **Java POJO** sınıfıdır.
- Entity annotation ile tanımlanmış sınıf inner class olamaz ya da final olarak tanımlanamaz.
- Özetle bir Entity, veritabanımızda yer alan tablomuzdaki bir satıra den geliyor. Veritabanımızdaki satırların tamamı da entity set oluyor.



# JDBC

Java Database Connectivity (JDBC), Java projelerimizin veritabanı iile etkileşimini sağlayan, veritabanı işlemlerini SQL sorguları ile yapmamıza imkan veren **API**'dır.JDCB, Java geliştime Kiti'nin(JDK) 1997'den beri bir parçasıdır. Geliştiriciler Java projelerinde SQL sorguları yazmak istendiğinde ilgili veritabanının driverını ve JDBC paketlerini ekleyerek projelerinde SQL sorgularını kullanabiliyorlar.

# JPA

- Java dünyasına 2006 yılında Java Persistence API(JPA) dahil oldu. JPA'in Java dünyasına katılması ile ORM (Object Relational Mapping) bir standarta otudu. JPA, Java uygulamarımızdaki ilişkisel veritabanının yönetimini tanımlayan bir arayüzdürç Tek başına kullanımı söz konusu değildir. JPA ile ORM tooları bir standart ile kontrol altına alınmış olduç JPA **javax.persistence** paketi içerisinde tanımlanmıştır.

- **JPA (Java Persistance API)**Java platformunda bir  **ORM** standartıdır. JPA, Java programlarında veritabanı işlemlerinin yapılmasını kolaylaştıran bir API'dir.



## JPA Standartları

### **JPA** kütüphanesi aracılığıyla **EJB(Enterprise Java Beans)**'lerden, Web bileşenlerinden yada **Java Standart** sürümleri kullanılarak ilişkisel veritabanlarına erişilebilir, ve istenilen manipülasyonlar yapılabilir.**JPA JDBS** kütüphaneleri üzerinde soyut bir katman olarak bulunur ve uygulamayı **SQL'den** bağımsız bir hale getirir. Bu kütüphanenin tüm annotationları **javax.persistance** paketi içerisinde bulunur.

### 



# Maven

* Maven Apache tarafından geliştirilmiş , yazılım projelerimizin geliştirilmesi sırasında projenin geliştirilmesini kolaylaştıran , basitleştiren ve proje bağımlılıklarının kontrolünü yapmayı sağlayan bir araçtır.

* Maven projedeki bağımlılıkların (dependency) yönetimi dışında IDE (Integrated Development Enviroment ) bağımsız yazılım geliştirmeyi amaçlar.









