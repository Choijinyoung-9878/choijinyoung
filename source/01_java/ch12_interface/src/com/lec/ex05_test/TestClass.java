package com.lec.ex05_test;

// 물려 받은것 : i1,i2,i3,m1(추상),m2(추상),m3(추상)
// 실제 있는것 : i1, i2, i3, m1(일반), m2(일반), m3(일반)
public class TestClass implements I3 {

	@Override
	public void m1() {
		System.out.println("상수 i1 = " + i1);
	}

	@Override
	public void m2() {
		System.out.println("상수 i2 = " + i2);
	}

	@Override
	public void m3() {
		System.out.println("상수 i3 = " + i3);
	}

}
