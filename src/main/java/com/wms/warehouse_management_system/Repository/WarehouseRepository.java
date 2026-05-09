package com.wms.warehouse_management_system.Repository;

import com.wms.warehouse_management_system.Entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

//handles database access for warehouse table
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
