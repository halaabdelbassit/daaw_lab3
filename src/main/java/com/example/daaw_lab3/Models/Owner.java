package com.example.daaw_lab3.Models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Table(name="owner")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ownerId")
    private Long ownerId;

    @Column(name = "fname")
    private String f_name;
    
    @Column(name = "lname")
    private String l_name;
    
    @Column(name = "address")
    private String address;

    @OneToOne(mappedBy = "owner")
    private Car car;

}
