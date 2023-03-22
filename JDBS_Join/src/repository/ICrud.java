package repository;

import entity.Product;

import java.util.List;

public interface ICrud  <T> {
    // gerekli metotlar yazılalacak ilgili classlara gönderilecek.
    // tip bağımsız yapılar üretebilmemizi cenerik yapı yapılır.
    void getAllProducts();

    void insert(T t);

    void update(T t);

    void saveAll(List<T> t);

    void productDelete(int t);


}
