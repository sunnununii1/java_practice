package day3.homework;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

public class H1 {

	public static void main(String[] args) {
		// 성별(M:남성, W:여성)을 입력받아 여성인지 확인하는 코드를 작성하세요.
		/* 조건연산자 이용.
		 *  M
			Are you a women? false

			input gender : 
			W
			Are you a women? true
			* */

		char ch;
		Scanner sc = new Scanner(System.in);
		System.out.println("input gender : ");
		ch = sc.next().charAt(0);
		String result = ch == 'w' ? "true" : "false";
				
		if(ch == 'w') { 
		System.out.println("Are you women?" + result);
		}
				
		if(ch == 'm') {
		System.out.println("Are you women?" + result);
		}
		
	
	sc. close();
	
	}

}
