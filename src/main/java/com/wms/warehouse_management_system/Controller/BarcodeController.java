package com.wms.warehouse_management_system.Controller;

import com.wms.warehouse_management_system.Service.BarcodeService;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/barcode")

public class BarcodeController {

    private final BarcodeService
            barcodeService;

    public BarcodeController(
            BarcodeService barcodeService)

    {
        this.barcodeService=
                barcodeService;
    }

    @GetMapping(

            value="/generate",

            produces=
                    MediaType.IMAGE_PNG_VALUE
    )

    public byte[] generateBarcode(

            @RequestParam String text)

            throws Exception {

        return barcodeService

                .generateBarcode(
                        text
                );

    }
}