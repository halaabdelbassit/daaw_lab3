package com.example.daaw_lab3.Models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends JpaRepository<Car,Long> {

    // @Query("SELECT u FROM User u JOIN FETCH u.address WHERE u.id = :userId")

    @Query("select c from Car c join fetch c.owner where c.carId = :id")
    Car findCarWithOwner(@Param("id") Long id);

    @Query("SELECT c FROM Car c WHERE c.name like %:val% OR c.model LIKE %:val% OR c.year = :val OR c.owner.f_name like %:val% OR c.owner.l_name like %:val% OR c.owner.address like %:val%")
    List<Car> findCars(@Param("val") String name);



}