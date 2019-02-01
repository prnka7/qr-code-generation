package com.emxcel.qrcode.services;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.emxcel.qrcode.entity.QrCodeEntity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class GenerateSimpleJSONFile {
	public void simplejson() {

		GenerateQRCode qrCodeObj=new GenerateQRCode();
		try {
			JSONParser jsonParser = new JSONParser();
			JSONArray jsonArray = (JSONArray) jsonParser.parse(
					new FileReader("C:\\Users\\admin\\eclipse-workspace\\qr-QrCodeEntity\\src\\main\\resources\\qrcodes.json"));
			for (Object arrayObj : jsonArray) {
				JSONObject codeobj = (JSONObject) arrayObj;
				System.out.println(qrCodeObj.writeQRCode(new QrCodeEntity(codeobj.get("fullName").toString(),
						codeobj.get("occupation").toString(), codeobj.get("address").toString(),
						codeobj.get("website").toString(), codeobj.get("twitter").toString(),
						codeobj.get("facebook").toString(), codeobj.get("linkedIn").toString())));
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	

}
