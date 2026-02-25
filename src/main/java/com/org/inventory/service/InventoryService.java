package com.org.inventory.service;

import com.org.inventory.dto.InventoryCreateRequest;
import com.org.inventory.dto.InventorySearchRequest;
import com.org.inventory.entity.Inventory;
import com.org.inventory.repository.InventoryRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class InventoryService {

    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

//    public Page<Inventory> search(InventorySearchRequest request,
//                                  Pageable pageable) {
//
//        var spec = InventorySpecification.withFilters(request);
//
//        return repository.findAll(spec, pageable);
//    }

    @Cacheable(
            value = "inventorySearchCache",
            key = "T(java.util.Objects).hash(#request) + '-' + #pageable.pageNumber + '-' + #pageable.pageSize"
    )
    public Page<Inventory> search(InventorySearchRequest request,
                                  Pageable pageable) {

        System.out.println("🔥 Fetching from DB (Not Cache)");

        var spec = InventorySpecification.withFilters(request);
        return repository.findAll(spec, pageable);
    }

    public Inventory create(InventoryCreateRequest req) {

        Inventory inventory = new Inventory(
                null,
                req.name(),
                req.category(),
                req.subCategory(),
                req.manufacturingDate(),
                req.expiryDate(),
                req.specification(),
                req.price(),
                req.stock(),
                req.model(),
                req.seller(),
                req.location(),
                true,
                LocalDateTime.now(),
                LocalDateTime.now()
        );

        return repository.save(inventory);
    }
}