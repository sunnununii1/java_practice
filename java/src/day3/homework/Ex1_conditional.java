package day3.homework;

import java.util.Scanner;

public class Ex1_conditional {

	public static void main(String[] args) {
		// 성별(M:남성, W:여성)을 입력받아 여성인지 확인하는 코드를 작성하세요.
		/* 조건 연산자 이용.
		 *  M
			Are you a women? false

			input gender : 
			W
			Are you a women? true
		* */
		
		char gender;
		Scanner sc = new Scanner(System.in);
		System.out.println("input gender : ");
		gender = sc.next().charAt(0);
		//nextLine은 빈 문자열까지 포함되는 거라 쓰지 않음
		boolean result = gender == 'W' ?  true : false;
		
		
		System.out.println("Are you a women? " + result);
		
		sc.close();
		
		/*String gender;
		Scanner sc = new Scanner(System.in);
		System.out.println("input gender : ");
		 * gender = sc.next();
		boolean result = gender.equals("W" )?  true : false;
		System.out.println("Are you a women? " + result);
		*
		* 위처럼도 가능
		* */
		
	}

}
