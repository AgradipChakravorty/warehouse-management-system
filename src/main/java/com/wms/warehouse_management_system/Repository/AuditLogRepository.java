package com.wms.warehouse_management_system.Repository;

import com.wms.warehouse_management_system.Entity.AuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditLogRepository
        extends JpaRepository<AuditLog, Long> {
}