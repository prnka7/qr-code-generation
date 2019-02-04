package com.emxcel.qrcode.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.emxcel.qrcode.entity.Data;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class MultipleProfile {
	public void createQrCode(File filePath, String storagePath) {
		System.out.println("Proecessing File.....");
		String extension = getFileExtension(filePath.getName());
		ExecutorService service = Executors.newFixedThreadPool(10);
		if (extension.equals("json")) {
			List<Data> Datas = MultipleProfile.transform(filePath);
			System.out.println("Total " + Datas.size() + " profile found for QR Code generation...");
			System.out.println("Generating QR Codes....");
			for (Data c : Datas) {
				Runnable threadJsonrun = new RunnableEncoder(c, storagePath);
				service.execute(threadJsonrun);
			}
		} else {
			System.err.println("The given file format is not supported");
		}
		if (storagePath == "") {
			storagePath = "E:\\image\\";
			System.out.println("QR Code has been generated to " + storagePath);

		} else {
			System.out.println("QR Code has been generated to " + storagePath);
		}
		service.shutdown();
	}
	private String getFileExtension(String fileName) {
		if (fileName.lastIndexOf(".") > -1) {
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		}
		return null;
	}
	public static List<Data> transform(File source) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, Data.class);
			return mapper.readValue(source, type);
		} catch (IOException e) {
			System.out.println("Malformed JSON in file.");
			return null;
		}
	}
}
