package com.org.inventory.repository;

import com.org.inventory.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface InventoryRepository extends
        JpaRepository<Inventory, UUID>,
        JpaSpecificationExecutor<Inventory> {
}