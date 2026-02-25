package com.org.inventory.controller;

import com.org.inventory.dto.InventoryCreateRequest;
import com.org.inventory.dto.InventorySearchRequest;
import com.org.inventory.entity.Inventory;
import com.org.inventory.service.InventoryService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inventories")
@Validated
public class InventoryController {

    private final InventoryService service;

    public InventoryController(InventoryService service) {
        this.service = service;
    }

    @GetMapping("search")
    public ResponseEntity<Page<Inventory>> search(
            @Valid InventorySearchRequest request,
            Pageable pageable) {

        return ResponseEntity.ok(
                service.search(request, pageable));
    }

    @PostMapping("save")
    public ResponseEntity<Inventory> create(
            @Valid @RequestBody InventoryCreateRequest request) {

        Inventory inventory = service.create(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(inventory);
    }
}