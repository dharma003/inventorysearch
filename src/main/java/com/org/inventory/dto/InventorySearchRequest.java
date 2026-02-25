package com.org.inventory.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;

import java.math.BigDecimal;
import java.time.LocalDate;
public record InventorySearchRequest(

        String name,
        String category,
        String subCategory,

        LocalDate manufacturedFrom,
        LocalDate manufacturedTo,

        LocalDate expiryFrom,
        LocalDate expiryTo,

        @DecimalMin("0.0") BigDecimal minPrice,
        @DecimalMin("0.0") BigDecimal maxPrice,

        @Min(0) Integer minStock,
        @Min(0) Integer maxStock,

        String model,
        String seller,
        String location
) {
    public InventorySearchRequest {
        if (minPrice != null && maxPrice != null && minPrice.compareTo(maxPrice) > 0) {
            throw new IllegalArgumentException("minPrice cannot be greater than maxPrice");
        }

        if (manufacturedFrom != null && manufacturedTo != null &&
                manufacturedFrom.isAfter(manufacturedTo)) {
            throw new IllegalArgumentException("manufacturedFrom must be before manufacturedTo");
        }
    }
}