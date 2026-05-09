package com.wms.warehouse_management_system.Repository;

import com.wms.warehouse_management_system.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// handles database operations for product
public interface ProductRepository extends JpaRepository<Product, Long> {
}
