package com.lec.loop_반복문;

public class Ex03_for {
// 중첩 반복문 
	public static void main(String[] args) {

		for (int j = 1; j <= 5; j++) { // 5회 반복 j가 1부터 5까지 반복
			for (int i = 1; i <= j; i++) { // j회 반복
				System.out.print("*");
			} // for -i
			System.out.println(); // 개행
		} // for -j

	} // main

} // class
