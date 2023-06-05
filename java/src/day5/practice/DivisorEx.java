package day5.practice;

import java.util.Scanner;

public class DivisorEx {

	public static void main(String[] args) {
		/* 정수 num을 입력받아 num의 약수를 구하는 코드를 작성해라
		 * 약수 : A를 B로 나누었을 때 나머지가 0이면 B는 A의 약수이다.
		 * 12의 약수 : 1, 2, 3, 4, 6, 12
		 */
		/* 반복횟수 : i는 1부터 num까지 1씩 증가
		 * 규칙성 : i가 num의 약수이면 i를 출력
		 *       => num를 i로 나누었을 때 나머지(중요*)가 0과 같다면 i 출력
		 */
		
		int num, i; // 초기화
		Scanner sc = new Scanner(System.in);
		System.out.println("input positive number : "); // 정수 입력
		num = sc.nextInt();
		
		i = 1; // 약수는 1부터 시작해서
		while(i <= num) {
			if(num % i == 0) //  num를 i로 나누었을 때 나머지가 0과 같다면* (~하면*)
			System.out.println(i); // i를 출력
			
			++i; // (증감식) 1씩 증가
		}
		
		sc.close();
		
		
		
		/* 1.초기화
		 * 2. while(조건식) {
		 * 			실행문;
		 * 			증감식;
		 * 			}
		 * 형식으로 수업 진행함 유의!
		 */

	}

}
