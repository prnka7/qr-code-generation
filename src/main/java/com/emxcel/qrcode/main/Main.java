package com.emxcel.qrcode.main;

import java.io.File;
import com.emxcel.qrcode.services.SingleProfile;
import com.emxcel.qrcode.services.MultipleProfile;

public class Main {

	public static void main(String args[])  {
		
		File pathForJson = null;
		String storagepath = "";
		SingleProfile simpleQrCodeobj = new SingleProfile();
		MultipleProfile withThreadJsonFileObj = new MultipleProfile();
		 try {
		int size = args.length;
		if (size == 2) {
			if (args[0].charAt(0) == '-' && args[0].charAt(1) == 'f') {
				pathForJson = new File(args[1]);
				withThreadJsonFileObj.createQrCode(pathForJson, storagepath);

			}
		} else if (size == 4) {
			if (args[2].length() != 0 && args[2].charAt(0) == '-' && args[2].charAt(1) == 's') {
				pathForJson = new File(args[1]);
				storagepath = args[3];
				withThreadJsonFileObj.createQrCode(pathForJson, storagepath);
				}
		} else if (size == 0) {
			simpleQrCodeobj.collectData();
		}
		 }catch(Exception e)
		 { e.printStackTrace();}
		

	}

}
