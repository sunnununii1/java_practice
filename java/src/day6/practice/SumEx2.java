package day6.practice;

import java.util.Scanner;

public class SumEx2 {

	public static void main(String[] args) {
		/* n을 입력받아 1부터 n까지 짝수의 합을 구하는 코드를 작성하세요.
		   input : 10
		   1~10 even sum : 30
		 * */
		
		int n, i =1, sum = 0; // i는 1부터, sum 초기값은 0
		Scanner sc = new Scanner(System.in);
		System.out.println("input : ");
		n = sc.nextInt(); // n을 입력받음
		
		while(i <= n) {
			 // i가 짝수이면 누적
			if(i % 2 == 0) {
			// i가 n보다 작거나 같으면 반복
				sum += i;
			}
			++i;
		}// 반복문을 이용하여 n까지 짝수의 합을 계산
		
		
		
		System.out.println("1~" + n + " even sum : " + sum);
		sc.close();
	}

}
