package com.emxcel.qrcode.services;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.emxcel.qrcode.entity.QrCodeEntity;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class GenerateQRCode {

	private String QRCODE_PATH = "C:\\Users\\admin\\Desktop\\image\\";

	public void generateqrcode()  {
		
		String urlRegex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		String facebookRegex = "((http|https)://)?(www[.])?facebook.com/.+";
		String twitterRegex = "http(s)?://(.*\\.)?twitter\\.com/.+";
		String linkedInRegex = "http(s)?:\\/\\/([\\w]+\\.)?linkedin\\.com/.+";
		Pattern urlPattern = Pattern.compile(urlRegex);
		Pattern facebookPattern = Pattern.compile(facebookRegex);
		Pattern twitterPattern = Pattern.compile(twitterRegex);
		Pattern linkPattern = Pattern.compile(linkedInRegex);
		Matcher urlMatcher, facebookMatcher, twitterMatcher, linkMatcher;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		GenerateQRCode codeGenerator = new GenerateQRCode();
		boolean counter = true;
		System.out.println("Welcome	to	QR	Code	application.");
		String fullname, occu, add, web, facebook, twitter, link;
		boolean read=true;
		try {
		do {

			do {
				System.out.print("Enter your Full name:");
				fullname = sc.nextLine();
				if (fullname.isBlank()) {
					counter = false;
				}
			} while (!counter);
			do {
				System.out.print("Enter your Occupation:");
				occu = sc.nextLine();
				if (occu.isBlank()) {
					counter = false;
				}
			} while (counter = false);
			do {
				System.out.print("Address");
				add = sc.nextLine();
				if (add.isBlank()) {
					counter = false;
				}
			} while (counter = false);

			do {
				System.out.print("Website: ");
				web = sc.nextLine();
				urlMatcher = urlPattern.matcher(web);
				if (!urlMatcher.matches() || web.isBlank()) {
					counter = false;
					System.out.println("Enter url properly");
				} else
					counter = true;
			} while (!counter);

			do {
				System.out.print("Facebook:");
				facebook = sc.nextLine();
				if (!facebook.isBlank()) {
					facebookMatcher = facebookPattern.matcher(facebook);
					if (!facebookMatcher.matches()) {
						counter = false;
						System.out.println("Enter facebook id url properly");
					} else
						counter = true;

				}

			} while (!counter);
			do {
				System.out.print("Twitter:");
				twitter = sc.nextLine();
				if (!twitter.isBlank()) {
					twitterMatcher = twitterPattern.matcher(twitter);
					if (!twitterMatcher.matches()) {
						counter = false;
						System.out.println("Enter twitter id url properly");
					} else
						counter = true;
				}
			} while (!counter);

			do {
				System.out.print("LinkedIn:");
				link = sc.nextLine();
				if (!link.isBlank()) {
					linkMatcher = linkPattern.matcher(link);
					if (!linkMatcher.matches()) {
						counter = false;
						System.out.println("Enter LinkedIn id url properly");
					} else
						counter = true;
				}
			} while (!counter);

			System.out.println(
					codeGenerator.writeQRCode(new QrCodeEntity(fullname, occu, add, web, facebook, twitter, link)));
			System.out.println("QR Code	has	been generated to "+QRCODE_PATH+" "+fullname+".png");
			System.out.println("Press enter for	another	QR Code	or press Q to exit");
			String choice=sc.next();
			
			if(choice=="Q"||choice=="q")
			{
				System.exit(0);
			}
			else
			{
				read=true;
			}
		
		} while (!read);
	
	}catch(Exception e)
	{
		e.printStackTrace();
	}
		

	}

	public String writeQRCode(QrCodeEntity QrCodeEntity) {
		String qrcode = QRCODE_PATH + QrCodeEntity.getFullName() + "-QRCODE.png";
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
