package com.lec.ch02.ex2_bmi;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyInfoTestMain {
	public static void main(String[] args) {
		String resourceLocation = "classpath:applicationCTX2.xml";
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(resourceLocation);
		//MyInfo myInfo = (MyInfo) ctx.getBean("myInfo");
		MyInfo myInfo = ctx.getBean("myInfo",MyInfo.class);  // 같음
		myInfo.getInfo();
		ctx.close();
	}
}
