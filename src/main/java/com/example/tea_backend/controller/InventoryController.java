package com.example.tea_backend.controller;

import com.example.tea_backend.domain.Inventory;
import com.example.tea_backend.domain.InventoryId;
import com.example.tea_backend.domain.Teas;
import com.example.tea_backend.repository.InventoryRepository;
import com.example.tea_backend.repository.TeasRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@Controller
@RequestMapping(path="/inventory")
@Slf4j
public class InventoryController {
    @Autowired
    private InventoryRepository inventoryRepository;

    @PostMapping(path="/create")
    public @ResponseBody InventoryId createInventory(@RequestBody Inventory request) {
        Inventory inventory = new Inventory();

        InventoryId id = new InventoryId();
        id.setUserId(request.getInventoryId().getUserId());
        id.setTeaId(request.getInventoryId().getTeaId());

        inventory.setInventoryId(id);
        inventory.setAmount(request.getAmount());
        inventory.setYear(request.getYear());
        inventory.setMonth(request.getMonth());
        inventory.setDay(request.getDay());

        log.info("teaId: {}", id.getTeaId());

        Inventory newInventory = inventoryRepository.save(inventory);

        return newInventory.getInventoryId();
    }
}
