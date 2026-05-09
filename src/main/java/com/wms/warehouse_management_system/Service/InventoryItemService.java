package com.wms.warehouse_management_system.Service;

import com.wms.warehouse_management_system.Entity.InventoryItem;
import com.wms.warehouse_management_system.Repository.InventoryItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryItemService
{
    private final InventoryItemRepository inventoryItemRepository; // Repository for Inventory table

    public InventoryItemService(InventoryItemRepository inventoryItemRepository) //constructor injection
    {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    public InventoryItem addInventory(InventoryItem item) // adds inventory items
    {
        return inventoryItemRepository.save(item); //assigns product to a bin and sets quantity of product in that bin
    }

    public List<InventoryItem> getAllInventory() //gets all inventory items
    {
        return inventoryItemRepository.findAll(); //shows full stock mapping (product + bin + quantity)
    }

    public InventoryItem getInventoryById(Long id)  //gets inventory by id
    {
        //Fetches single inventory record or throw error
        return inventoryItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found with id: " + id));
    }

    public InventoryItem updateInventory(Long id, InventoryItem updatedItem)
    {
       //checks for existing inventory item
        InventoryItem existing = inventoryItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found with id: " + id));

        // Update quantity
        existing.setQuantity(updatedItem.getQuantity());

        // Optional updates if required
        existing.setProduct(updatedItem.getProduct());
        existing.setStorageBin(updatedItem.getStorageBin());

        return inventoryItemRepository.save(existing); //saves updates
    }
    public void deleteInventory(Long id) //deletes inventory record
    {
        inventoryItemRepository.deleteById(id); //removes stock record from system
    }
}
