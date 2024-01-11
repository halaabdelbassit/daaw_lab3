package com.example.daaw_lab3.Exseption;

public class CarNotFound extends RuntimeException{
    public CarNotFound(Long id){
        super("could not found the car with id " +id);
    }
}
