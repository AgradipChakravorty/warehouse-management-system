package com.wms.warehouse_management_system.Entity;
import jakarta.validation.constraints.*;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //primary key for product table
    @NotBlank(message = "Product name required")
    private String name;// stores product name
    @NotBlank(message = "SKU required")
    @Size(min = 3, max = 20, message = "SKU must be between 3 and 20 characters")
    private String sku;// stores product sku
    @Positive(message = "Price must be positive")
    private Double price;// stores product price

    //one product can exist in many inventory records
    @OneToMany(mappedBy = "product")
    private List<InventoryItem> inventoryItems;

    public Product() //default constructor
    { }

    public Product(String name, String sku, Double price) // parameterised constructor
    {
        this.name = name;
        this.sku = sku;
        this.price = price;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSku() {
        return sku;
    }

    public Double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}