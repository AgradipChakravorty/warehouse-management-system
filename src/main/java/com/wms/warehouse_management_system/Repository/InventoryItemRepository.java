package com.wms.warehouse_management_system.Repository;

import com.wms.warehouse_management_system.Entity.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

// handles database operations for Inventory records
public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

    // finds inventory item using product id and storage bin id
    Optional<InventoryItem>
    findByProductIdAndStorageBinId(Long productId,
                                   Long storageBinId);

}