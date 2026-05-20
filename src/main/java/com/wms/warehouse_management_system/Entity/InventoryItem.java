package com.wms.warehouse_management_system.Entity;

import jakarta.persistence.*;

@Entity
public class InventoryItem
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key for inventory record

    private Integer quantity;// Quantity of product in a specific bin

    // Many InventoryItems belong to ONE Product
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

  //Many InventoryItems belong to ONE StorageBin
    @ManyToOne
    @JoinColumn(name = "storage_bin_id")
    private StorageBins storageBin;

    public InventoryItem() // default constructor
    {}

    public InventoryItem(Integer quantity, Product product, StorageBins storageBin) //parameterised constructor
    {
        this.quantity = quantity;
        this.product = product;
        this.storageBin = storageBin;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product getProduct() {
        return product;
    }

    public StorageBins getStorageBin() {
        return storageBin;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setStorageBin(StorageBins storageBin) {
        this.storageBin = storageBin;
    }
}