package com.wms.warehouse_management_system.Repository;

import com.wms.warehouse_management_system.Entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

// handles database operations for Inventory records
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {
}