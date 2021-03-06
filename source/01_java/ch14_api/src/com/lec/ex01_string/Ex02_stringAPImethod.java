package com.lec.ex01_string;

public class Ex02_stringAPImethod {
	public static void main(String[] args) {
		String str1 = "abcXabc";
		String str2 = new String("ABCXabc");
		String str3 = "      ja    va   ";
		// 자바는 항상 0부터 시작
		System.out.println("1. "+str1.concat(str2)); // str1 + str2  = abcXabcABCXabc  스트링 두개 더해주는것 .concat
		System.out.println("2. "+str1.substring(3)); // .substring(n) = n번째 숫자부터 끝까지 출력. 근데 n번쨰숫자는 0번부터 시작임
		// ex)   "hello" 있으면 h=0 e=1 l=2 l=3 o=4 이런식으로 1번부터시작이 아니라 0번부터 시작
		System.out.println("3. "+str1.substring(3,5)); // 3번째부터 5번째 앞까지  Xa
		// .substring(n,m) = n번째부터 m번째 앞까지 
		System.out.println("4. "+str1.length());  // .length 글자 길이 
		System.out.println("5. "+str1.toUpperCase()); // 대문자로 변환 ABCXABC
		System.out.println("6. "+str1.toLowerCase()); // 소문자로 변환 abcxabc
		System.out.println("7. "+str1.charAt(3)); // 3번째 문자를 반환 'x'
		
		System.out.println("8. "+str1.indexOf('b')); // 첫번째 'b'가 나오는 인덱스 1
		System.out.println("9. "+str1.indexOf('b',3)); // 3번째부터 검색해서 첫번째 b의 위치 5
		System.out.println("10. "+str1.indexOf("abc")); //  첫번째 "abc"가 나오는 위치  0
		System.out.println("11. "+str1.indexOf("abc",3)); // 3번째부터 검색해서 "abc" 위치 4
		System.out.println("12. "+str1.indexOf('z')); // 없으면 -1 리턴
		System.out.println("13. "+str1.lastIndexOf('b')); // 마지막'b'의 위치  위치 
		System.out.println("14. "+str1.lastIndexOf('b',3));  // 3번째부터 맨 마지막 b의 위치 1
		
		System.out.println("15. "+str1.equals(str2));  // str1 과 str2 가 같은 문자열인지 false
		System.out.println("16. "+str1.equalsIgnoreCase(str2)); // 대소문자 구분하지않고 str1과 str2가 같은 문자열인지 그래서 true
		
		str1 = "abcXabc";
		str2 = new String("ABCXabc");
		str3 = "      ja    va   ";
		
		System.out.println("17. "+str3.trim()); // 앞,뒤 공백을 제거      ja  va
		System.out.println("18. "+str1.replace('a','9'));  // a를 9로 수정해라   9bcX9bc
		System.out.println("19. "+str1.replace("abc","#")); // "abc"를  "#" 으로 바꿔라
		System.out.println("20. str3의 space를 없애기 "+str3.replace(" ",""));  // 스페이스 하나를 없애기
		System.out.println("21. "+str1.replaceAll("abc", "Z")); // "abc"를 "Z"로 바꿔라
		System.out.println("22. "+str1.replace("abc", "Z")); 	// "abc"를 "Z"로 바꿔라  
		/* 정규표현식 :  https://goo.gl/HLntbd
		 *  연습장 : http://www.nextree.co.kr/p4327		 
		 */
		String str = "안녕Hello";
		System.out.println("23. "+str.replaceAll("[a-zA-Z]",""));  // 알파벳을 ""로 수정
		System.out.println("24. "+str.replaceAll("[가-힣]", ""));  // 한글문자를 "" 로 수정
		
		// 문자열 메소드는 문자열을 수정 안함
		// 진짜 str을 바꾸는것이 아님
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		// 하나도 안바뀜
		
		
		
		
		
	}
}
