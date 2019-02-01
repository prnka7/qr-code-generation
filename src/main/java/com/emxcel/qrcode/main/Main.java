package com.emxcel.qrcode.main;

import java.util.Scanner;

import com.emxcel.qrcode.services.GenerateQRCode;
import com.emxcel.qrcode.services.GenerateSimpleJSONFile;
import com.emxcel.qrcode.services.GenerateThreadJSONFile;


public class Main {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		GenerateQRCode simpleQrCodeobj = new GenerateQRCode();
		GenerateSimpleJSONFile withoutThreadJsonFileObj = new GenerateSimpleJSONFile();
		GenerateThreadJSONFile withThreadJsonFileObj = new GenerateThreadJSONFile();
	
		int i = 1;
		do {
			System.out.println("Welcome	to	QR	Code	application");
			System.out.println("1.Generate QR QrCodeEntity by entering details one-by-one");
			System.out.println("2.Generate QR Code with the help of JSON File without thread ");
			System.out.println("3.Generate QR Code with the help of JSON File with thread ");
			System.out.println("4.Exit");
			System.out.println("Enter Your choice");
			int userchoice = sc.nextInt();
			switch (userchoice) {
			case 1:
				simpleQrCodeobj.generateqrcode();
				break;
			case 2:
				withoutThreadJsonFileObj.simplejson();
				break;
			case 3:
				withThreadJsonFileObj.threadjsonfile();
				break;
			case 4:
				System.exit(0);
				break;
			default:
				System.out.println("Enter Proper Choice");
			}
		} while (i >= 1);

	}

}
