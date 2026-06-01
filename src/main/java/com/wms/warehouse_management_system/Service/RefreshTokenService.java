package com.wms.warehouse_management_system.Service;

import com.wms.warehouse_management_system.Entity.RefreshToken;
import com.wms.warehouse_management_system.Repository.RefreshTokenRepository;
import org.springframework.stereotype.Service;

@Service
public class RefreshTokenService {

    private final RefreshTokenRepository repository;

    public RefreshTokenService(
            RefreshTokenRepository repository)
    {
        this.repository = repository;
    }

    public RefreshToken saveToken(
            RefreshToken token)
    {
        return repository.save(token);
    }

    public RefreshToken findToken(
            String token)
    {
        return repository.findByToken(token);
    }
}