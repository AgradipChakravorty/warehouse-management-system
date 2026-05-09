package com.wms.warehouse_management_system.Entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class StorageBins
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key for bin

    private String binCode;// stores bin code

    //Many StorageBins belong to ONE Warehouse
    @ManyToOne
    @JoinColumn(name = "warehouse_id")
    private Warehouse warehouse;

  // One StorageBin can store many InventoryItems(multiple products)
    @OneToMany(mappedBy = "storageBin")
    private List<InventoryItem> inventoryItems;

    public StorageBins() //default constructor
    {}

    public StorageBins(String binCode, Warehouse warehouse) // parameterised constructor
    {
        this.binCode = binCode;
        this.warehouse = warehouse;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public String getBinCode() {
        return binCode;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setBinCode(String binCode) {
        this.binCode = binCode;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}