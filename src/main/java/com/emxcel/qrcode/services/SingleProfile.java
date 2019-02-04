package com.emxcel.qrcode.services;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.emxcel.qrcode.entity.Data;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class SingleProfile {

	private String QRCODE_PATH = "C:\\Users\\admin\\Desktop\\image\\";
	private static final String urlRegex = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
	private static final String facebookRegex = "((http|https)://)?(www[.])?facebook.com/.+";
	private static final String twitterRegex = "http(s)?://(.*\\.)?twitter\\.com/.+";
	private static final String linkedInRegex = "http(s)?:\\/\\/([\\w]+\\.)?linkedin\\.com/.+";

	public void collectData() {
		Pattern urlPattern = Pattern.compile(urlRegex);
		Pattern facebookPattern = Pattern.compile(facebookRegex);
		Pattern twitterPattern = Pattern.compile(twitterRegex);
		Pattern linkPattern = Pattern.compile(linkedInRegex);
		Matcher urlMatcher, facebookMatcher, twitterMatcher, linkMatcher;
		Scanner sc = new Scanner(System.in);
		boolean counter = true;
		System.out.println("Welcome	to	QR	Code	application.");
		String fullname, occupation, address, website, facebook, twitter, linkedin;
		try {
			while (true) {

				do {
					System.out.print("Enter your Full name:");
					fullname = sc.nextLine();
					if (fullname.isBlank())
						counter = false;
					else
						counter = true;
				} while (!counter);
				do {
					System.out.print("Enter your occupation:");
					occupation = sc.nextLine();
					if (occupation.isBlank())
						counter = false;
					else
						counter = true;
				} while (counter = false);
				do {
					System.out.print("Address:");
					address = sc.nextLine();
					if (address.isBlank())
						counter = false;
					else
						counter = true;
				} while (counter = false);
				do {
					System.out.print("Website: ");
					website = sc.nextLine();
					urlMatcher = urlPattern.matcher(website);
					if (!urlMatcher.matches() || website.isBlank()) {
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
					} else
						counter = true;
				} while (!counter);
				do {
					System.out.print("LinkedIn:");
					linkedin = sc.nextLine();
					if (!linkedin.isBlank()) {
						linkMatcher = linkPattern.matcher(linkedin);
						if (!linkMatcher.matches()) {
							counter = false;
							System.out.println("Enter LinkedIn id url properly");
						} else
							counter = true;
					} else
						counter = true;
				} while (!counter);
				System.out.println(writeQRCode(new Data(fullname, occupation, address, website, facebook, twitter, linkedin)));
				System.out.println("QR Code	has	been generated to " + QRCODE_PATH + " " + fullname + ".png");
				System.out.println("\n Press enter for another QR Code or press Q to exit.");
				if (sc.nextLine().toUpperCase().equals("Q"))
					break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
	}

	public String writeQRCode(Data Data) {
		String qrcode = QRCODE_PATH + Data.getFullName() + "-QRCODE.png";
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
