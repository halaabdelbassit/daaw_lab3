package com.example.daaw_lab3.Models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name="Car")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter@Getter
public class Car{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "carId")
    private Long carId;

    @Column(name = "name")
    private String name;

    @Column(name = "model")
    private String model;

    @Column(name = "year")
    private Integer year;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ownerID", referencedColumnName = "ownerID")
    @JsonIgnoreProperties("car")
    private Owner owner;


}
