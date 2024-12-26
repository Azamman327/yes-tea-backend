package com.example.tea_backend.controller;

import com.example.tea_backend.domain.Inventory;
import com.example.tea_backend.domain.Teas;
import com.example.tea_backend.repository.InventoryRepository;
import com.example.tea_backend.repository.TeasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@Controller
@RequestMapping(path="/inventory")
public class InventoryController {
    @Autowired
    private InventoryRepository inventoryRepository;

    @PostMapping(path="/create")
    public void createInventory(@RequestBody Inventory request) {
        Inventory inventory = new Inventory();

        inventory.setInventoryId(request.getInventoryId());
        inventory.setAmount(request.getAmount());
        inventory.setYear(request.getYear());
        inventory.setMonth(request.getMonth());
        inventory.setDay(request.getDay());

        inventoryRepository.save(inventory);
    }
}
