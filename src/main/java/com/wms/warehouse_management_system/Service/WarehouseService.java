package com.wms.warehouse_management_system.Service;

import com.wms.warehouse_management_system.Entity.Warehouse;
import com.wms.warehouse_management_system.Repository.WarehouseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarehouseService
{
    private final WarehouseRepository warehouseRepository; //warehouse repository field

    public WarehouseService(WarehouseRepository warehouseRepository) // constructor injection
    {
        this.warehouseRepository = warehouseRepository;
    }

    public Warehouse createWarehouse(Warehouse warehouse) //creates warehouse
    {
        return warehouseRepository.save(warehouse); //adds new warehouse to the record
    }

    public List<Warehouse> getAllWarehouses() //gets all warehouse
    {
        return warehouseRepository.findAll();// returns a list of all warehouses
    }

    public Warehouse getWarehouseById(Long id) //get warehouse by id
    {
        return warehouseRepository.findById(id) // fetches warehouse of the specific id
                .orElseThrow(() -> new RuntimeException("Warehouse not found with id: " + id)); //throws error if not found
    }

    public Warehouse updateWarehouse(Long id, Warehouse updatedWarehouse)
    {
        //checks if warehouse exists or not
        Warehouse existing = warehouseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Warehouse not found with id: " + id));

        //updating fields if it exists
        existing.setName(updatedWarehouse.getName());
        existing.setLocation(updatedWarehouse.getLocation());
        return warehouseRepository.save(existing);//saving after updating
    }
    public void deleteWarehouse(Long id) //deletes warehouse
    {
        warehouseRepository.deleteById(id); //deletes warehouse record from the database
    }
}