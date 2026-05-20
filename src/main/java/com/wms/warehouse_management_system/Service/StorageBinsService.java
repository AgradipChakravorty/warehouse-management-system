package com.wms.warehouse_management_system.Service;

import com.wms.warehouse_management_system.Entity.StorageBins;
import com.wms.warehouse_management_system.Repository.StorageBinsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageBinsService
{
    private final StorageBinsRepository storageBinRepository;  // Repository for StorageBin entity

    public StorageBinsService(StorageBinsRepository storageBinRepository) //constructor injection
    {
        this.storageBinRepository = storageBinRepository;
    }

    public StorageBins createBin(StorageBins bin) //create storage bins
    {
        return storageBinRepository.save(bin); //adds a new bin inside warehouse
    }

    public List<StorageBins> getAllBins() //gets all bins
    {
        return storageBinRepository.findAll(); //returns all storage bins in system
    }

    public StorageBins getBinById(Long id) // gets bin by id
    {
        // fetches single bin or throw error if not found
        return storageBinRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Storage Bin not found with id: " + id));
    }

    public StorageBins updateBin(Long id, StorageBins updatedBin)
    {
        //checks for existing id
        StorageBins existing = storageBinRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bin not found with id: " + id));

        //update fields if id is found
        existing.setBinCode(updatedBin.getBinCode());
        return storageBinRepository.save(existing); //saves the changes
    }

    public void deleteBin(Long id) //deletes bin
    {
        storageBinRepository.deleteById(id); //removes bin from database
    }
}