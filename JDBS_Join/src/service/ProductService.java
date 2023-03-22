package service;

import db_connection.DataBase;
import entity.Category;
import entity.Product;
import repository.ICrud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements ICrud<Product> {
    DataBase dataBase= new DataBase();

    Product product ;
    Category category;

    List<Object> ls = new ArrayList<>();




    public void getAllProducts(){

        try{
            PreparedStatement preparedStatement=dataBase.connection.prepareStatement("SELECT  P.\"productId\",P.\"categoryId\",C.\"categoryName\",p.\"productName\",P.\"price\",P.\"description\"\n" +
                    "FROM products AS P\n" +
                    "INNER JOIN categories AS C \n" +
                    "ON C.\"categoryId\"=P.\"categoryId\"");

            ResultSet rsProduct = preparedStatement.executeQuery();
while(rsProduct.next()){
    Integer productId=rsProduct.getInt("productId");// columnlardaki ile birabir aynı olacak "productId"
    Integer categoryId=rsProduct.getInt("categoryId");
    String categoryName= rsProduct.getString("categoryName");
    String productName= rsProduct.getString("productName");
    int price= rsProduct.getInt("price");
    String description= rsProduct.getString("description");
    category= new Category(categoryId,categoryName);
    product=new Product(productId,category,productName,price,description);
    System.out.println(product);
    ls.add(product);
   /* if (ls.isEmpty()) {
        System.out.println("Product is empty");
    } else {
        ls.forEach(item -> System.out.println(item));

    }*/
}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    public void insert(Product product){
       // PreparedStatement insertStatement=dataBase.connection.prepareStatement()
try{
    PreparedStatement insetStatement=dataBase.connection.prepareStatement("insert into products(\"categoryId\",\"productName\",price,description) values(?,?,?,?)");
    insetStatement.setInt(1,product.getCategory().getCategoryId());
    insetStatement.setString(2,product.getProductName());
    insetStatement.setInt(3,product.getPrice());
    insetStatement.setString(4,product.getProductName());
    insetStatement.executeUpdate();
    System.out.println("Product is added");
    getAllProducts();
    insetStatement.close();

}catch (SQLException e){

    System.out.println(e.getMessage());
}

    }

    public void update(Product product){
        try{
            PreparedStatement list = dataBase.connection.prepareStatement("select \"productId\" from products");
            ResultSet rsList = list.executeQuery();
            while (rsList.next()) {
                ls.add(rsList.getInt("productId"));
        }
            if (ls.contains(product.getProductId())) {
                //veritabanında değişiklik yapılacağı zaman önemli olan 'gönderilen sorgudaki column name' lerdir.(örn; productName, productCategory gibi)
                //değiştirilmek istenen değerler aşağıdaki gibi 'set' anahtar kelimesinden sonra belirtilerek main de oluşturulacak product nesnesi buna göre tanımlanmalıdır.
                PreparedStatement updateStatement = dataBase.connection.prepareStatement("update products set \"categoryId\"=?, \"productName\"=?, \"price\"=?, \"description\"=?\n" +
                        "where \"productId\" =?");

                updateStatement.setInt(1, product.getCategory().getCategoryId());
                updateStatement.setString(2, product.getProductName());
                updateStatement.setInt(3, product.getPrice());
                updateStatement.setString(4, product.getDescription());
                updateStatement.setInt(5, product.getProductId());
                updateStatement.executeUpdate();
                getAllProducts();

                updateStatement.close();
               dataBase.connection.close();
            }
            else{
                System.out.println("Product is not found");
            }


    } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void saveAll(List<Product> products) {
        if (products.isEmpty()){
            System.out.println("List is empty");
        }else {
            try{
                PreparedStatement preparedStatement = dataBase.connection.prepareStatement("insert into products(\"productId\",\"categoryId\",\"productName\",\"price\",\"description\") \n" +
                        "values(?,?,?,?,?)");
                //products.forEach(item -> item.);
                for(Product item : products) {
                    preparedStatement.setString(1, item.getProductName());
                    preparedStatement.setInt(2, item.getCategory().getCategoryId());
                    preparedStatement.setInt(3, item.getPrice());
                    preparedStatement.setString(4, item.getDescription());
                    preparedStatement.executeUpdate();
                }
                getAllProducts();
                preparedStatement.close();
                dataBase.connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void productDelete(int productId) {
        try {
            PreparedStatement list = dataBase.connection.prepareStatement("select \"productId\" from products");
            ResultSet rsList = list.executeQuery();
            while (rsList.next()) {
                ls.add(rsList.getInt("productId"));
            }
            if (ls.contains(productId)) {
                PreparedStatement deleteStatement = dataBase.connection.prepareStatement("delete  from products where   \"productId\"= ?");
                deleteStatement.setInt(1, productId);
                deleteStatement.executeUpdate();
                deleteStatement.close();
                getAllProducts();
            } else {
                System.out.println("Product is not found");
            }
            dataBase.connection.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}


