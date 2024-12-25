package com.example.tea_backend.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Teas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "teaId")
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
