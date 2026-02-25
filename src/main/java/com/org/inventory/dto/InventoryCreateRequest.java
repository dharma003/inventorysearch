package com.org.inventory.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;
import java.time.LocalDate;

public record InventoryCreateRequest(

        @NotBlank String name,
        @NotBlank String category,
        String subCategory,
        LocalDate manufacturingDate,
        LocalDate expiryDate,
        String specification,
        @DecimalMin("0.0") BigDecimal price,
        @Min(0) Integer stock,
        String model,
        String seller,
        String location
) {}