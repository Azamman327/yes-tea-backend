package com.example.tea_backend.dto;

import com.example.tea_backend.domain.Inventory;
import com.example.tea_backend.domain.Teas;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
public class InventoryWithTeasDto {
    private Inventory inventory;
    private Optional<Teas> tea;
}
