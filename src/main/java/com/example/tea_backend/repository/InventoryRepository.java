package com.example.tea_backend.repository;

import com.example.tea_backend.domain.Inventory;
import com.example.tea_backend.domain.InventoryId;
import com.example.tea_backend.dto.InventoryWithTeasDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, InventoryId> {
    Inventory findByInventoryId(InventoryId inventoryId);
    List<Inventory> findAllByInventoryIdUserId(Long userId);
}
