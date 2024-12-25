package com.example.tea_backend.domain;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Inventory {
    @EmbeddedId
    private InventoryId inventoryId;
    private int amount;
    private int year;   //expired
    private int month;  //expired
    private int day;    //expired
}
