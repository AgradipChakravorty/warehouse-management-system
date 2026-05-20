package com.wms.warehouse_management_system.Controller;

import com.wms.warehouse_management_system.Entity.StorageBins;
import com.wms.warehouse_management_system.Service.StorageBinsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bins")
public class StorageBinsController {

    // Service layer dependency
    private final StorageBinsService storageBinService;

    public StorageBinsController(StorageBinsService storageBinService) //constructor injection
    {
        this.storageBinService = storageBinService;
    }

    @PostMapping
    public StorageBins createBin(@RequestBody StorageBins bin)
    {
        return storageBinService.createBin(bin); //creates storage bin
    }


    @GetMapping
    public List<StorageBins> getAllBins()
    {
        return storageBinService.getAllBins(); //fetches all storage bins
    }

    @GetMapping("/{id}")
    public StorageBins getBinById(@PathVariable Long id)
    {
        return storageBinService.getBinById(id); //fetches storage bins by id
    }

    @PutMapping("/{id}")
    public StorageBins updateBin(@PathVariable Long id, @RequestBody StorageBins updatedBin)
    {
        return storageBinService.updateBin(id, updatedBin); //updates storage bins by id
    }

    @DeleteMapping("/{id}")
    public void deleteBin(@PathVariable Long id)
    {
        storageBinService.deleteBin(id); //deletes storage bins by id
    }
}
