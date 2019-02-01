package com.emxcel.qrcode.services;

import com.google.zxing.*;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class QRCodeReader {

	@SuppressWarnings("unused")
	public StringBuilder decodecode() {
		try {
			File file = new File("C:\\Users\\admin\\Desktop\\image\\priyanka-QRCODE.png");
			StringBuilder sb = new StringBuilder("MyString");
			
			StringBuilder decodedText =new StringBuilder(decodeQRCode(file));
			if (decodedText == null) {
				System.out.println("No QR Code found in the image");
			} else {
				System.out.println("Decoded text = " + decodedText);
				
			}
			return decodedText;
		} catch (IOException e) {
			System.out.println("Could not decode QR Code, IOException :: " + e.getMessage());
		}
		return null;
	}

	private static String decodeQRCode(File qrCodeimage) throws IOException {
		BufferedImage bufferedImage = ImageIO.read(qrCodeimage);
		LuminanceSource source = new BufferedImageLuminanceSource(bufferedImage);
		BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

		try {
			Result result = new MultiFormatReader().decode(bitmap);
			return result.getText();
		} catch (NotFoundException e) {
			System.out.println("There is no QR QrCodeEntity in the image");
			return null;
		}
	}
}
