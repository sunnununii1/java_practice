package day2.scanner;

import java.util.*; // java 안에 모든 클래스(*)를 가져오겠다는 뜻
// ctrl+shift+o 단축키

public class ScannerEx {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // system.in : 표준입력, 표준입력을 이용해서 스캐너를 생성
		
		System.out.println("정수를 입력해주세요.");
		int num1 = sc.nextInt(); // nextInt : 정수를 입력받음
		System.out.println(num1);
		
		System.out.println("실수를 입력해주세요.");
		double num2 = sc.nextDouble(); // nextDouble : 실수를 입력받음
		System.out.println(num2);
		
		System.out.println("문자열1을 입력하세요.");
		sc.nextLine(); // 
		String str1 = sc.nextLine(); // nextLine : 스페이스를 포함한 문자열 한 줄 전부를 읽어옴(ex. 안녕 잘가 엔터<까지)
		System.out.println(str1);
		
		System.out.println("문자열2을 입력하세요.");
		String str2 = sc.next(); // next : 첫번째 문자부터 읽어와서 다음 공백(엔터, 스페이스)이 오기 전까지 읽어옴 (ex. 안녕 잘가 엔터<처음 안녕까지)
		System.out.println(str2);
		
		System.out.println("문자를 입력하세요.");
		char ch = sc.next().charAt(0); // charAt : next()를 이용하여 한 단어를 읽어오고 읽어온 단어의 첫글자를 가져옴 (sc.nextLine();를 선언하지 않으면 입력 메소드에 남아있던 글자가 올 수 있다.)
		System.out.println(ch);
		
		sc.close(); // close()로 닫지 않아도 크게 문제는 없지만 안쓰면 주의표시가 생김
	}

}
