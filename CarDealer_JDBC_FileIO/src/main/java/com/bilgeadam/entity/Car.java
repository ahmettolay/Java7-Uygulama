package com.bilgeadam.entity;

public class Car {
    private long id;
    private String brand;
    private  String carModel;
    private int modelYear;
    private  int dealerShipId;


    public Car(long id, String brand, String carModel, int modelYear, int dealerShipId) {
        this.id = id;
        this.brand = brand;
        this.carModel = carModel;
        this.modelYear = modelYear;
        this.dealerShipId = dealerShipId;
    }

    public Car(String brand, String carModel, int modelYear, int dealerShipId) {
        this.brand = brand;
        this.carModel = carModel;
        this.modelYear = modelYear;
        this.dealerShipId = dealerShipId;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public int getModelYear() {
        return modelYear;
    }

    public void setModelYear(int modelYear) {
        this.modelYear = modelYear;
    }

    public int getDealerShipId() {
        return dealerShipId;
    }

    public void setDealerShipId(int dealerShipId) {
        this.dealerShipId = dealerShipId;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", carModel='" + carModel + '\'' +
                ", modelYear=" + modelYear +
                ", dealerShipId=" + dealerShipId +
                '}';
    }
}
