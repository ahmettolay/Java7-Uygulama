package com.bilgeadam.service;

import com.bilgeadam.controller.Manager;
import com.bilgeadam.entity.Car;
import com.bilgeadam.repository.CarRepository;
import com.bilgeadam.utility.Constant;
import com.bilgeadam.utility.FileUtils;

public class CarService {
    CarRepository carRepository;

    public  CarService(){
        carRepository= new CarRepository();
    }
    public void  downloadFileToDatabase(){
        if (carRepository.databaseControl()){
            System.out.println("Already Exist");
        }else {
            carRepository.saveAll(FileUtils.getCarList(FileUtils.readFile(Constant.path)));
        }

    }
    public  void save (){

    carRepository.save(Manager.getCarInformation());
}

}
