package com.emxcel.qrcode.unittest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.emxcel.qrcode.entity.QrCodeEntity;
import com.emxcel.qrcode.services.GenerateQRCode;

public class SimpleJSONTest {

	@Test
	public void testqrcode() {
		GenerateQRCode testqrcode=new GenerateQRCode();
		String fullName="priyanka";
		String occ="intern";
		String add="dsfds";
		String web="vcvhyt";
		String fb="yjut";
		String twit="qwre";
		String link="oklm";
		
		
		
		
		String storagePath="C:\\Users\\admin\\Desktop\\image\\";
		String qrcode = storagePath + fullName + "-QRCODE.png";
		assertEquals(qrcode,testqrcode.writeQRCode(new QrCodeEntity(fullName,occ,add,web,fb,twit,link)));
		
	}}
