package com.example.tea_backend.service;

import com.example.tea_backend.domain.Inventory;
import com.example.tea_backend.domain.Teas;
import com.example.tea_backend.dto.InventoryWithTeasDto;
import com.example.tea_backend.repository.InventoryRepository;
import com.example.tea_backend.repository.TeasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    TeasRepository teasRepository;

    public List<InventoryWithTeasDto> getInventoryList(Long userId) {
        List<Inventory> inventoryList = inventoryRepository.findAllByInventoryIdUserId(userId);

        List<InventoryWithTeasDto> inventoryListRes = new ArrayList<>();
        for(Inventory inventory:inventoryList) {
            InventoryWithTeasDto inventoryWithTeas = new InventoryWithTeasDto();

            Long teaId = inventory.getInventoryId().getTeaId();
            Optional<Teas> tea = teasRepository.findById(teaId);

            inventoryWithTeas.setInventory(inventory);
            inventoryWithTeas.setTea(tea);

            inventoryListRes.add(inventoryWithTeas);
        }

        return inventoryListRes;
    }

    public void deleteInventory(List<InventoryWithTeasDto> deleteTeas) {
        int length = deleteTeas.size();
        for (int i = 0; i < length; i++) {
            inventoryRepository.delete(deleteTeas.get(i).getInventory());
        }
    }
}
