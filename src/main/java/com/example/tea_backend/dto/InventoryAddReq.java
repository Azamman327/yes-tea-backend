package com.example.tea_backend.dto;

import com.example.tea_backend.domain.InventoryId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryAddReq {
    private InventoryId inventoryId;
    private int amount;
    private String expired;
}
