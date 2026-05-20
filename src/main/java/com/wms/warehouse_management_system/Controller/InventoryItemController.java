package com.wms.warehouse_management_system.Controller;

import com.wms.warehouse_management_system.Entity.InventoryItem;
import com.wms.warehouse_management_system.Service.InventoryItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryItemController {

    // Service layer for inventory logic
    private final InventoryItemService inventoryService;

    public InventoryItemController(InventoryItemService inventoryService) //constructor injection
    {
        this.inventoryService = inventoryService;
    }

    @PostMapping
    public InventoryItem addInventory(@RequestBody InventoryItem item) //adds inventory item
    {
        return inventoryService.addInventory(item); //assigns product + bin + quantity
    }

    @GetMapping
    public List<InventoryItem> getAllInventory()
    {
        return inventoryService.getAllInventory(); //gets all inventories
    }

    @GetMapping("/{id}")
    public InventoryItem getInventoryById(@PathVariable Long id)
    {
        return inventoryService.getInventoryById(id); //fetches inventory by id
    }

    @PutMapping("/{id}")
    public InventoryItem updateInventory(@PathVariable Long id, @RequestBody InventoryItem updatedItem)
    {
        return inventoryService.updateInventory(id, updatedItem); //updates existing inventory item by id
    }

    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable Long id)
    {
        inventoryService.deleteInventory(id); //deletes inventory by id
    }
}
