package com.bilgeadam2.repostory;

import com.bilgeadam2.entity.Car;

import java.util.List;

public class CarRepository implements ICrud<Car>{
    @Override
    public List<Car> getAll() {

        return null;
    }

    @Override
    public void save(Car car) {

    }

    @Override
    public void update(Car car, long id) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public void saveAll(List<Car> t) {

    }
}
