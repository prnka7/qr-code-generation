package com.emxcel.qrcode.services;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.emxcel.qrcode.entity.Data;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class RunnableEncoder implements Runnable {
	private String storagePath;
	private Data Data;

	public RunnableEncoder(Data Data,String storagePath)
	{
		this.Data=Data;
		this.storagePath=storagePath;
	}
	public void run() {
		writeQRCode(Data,storagePath);
	}
	public String writeQRCode(Data Data,String storagePath) {
		if(storagePath.equals("")) {
			storagePath="E:\\image\\";}
		String qrcode = storagePath + Data.getFullName() + "-QRCODE.png";
		QRCodeWriter writer = new QRCodeWriter();
		try {
			BitMatrix bitmatrix = writer.encode(Data.toString(), BarcodeFormat.QR_CODE, 350, 350);
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
