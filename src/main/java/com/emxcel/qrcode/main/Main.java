package com.emxcel.qrcode.main;

import java.io.File;
import java.util.Scanner;

import com.emxcel.qrcode.services.GenerateQRCode;
import com.emxcel.qrcode.services.GenerateThreadJSONFile;

public class Main {

	public static void main(String[] args) {
		@SuppressWarnings({ "resource", "unused" })
		Scanner sc = new Scanner(System.in);
		File pathForJson = null;
		String storagepath = "";
		GenerateQRCode simpleQrCodeobj = new GenerateQRCode();
		GenerateThreadJSONFile withThreadJsonFileObj = new GenerateThreadJSONFile();
		try {

			if ((args != null) && (args.length != 0)) {
				if (args[0].charAt(0) == '-' && args[0].charAt(1) == 'f')
					pathForJson = new File(args[1]);
				if (args[2].length()!=0  && args[2].charAt(0) == '-' && args[2].charAt(1) == 's')
				{
					System.out.println("Inside loop");
					storagepath = args[3];
				}
				else
				{
					System.out.println("Empty");
				}
				withThreadJsonFileObj.threadjsonfile(pathForJson, storagepath);
			} else 
				simpleQrCodeobj.generateqrcode();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
