package com.example.tea_backend.dto;

import com.example.tea_backend.domain.InventoryId;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryDto {
    private InventoryId inventoryId;
    private int amount;
    private String expired;
}
