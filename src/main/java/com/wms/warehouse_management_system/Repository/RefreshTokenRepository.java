package com.wms.warehouse_management_system.Repository;

import com.wms.warehouse_management_system.Entity.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RefreshTokenRepository
        extends JpaRepository<RefreshToken, Long> {

    RefreshToken findByToken(String token);
}