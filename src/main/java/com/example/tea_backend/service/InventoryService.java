package com.example.tea_backend.service;

import com.example.tea_backend.domain.Inventory;
import com.example.tea_backend.domain.InventoryId;
import com.example.tea_backend.domain.Teas;
import com.example.tea_backend.dto.InventoryReqDto;
import com.example.tea_backend.dto.InventoryWithTeasDto;
import com.example.tea_backend.repository.InventoryRepository;
import com.example.tea_backend.repository.TeasRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;
    @Autowired
    TeasRepository teasRepository;

    public InventoryWithTeasDto getInventoryWithTea(Long userId, Long teaId) {
        InventoryId inventoryId = new InventoryId(teaId, userId);
        Inventory inventory = inventoryRepository.findByInventoryId(inventoryId);
        Optional<Teas> tea = teasRepository.findById(teaId);

        InventoryWithTeasDto inventoryWithTea = new InventoryWithTeasDto();
        inventoryWithTea.setInventory(inventory);
        inventoryWithTea.setTea(tea);

        return inventoryWithTea;
    }

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

    public InventoryId createInventory(InventoryReqDto request) {
        Inventory inventory = new Inventory();

        InventoryId id = new InventoryId();
        id.setUserId(request.getInventoryId().getUserId());
        id.setTeaId(request.getInventoryId().getTeaId());

        inventory.setInventoryId(id);
        inventory.setAmount(request.getAmount());
        inventory.setExpired(LocalDate.parse(request.getExpired()));

        Inventory newInventory = inventoryRepository.save(inventory);

        return newInventory.getInventoryId();
    }

    public InventoryId updateInventory(InventoryReqDto request) {
        Inventory inventory = inventoryRepository.findByInventoryId(request.getInventoryId());

        inventory.setInventoryId(request.getInventoryId());
        inventory.setAmount(request.getAmount());
        inventory.setExpired(LocalDate.parse(request.getExpired()));

        Inventory updatedInventory = inventoryRepository.save(inventory);
        return updatedInventory.getInventoryId();
    }

    public void deleteInventory(List<InventoryWithTeasDto> deleteTeas) {
        int length = deleteTeas.size();
        for (int i = 0; i < length; i++) {
            inventoryRepository.delete(deleteTeas.get(i).getInventory());
        }
    }
}
