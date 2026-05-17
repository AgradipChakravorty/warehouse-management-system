package com.wms.warehouse_management_system.Controller;

import com.wms.warehouse_management_system.Service.QRCodeService;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/qr")

public class QRCodeController {

    private final QRCodeService qrCodeService;

    public QRCodeController(
            QRCodeService qrCodeService)
    {
        this.qrCodeService =
                qrCodeService;
    }

    @GetMapping(
            value="/generate",
            produces=
                    MediaType.IMAGE_PNG_VALUE
    )

    public byte[] generateQR(
            @RequestParam String text)
            throws Exception {

        return qrCodeService
                .generateQRCode(
                        text
                );
    }
}