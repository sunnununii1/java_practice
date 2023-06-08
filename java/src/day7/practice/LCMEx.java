package day7.practice;

import java.util.Scanner;

public class LCMEx {

	public static void main(String[] args) {
		// 두 정수를 입력받아 두 정수의 최소공배수를 구하는 코드를 작성하시오.
		
		/* 2의 배수 : 2, 4, 6, 8, 10, ..
		 * 공배수 : 공통 배수
		 * 6과 8의 공배수 : 24, 48, 72, ...
		 * 최소 공배수 : 공배수 중 가장 작은 배수
		 * 6과 8의 최소 공배수 : 24
		 */
		
		
		int num1, num2, i; // 두 정수 입력받음
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input 2 numbers : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		// 반복횟수  ① i는 1부터 num1*num2(최소공배수는 두 수의 곱보다 클 수 없다)까지 1씩 증가
		/*		  ② i는 num1부터 num1*num2까지 num1씩 증가
				  => for(i=num1 ; i<=(num1*num2) ; i+=num1)
		**/
		for( i=1 ; i<=(num1*num2) ; i++ ) {
			
			// 규칙성 : i가 num1의 배수이고 i가 num2의 배수이면*, i를 출력 후 반복문 종료
			// => i를 num1로 나누었을 때 나머지가 0과 같고, i를 num2로 나누었을 때 나머지가 0과 같다면* (gcd와 반대)
			if( i % num1 == 0 &&  i % num2 == 0) {
				System.out.println(i);				
				break;
			}
		}
		sc.close();
	}

}
