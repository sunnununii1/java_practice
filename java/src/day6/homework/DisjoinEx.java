package day6.homework;

import java.util.Scanner;

public class DisjoinEx {

	public static void main(String[] args) {
		// 두 정수를 입력받아 두 정수가 서로소 관계인지 판별하는 코드를 작성하세요.
		/* 서로소 : 최대 공약수가 1인 두 수의 관계
		 * input : 2 numbers : 3 4
		 * Disjoint! (서로소)
		 * input : 2 numbers : 8 4
		 * Not Disjoint! (서로소 아님)
		 */
		
		// day6.practice > GCDEx 참고!
		 
		
		int num1, num2;
		Scanner sc = new Scanner(System.in);
		System.out.println("input : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		int i = 1;
		int gcd = 1;
		while(i <= num1) {
		// i는 1부터 num1까지 반복
			if(num1 % i == 0 && num2 % i == 0) {
			/*규칙성 : i가 num1의 약수이고, i가 num2의 약수이면 i를 gcd에 저장
					->num1을 i로 나누었을 때 나머지가 0과 같고,
		 		  	  num2를 i로 나누었을 때 나머지가 0과 같다면 
		 	* */
			gcd = i; // i를 gcd에 저장
			}
		++i; // 1씩 증가
		}
		
		
		// 반복문 종료 후 : gcd가 1이면 Disjoint! 출력, 아니면 Not Disjoint! 출력
		if(gcd == 1) {
			System.out.println("Disjoint!");
		}
		else {System.out.println("Not Disjoint!");
		}
		
		sc.close();
	}

}
