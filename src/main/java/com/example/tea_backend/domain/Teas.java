package com.example.tea_backend.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Teas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teaId;
    private String brand;
    private String name;
    private String packagingtype;
    private String type;
    private int minute;
    private int second;
    private float temperature;
    private float quantity;
    private int watervolume;
}
