package com.emxcel.qrcode.services;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.emxcel.qrcode.entity.QrCodeEntity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class ThreadRunnableClass implements Runnable {
	private String QRCODEPATH = "E:\\image\\";
	private QrCodeEntity QrCodeEntity;

	public ThreadRunnableClass(QrCodeEntity QrCodeEntity)
	{
		this.QrCodeEntity=QrCodeEntity;
	}

	public void run() {
		// TODO Auto-generated method stub
		writeQRCode(QrCodeEntity);
	}
	public String writeQRCode(QrCodeEntity QrCodeEntity) {
		String qrcode = QRCODEPATH + QrCodeEntity.getFullName() + "-QRCODE.png";
		QRCodeWriter writer = new QRCodeWriter();
		try {
			BitMatrix bitmatrix = writer.encode(QrCodeEntity.toString(), BarcodeFormat.QR_CODE, 350, 350);
			Path path = FileSystems.getDefault().getPath(qrcode);
			MatrixToImageWriter.writeToPath(bitmatrix, "PNG", path);
		} catch (WriterException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return qrcode;
	}


}
