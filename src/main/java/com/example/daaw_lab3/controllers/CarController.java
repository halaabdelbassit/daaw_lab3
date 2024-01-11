package com.example.daaw_lab3.controllers;

import com.example.daaw_lab3.Exseption.CarNotFound;
import com.example.daaw_lab3.Models.Car;
import com.example.daaw_lab3.Models.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cars")
@CrossOrigin("http://localhost:3000")
public class CarController {
    @Autowired
    CarService carService;


    @GetMapping(value = "/getAll")
    public ResponseEntity<List<Car>> listOfCars() {
        return new ResponseEntity<>(carService.getAllCars(), HttpStatus.OK);
    }


    @PostMapping(value = "/addCar", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String newCar(@RequestBody Car car) {
        carService.addCar(car);
        return "car added successfully";
    }

    // http://localhost:8080/getCar/2
    @GetMapping(value = "/{id}")
    public ResponseEntity<Car> getCarWithOwner(@PathVariable("id") Long id) {
        Car car = carService.getCar(id);
        if (car == null) {
            throw new CarNotFound(id);
        }else{
        return new ResponseEntity<>(car, HttpStatus.OK);
    }}

    /*
    @PutMapping("/{id}")
    public List<Car> updateCar(@PathVariable Long id, @RequestBody Car carDetails) {
        Car car = carService.getCar(id)
                .orElseThrow(() -> new ResourceNotFoundException("Car not exist with id :" + id));
        car.setName(carDetails.getName());
        car.setModel(carDetails.getModel());
        car.setYear(carDetails.getYear());
        car.setOwner(carDetails.getOwner());
        carService.addCar(car);
        return carService.getAllCars();
    }
    */

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,value = "/{id}")
    public ResponseEntity<List<Car>> updateCar(@PathVariable Long id, @RequestBody Car carUp) {
        Car car = carService.getCar(id);
        if (car == null) {
            throw new CarNotFound(id);
        }
        carUp.setCarId(id);
        carService.updateCar(id, carUp);
        return new ResponseEntity<>(carService.getAllCars(),HttpStatus.OK);
    }



    @GetMapping(value = "/search/{val}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Car>> search(@PathVariable String val) {
        return  new ResponseEntity<>(carService.searchCars(val),HttpStatus.OK);
    }


    @DeleteMapping(value = "/{id}")
    public List<Car> deleteCar(@PathVariable Long id) {
        carService.deleteCar(id);
        return carService.getAllCars();
    }


}
