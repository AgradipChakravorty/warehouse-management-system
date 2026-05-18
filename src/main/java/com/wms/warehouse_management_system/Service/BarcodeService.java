package com.wms.warehouse_management_system.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;

import com.google.zxing.common.BitMatrix;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;

import java.io.ByteArrayOutputStream;

@Service
public class BarcodeService {

    public byte[] generateBarcode(
            String text)

            throws Exception {

        BitMatrix matrix =

                new MultiFormatWriter()

                        .encode(

                                text,

                                BarcodeFormat.CODE_128,

                                400,

                                150
                        );

        BufferedImage image =

                new BufferedImage(

                        400,

                        150,

                        BufferedImage.TYPE_INT_RGB
                );

        for(int x=0;x<400;x++)
        {
            for(int y=0;y<150;y++)
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