package com.wms.warehouse_management_system.Entity;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Warehouse
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;// primary key for warehouse table

    private String name; // stores name of warehouse
    private String location;// stores location of warehouse

    // one warehouse contains multiple storage bins
    @OneToMany(mappedBy = "warehouse")
    private List<StorageBins> storageBins;

    public Warehouse() //default constructor
    { }

    public Warehouse(String name, String location) //parameterised constructor
    {
        this.name = name;
        this.location = location;
    }

    // getters and setters
    public Long getId()
    {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}