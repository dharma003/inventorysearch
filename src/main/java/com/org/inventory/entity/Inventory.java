package com.org.inventory.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
@Entity
@Table(name = "inventories",
        indexes = {
                @Index(name = "idx_category", columnList = "category"),
                @Index(name = "idx_sub_category", columnList = "sub_category"),
                @Index(name = "idx_price", columnList = "price"),
                @Index(name = "idx_stock", columnList = "stock"),
                @Index(name = "idx_manufacturing_date", columnList = "manufacturing_date"),
                @Index(name = "idx_expiry_date", columnList = "expiry_date")
        })
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String category;
    private String subCategory;

    private LocalDate manufacturingDate;
    private LocalDate expiryDate;

    @Column(length = 2000)
    private String specification;

    @Column(precision = 12, scale = 2)
    private BigDecimal price;

    private Integer stock;

    private String model;
    private String seller;
    private String location;

    private Boolean active;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    protected Inventory() {
        // Required by JPA
    }

    public Inventory(UUID id, String name, String category, String subCategory,
                     LocalDate manufacturingDate, LocalDate expiryDate,
                     String specification, BigDecimal price, Integer stock,
                     String model, String seller, String location,
                     Boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {

        this.id = id;
        this.name = name;
        this.category = category;
        this.subCategory = subCategory;
        this.manufacturingDate = manufacturingDate;
        this.expiryDate = expiryDate;
        this.specification = specification;
        this.price = price;
        this.stock = stock;
        this.model = model;
        this.seller = seller;
        this.location = location;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getters only (immutability style)

    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public String getSubCategory() { return subCategory; }
    public LocalDate getManufacturingDate() { return manufacturingDate; }
    public LocalDate getExpiryDate() { return expiryDate; }
    public String getSpecification() { return specification; }
    public BigDecimal getPrice() { return price; }
    public Integer getStock() { return stock; }
    public String getModel() { return model; }
    public String getSeller() { return seller; }
    public String getLocation() { return location; }
    public Boolean getActive() { return active; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}