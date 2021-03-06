package com.lec.ch05.ex2;

import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain2 {
	public static void main(String[] args) {
		String location = "classpath:META-INF/applicationCTX2.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(location);
		Student2 student = ctx.getBean("student2",Student2.class);
		Worker2 worker = ctx.getBean("worker2",Worker2.class);
		System.out.println("==============================");
		student.getStudentInfo();  // 핵심 기능
		System.out.println("==============================");  
		System.out.println();
		System.out.println("==============================");  
		worker.getWorkerInfo();  // 핵심 기능
		System.out.println("==============================");  
		
	}
}

