package day4.homework;

import java.util.Scanner;

public class NumberEx {

	public static void main(String[] args) {
		/* 정수 num가 짝수이면 num에 2를 나누고,
		 * 정수 num가 홀수이면 num에 1을 더한 후,
		 * num를 출력하는 코드를 작성하세요.
		 */
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("input number : ");
		num = sc.nextInt();
		// 정수 입력
		
		
		if(num % 2 == 0) {
			num = num / 2;
			//num /= 2; 도 가능
		}
		else {
			num = num + 1;
			//num += 1; 도 가능
		}
		
	
			
		System.out.println(num);
		sc.close();
	}


	
	
}
