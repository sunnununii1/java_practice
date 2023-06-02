package day4.practice;

import java.util.Scanner;

public class IfMutipleEx1 {

	public static void main(String[] args) {
		// 정수 num를 입력받아 num가 2의 배수인지 아닌지 판별코드를 작성하세요.
		// n의 배수 문제 = 홀짝 판별 문제
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("input number : ");
		num = sc.nextInt();
		
		if(num % 2 == 0) {
			System.out.println("2의 배수이다.");
		}
		else{
			System.out.println("2의 배수가 아니다.");
		}

		sc.close();
	}

}
