package com.example.daaw_lab3.Exseption;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CarNotFoundAdvise {
    @ResponseBody
    @ExceptionHandler(CarNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> exceptionHandler(CarNotFound exception){

        Map<String, String> errorMap=new HashMap<>();
        errorMap.put("errorMessage", exception.getMessage ());

        return errorMap;}
}
