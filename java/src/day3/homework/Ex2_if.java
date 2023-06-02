package day3.homework;

import java.security.DrbgParameters.NextBytes;
import java.util.Scanner;

public class Ex2_if {

	public static void main(String[] args) {
		// 성별(M:남성, W:여성)을 입력받아 여성인지 확인하는 코드를 작성하세요.
		/* if문 이용.
		 *  M
			Are you a women? man

			input gender : 
			W
			Are you a women? women
		* */
		

		char gender;
		Scanner sc = new Scanner(System.in);
		System.out.println("input gender : ");
		gender = sc.next().charAt(0);
		//String result = "";	
		
		if(gender == 'W') { 
			System.out.println("Are you women? " + "women");
		}
		/*if(gender == 'W') { 
		result = "women";
	}
		**/
		
		if(gender == 'M') {
			System.out.println("Are you women? " + "man");
		}
		/*if(gender == 'M') { 
		result = "man";
	}
		**/
		//이렇게 다른 형식으로도 가능하다
	
	sc. close();
	
	}

}
