package com.wms.warehouse_management_system.Service;

import com.wms.warehouse_management_system.Entity.InventoryItem;
import com.wms.warehouse_management_system.Entity.Product;
import com.wms.warehouse_management_system.Entity.StorageBins;

import com.wms.warehouse_management_system.Repository.InventoryItemRepository;
import com.wms.warehouse_management_system.Repository.ProductRepository;
import com.wms.warehouse_management_system.Repository.StorageBinsRepository;

import jakarta.transaction.Transactional;

import org.springframework.stereotype.Service;

@Service
public class ReceivingService
{
    // repository objects
    private final InventoryItemRepository inventoryRepository;
    private final ProductRepository productRepository;
    private final StorageBinsRepository storageBinsRepository;

    // constructor injection
    public ReceivingService(
            InventoryItemRepository inventoryRepository,
            ProductRepository productRepository,
            StorageBinsRepository storageBinsRepository)
    {
        this.inventoryRepository = inventoryRepository;
        this.productRepository = productRepository;
        this.storageBinsRepository = storageBinsRepository;
    }

    // method to find available storage bin
    public StorageBins findAvailableBin()
    {
        // gets first available storage bin
        return storageBinsRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow(() ->
                        new RuntimeException("No storage bins available"));
    }

    // transactional method
    // if one operation fails everything rolls back
    @Transactional
    public InventoryItem receiveShipment(Long productId,
                                         Integer quantity)
    {
        // fetch product using product id
        Product product = productRepository.findById(productId)
                .orElseThrow(() ->
                        new RuntimeException("Product not found"));

        // automatically assign storage bin
        StorageBins bin = findAvailableBin();

        // checks if same product already exists in same bin
        InventoryItem item = inventoryRepository
                .findByProductIdAndStorageBinId(productId, bin.getId())
                .orElse(null);

        // if inventory does not exist
        if(item == null)
        {
            item = new InventoryItem();

            item.setProduct(product); // assigns product
            item.setStorageBin(bin); // assigns storage bin
            item.setQuantity(quantity); // sets quantity
        }

        // if inventory already exists
        else
        {
            // increases stock quantity
            item.setQuantity(item.getQuantity() + quantity);
        }

        // saves inventory record
        return inventoryRepository.save(item);
    }
}