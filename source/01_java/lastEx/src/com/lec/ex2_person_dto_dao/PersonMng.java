package com.lec.ex2_person_dto_dao;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonMng {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PersonDao dao = PersonDao.getInstance();
		String fn;
		ArrayList<PersonDto> dtos;
		do {
			System.out.print("1:입력 | 2:직업별 조회 | 3:전체조회 | 그 외:종료");
			fn = sc.next();
			switch (fn) {
			case "1": // 이름, 직업명, 국, 영 , 수 입력
				System.out.print("입력할 이름 ? : ");
				String pname = sc.next();
				System.out.print("직업(배우|가수|MC)은 ? : ");
				String jname = sc.next();
				System.out.print("국어점수는 ? :");
				int kor = sc.nextInt();
				System.out.print("영어점수는 ? :");
				int eng = sc.nextInt();
				System.out.print("수학점수는 ? : ");
				int mat = sc.nextInt();
				int result = dao.insertPerson(new PersonDto(pname, jname, kor, eng, mat));
				System.out.println(result == PersonDao.SUCCESS ? "입력성공" : "입력실패");
				break;

			case "2":
				System.out.println("조회할 직업 ? : ");
				jname = sc.next();
				dtos = dao.selectJname(jname);
				if (dtos.isEmpty()) {
					System.out.println("해당 직업의 사람이 없습니다.");
				} else {
					System.out.println("rank\t이름\t\t직업명\t국어\t영어\t수학\t합계");
					for (PersonDto d : dtos) {
						System.out.println(d);
					}
				}
				break;
			case "3":
				dtos = dao.selectAll();
				if (dtos.size() != 0) {
					System.out.println("rank\t이름\t\t직업명\t국어\t영어\t수학\t합계");
					for (PersonDto d : dtos) {
						System.out.println(d);
					}
				} else {
					System.out.println("등록된 사람이 없습니다.");
				}
				break;

			}
		} while (fn.equals("1") || fn.equals("2") || fn.equals("3"));
		sc.close();
		System.out.println("Bye");
	}
}
