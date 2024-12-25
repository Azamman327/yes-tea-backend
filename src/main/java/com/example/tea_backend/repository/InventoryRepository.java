package com.example.tea_backend.repository;

import com.example.tea_backend.domain.Inventory;
import com.example.tea_backend.domain.InventoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, InventoryId> {
//    Inventory findByUserIdAndTeaId(Long userId, Long teaId);
}
