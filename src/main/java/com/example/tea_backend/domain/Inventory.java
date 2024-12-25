package com.example.tea_backend.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Inventory {
    private Long teaId;
    private Long userId;
    private int amount;
    private int year;   //expired
    private int month;  //expired
    private int day;    //expired
}
