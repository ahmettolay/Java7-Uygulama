package com.bilgeadam.repository;

import com.bilgeadam.entity.Car;
import com.bilgeadam.utility.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarRepository implements  ICurud <Car> {


    DBConnection dbConnection = new DBConnection();
    Connection connection = dbConnection.connect();

    @Override
    public List<Car> getAll() {
        String sql = "select * from cars order by \"model_year\" desc";
        List<Car> carList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Car car = new Car(resultSet.getInt("id"),
                        resultSet.getString("brand"),
                        resultSet.getString("car_model"),
                        resultSet.getInt("model_year"),
                        resultSet.getInt("dealer_ship_id"));
                carList.add(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carList;
    }

    @Override
    public void save(Car car) {
        String sql = "insert into cars(\"id\", \"brand\", \"car_model\",\"dealer_ship_id\",\"model_year\") values(?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, car.getId());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setString(3, car.getCarModel());
            preparedStatement.setLong(4, car.getDealerShipId());
            preparedStatement.setLong(5, car.getModelYear());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Car car, long id) {
        String sql = "update cars set \"brand\" =?, \"car_model\"=?,\"dealer_ship_id\"=?,\"model_year\"=? where id=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, car.getBrand());
            preparedStatement.setString(2, car.getCarModel());
            preparedStatement.setLong(3, car.getDealerShipId());
            preparedStatement.setLong(4, car.getModelYear());
            preparedStatement.setLong(5, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(long id) {
        String sql = "delete from cars where id =" +id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveAll(List<Car> car) {
        String sql = "insert into cars(\"brand\", \"car_model\",\"dealer_ship_id\",\"model_year\") values(?,?,?,?)";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (Car item : car){
                preparedStatement.setString(1, item.getBrand());
                preparedStatement.setString(2, item.getCarModel());
                preparedStatement.setLong(3, item.getDealerShipId());
                preparedStatement.setLong(4, item.getModelYear());

                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean databaseControl(){
        boolean control = false;
        String sql = "select id from cars";
        ResultSet resultSet;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            control = resultSet.next(); //resultSet' in içerisinde değer varsa bunun true dönmesini sağlayacak
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return control;
    }
}
