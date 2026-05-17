package com.wms.warehouse_management_system.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.common.BitMatrix;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;

@Service
public class QRCodeService {

    public byte[] generateQRCode(String text)
            throws Exception {

        QRCodeWriter writer =
                new QRCodeWriter();

        BitMatrix matrix =
                writer.encode(
                        text,
                        BarcodeFormat.QR_CODE,
                        300,
                        300
                );

        BufferedImage image =
                new BufferedImage(
                        300,
                        300,
                        BufferedImage.TYPE_INT_RGB
                );

        for(int x=0;x<300;x++)
        {
            for(int y=0;y<300;y++)
            {
                image.setRGB(
                        x,
                        y,
                        matrix.get(x,y)
                                ? 0x000000
                                : 0xFFFFFF
                );
            }
        }

        ByteArrayOutputStream output =
                new ByteArrayOutputStream();

        ImageIO.write(
                image,
                "PNG",
                output
        );

        return output.toByteArray();
    }
}