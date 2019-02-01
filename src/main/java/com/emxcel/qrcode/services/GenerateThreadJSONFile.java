package com.emxcel.qrcode.services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.emxcel.qrcode.entity.QrCodeEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

public class GenerateThreadJSONFile {
	public void threadjsonfile() {
		File file = new File("C:\\Users\\admin\\eclipse-workspace\\qr-QrCodeEntity\\src\\main\\resource\\temp.json");
		GenerateThreadJSONFile threadobj = new GenerateThreadJSONFile();
		String extension = threadobj.getFileExtension(file.getName());
		ExecutorService service = Executors.newFixedThreadPool(10);
		if (extension.equals("json")) {
			List<QrCodeEntity> QrCodeEntities = GenerateThreadJSONFile.transform(file);
			System.out.println("Total persons to be imported : " + QrCodeEntities.size());

			for (QrCodeEntity c : QrCodeEntities) {
				Runnable threadJsonrun = new ThreadRunnableClass(c);
				service.execute(threadJsonrun);
			}
		} else {
			System.err.println("The given file format is not supported");
		}
		service.shutdown();
	}

	private String getFileExtension(String fileName) {

		if (fileName.lastIndexOf(".") > -1) {
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		}
		return null;
	}

	public static List<QrCodeEntity> transform(File source) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, QrCodeEntity.class);
			return mapper.readValue(source, type);
		} catch (IOException e) {
			System.out.println("Malformed JSON in file.");
			return null;
		}
	}
}
