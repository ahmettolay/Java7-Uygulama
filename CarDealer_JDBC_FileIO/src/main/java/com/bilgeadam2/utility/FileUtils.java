package com.bilgeadam2.utility;

import com.bilgeadam2.entity.Car;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {


    public static List<String> readFile(String path) throws IOException {
        Constant costant = new Constant();
        FileReader fileReader = new FileReader(path);
        List<String> carList = new ArrayList<>();
        String line;
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while ((line = bufferedReader.readLine()) != null) {
            carList.add(line);

        }
        System.out.println(carList);
        return carList;

    }


    public static Car convertToCar(String[] array) {
        Car car = new Car(Integer.parseInt(array[0]), array[1], array[2], Integer.parseInt(array[3]), Integer.parseInt(array[4]));
        System.out.println(car);
        return car;

    }

    public static void getCarList(List<String> list) {
        List<Car> cars = new ArrayList<>();
        for (String string : list) {
            cars.add(convertToCar(string.split("_")));
        }
       System.out.println(cars);
    }

    public static void main(String[] args) throws IOException {

   getCarList(readFile(Constant.PATH));
    }

}
