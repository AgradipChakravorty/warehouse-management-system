package com.wms.warehouse_management_system.Controller;

import com.wms.warehouse_management_system.Entity.Warehouse;
import com.wms.warehouse_management_system.Service.WarehouseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/warehouses")
public class WarehouseController
{
    private final WarehouseService warehouseService; // Service layer for warehouse operations

    public WarehouseController(WarehouseService warehouseService) //constructor injection
    {
        this.warehouseService = warehouseService;
    }

    @PostMapping
    public Warehouse createWarehouse(@RequestBody Warehouse warehouse) //creates warehouse
    {
        return warehouseService.createWarehouse(warehouse);
    }

    @GetMapping
    public List<Warehouse> getAllWarehouses()
    {
        return warehouseService.getAllWarehouses(); //fetches all warehouse records
    }

    @GetMapping("/{id}")
    public Warehouse getWarehouseById(@PathVariable Long id) //gets all warehouse records by id
    {
        return warehouseService.getWarehouseById(id);
    }

    @PutMapping("/{id}")
    public Warehouse updateWarehouse(@PathVariable Long id, @RequestBody Warehouse updatedWarehouse)
    {
        return warehouseService.updateWarehouse(id, updatedWarehouse); //updates warehouse by id
    }

    @DeleteMapping("/{id}")
    public void deleteWarehouse(@PathVariable Long id)
    {
        warehouseService.deleteWarehouse(id); //deletes warehouse record by id
    }
}