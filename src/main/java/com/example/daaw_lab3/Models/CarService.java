package com.example.daaw_lab3.Models;

import com.example.daaw_lab3.Exseption.CarNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public void addCar(Car car){
        carRepository.save(car);
    }

   public List<Car> getAllCars(){
        return carRepository.findAll();
    }
    public Car getCar(Long id){
        return carRepository.findCarWithOwner(id);
    }

    public void updateCar(Long id, Car carUp){
        if(!carRepository.existsById(id)){
            throw new CarNotFound(id);
        }else {
            carRepository.save(carUp);
        }
    }


    public List<Car> searchCars( String val) {
        return carRepository.findCars(val);
    }

    public void deleteCar(Long id){
        if(!carRepository.existsById(id)){
            throw new CarNotFound(id);
        }else {
        carRepository.deleteById(id);
    }}

}
