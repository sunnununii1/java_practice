package day2.homework;

import java.util.Scanner;

public class Homework2 {

	public static void main(String[] args) {
		
	/*두 정수를 입력받아 두 정수의 산술 연산 결과를 출력하는 코드를 작성하세요. 단, 2번째 숫자는 0이 아님.
	 * 예 : 두 정수를 입력하세요.
	 * 1 2 [엔터]
	 * 1 + 2 =3
	 * 1 - 2 = -1
	 * 1 * 2 = 2
	 * 1 / 2 = 0.5
	 * 1 % 2 = 1
	 */
		
		System.out.println("두 정수를 입력하세요.");
		Scanner sc = new Scanner(System.in); //스캐너 생성(통째로 외우기)
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		//두 정수를 입력받음
		
		int sum = num1 + num2;
		int sub = num1 - num2;
		int mul = num1 * num2;
		double div = (double)num1 / num2;
		int mod = num1 % num2;
		//두 정수의 산술연산을 계산
		
		System.out.println(num1 + "+" + num2 + "=" + sum);
		System.out.println(num1 + "-" + num2 + "=" + sub);
		System.out.println(num1 + "*" + num2 + "=" + mul);
		System.out.println(num1 + "/" + num2 + "=" + div);
		System.out.println(num1 + "%" + num2 + "=" + mod);
		//System.out.println(num1 + "%" + num2 + "=" + (num1 % num2)); // 이런 식으로 마지막에 직접 연산 삽입도 가능
		//%는 +보다 우선순위가 높아서 () 생략가능. 다른 연산은 () 필수
		
		sc.close();
	}

}
