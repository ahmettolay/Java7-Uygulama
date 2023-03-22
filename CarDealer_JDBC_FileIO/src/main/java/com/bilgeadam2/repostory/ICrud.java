package com.bilgeadam2.repostory;

import java.util.List;

public interface ICrud <T> {

    List<T> getAll();
    void save(T t);
    void update(T t, long id);
    void delete(long id);
    void saveAll(List<T> t);

}
