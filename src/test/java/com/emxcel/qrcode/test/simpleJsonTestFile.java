package com.emxcel.qrcode.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.emxcel.qrcode.entity.Data;
import com.emxcel.qrcode.services.SingleProfile;

public class simpleJsonTestFile {

	@Test
	public void testqrcode() {
		SingleProfile testqrcode=new SingleProfile();
		String fullName="priyanka";
		String occ="intern";
		String add="dsfds";
		String web="vcvhyt";
		String fb="yjut";
		String twit="qwre";
		String link="oklm";
		
		
		
		
		String storagePath="C:\\Users\\admin\\Desktop\\image\\";
		String qrcode = storagePath + fullName + "-QRCODE.png";
		assertEquals(qrcode,testqrcode.writeQRCode(new Data(fullName,occ,add,web,fb,twit,link)));
		
	}}
