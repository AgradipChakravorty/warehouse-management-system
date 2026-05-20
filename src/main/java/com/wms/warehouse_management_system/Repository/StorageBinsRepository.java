package com.wms.warehouse_management_system.Repository;


import com.wms.warehouse_management_system.Entity.StorageBins;
import org.springframework.data.jpa.repository.JpaRepository;

// handles database operations for StorageBin
public interface StorageBinsRepository extends JpaRepository<StorageBins, Long> {
}
