package com.emxcel.qrcode.main;

import java.io.File;
import java.util.Scanner;

import com.emxcel.qrcode.services.GenerateQRCode;
import com.emxcel.qrcode.services.GenerateThreadJSONFile;

public class Main {

	public static void main(String args[]) {
		@SuppressWarnings({ "resource", "unused" })
		Scanner sc = new Scanner(System.in);
		File pathForJson = null;
		String storagepath = "";
		GenerateQRCode simpleQrCodeobj = new GenerateQRCode();
		GenerateThreadJSONFile withThreadJsonFileObj = new GenerateThreadJSONFile();
		int size = args.length;
		System.out.println("Size " + size);
		if (size == 2) {
			if (args[0].charAt(0) == '-' && args[0].charAt(1) == 'f') {
				pathForJson = new File(args[1]);
				withThreadJsonFileObj.threadjsonfile(pathForJson, storagepath);

			}
		} else if (size <= 4) {
			if (args[2].length() != 0 && args[2].charAt(0) == '-' && args[2].charAt(1) == 's') {
				pathForJson = new File(args[1]);
				storagepath = args[3];
				withThreadJsonFileObj.threadjsonfile(pathForJson, storagepath);

			}

		} else if (size == 0) {
			simpleQrCodeobj.generateqrcode();
		}

	}

}
