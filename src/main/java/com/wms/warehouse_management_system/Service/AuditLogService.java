package com.wms.warehouse_management_system.Service;

import com.wms.warehouse_management_system.Entity.AuditLog;
import com.wms.warehouse_management_system.Repository.AuditLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditLogService {

    private final AuditLogRepository repository;

    public AuditLogService(
            AuditLogRepository repository) {

        this.repository = repository;
    }

    public void saveLog(
            String username,
            String action) {

        AuditLog log =
                new AuditLog();

        log.setUsername(username);

        log.setAction(action);

        log.setTimestamp(
                LocalDateTime.now());

        repository.save(log);
    }
}