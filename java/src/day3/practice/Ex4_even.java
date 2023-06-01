package day3.practice;

import java.util.Scanner;

public class Ex4_even {

	public static void main(String[] args) {
		// 정수 num을 입력받아 num이 홀수인지 짝수인지 판별코드를 작성해라.
		/* num을 2로 나누었을 때, 나머지가 0이 아니면 홀수
		* num을 2로 나누었을 때, 나머지가 0이면 짝수
		*/
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("input number : ");
		num = sc.nextInt();
		
		if(num % 2 != 0) {
			System.out.println(num + "은 홀수이다.");
		}

		if(num % 2 == 0) {
		System.out.println(num + "은 짝수이다.");
		}

		sc.close();
	
	}
	
	

}
