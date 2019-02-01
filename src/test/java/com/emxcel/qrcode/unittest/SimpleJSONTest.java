package com.emxcel.qrcode.unittest;

import static org.junit.Assert.*;
import org.junit.Test;

import com.emxcel.qrcode.entity.QrCodeEntity;
import com.emxcel.qrcode.services.GenerateQRCode;
import com.emxcel.qrcode.services.QRCodeReader;

public class SimpleJSONTest {

	@Test
	public void testqrcode() {
		GenerateQRCode testqrcode=new GenerateQRCode();
		QRCodeReader readcodetest=new QRCodeReader();
		String fullName="priyanka";
		String occ="intern";
		String add="dsfds";
		String web="vcvhyt";
		String fb="yjut";
		String twit="qwre";
		String link="oklm";
		
		
		testqrcode.writeQRCode(new QrCodeEntity(fullName,occ,add,web,fb,twit,link));
		String str=new StringBuilder().append(fullName).append(occ).append(add).append(web).append(fb).append(twit).append(link).toString();
		String str1=readcodetest.decodecode().toString();
		assertEquals(str,str1);
		
	}}
