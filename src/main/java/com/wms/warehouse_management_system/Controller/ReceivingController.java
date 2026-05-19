package com.wms.warehouse_management_system.Controller;

import com.wms.warehouse_management_system.Entity.InventoryItem;

import com.wms.warehouse_management_system.Service.ReceivingService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receiving")
public class ReceivingController
{
    // service layer object
    private final ReceivingService receivingService;

    // constructor injection
    public ReceivingController(ReceivingService receivingService)
    {
        this.receivingService = receivingService;
    }

    // API for receiving shipment
    @PostMapping
    public InventoryItem receiveShipment(
            @RequestParam Long productId,
            @RequestParam Integer quantity)
    {
        // calls service method
        return receivingService.receiveShipment(productId, quantity);
    }
}