package day5.practice;

import java.util.Scanner;

public class PrimeNumberEx {

	public static void main(String[] args) {
		/* 정수 num을 입력받아 num이 소수인지 아닌지를 판별하는 코드를 작성해라
		 * 소수 : 약수가 1과 자기 자신밖에 없는 수
		 * 소수 : 2,3,5,7,11,13
		 */
		
		/* 반복횟수 : i는 1부터 1씩 증가
		 * 규칙성 : i가 num의 약수이면 약수의 개수 count 1증가
		 *      => num을 i 로 나누었을 때 나머지가 0과 같다면 약수의 개수 count 출력
		 * 종료 후 : count가 2이면 소수, 아니면 소수 아님 출력
		 */

		int num, i, count = 0; // 초기화
		Scanner sc = new Scanner(System.in);
		System.out.println("input positive number : ");
		num = sc.nextInt();
		
		// i는 1부터 1씩 증가(반복문)
		i = 1;
		while(i <= num) {
			// i가 num의 약수이면 약수의 개수 count 1증가(규칙성)
			if( num % i == 0) {
				count++;
			}
			++i;
		}
		
		// count가 2이면 소수라고 출력, 아니면 소수가 아니라고 출력
		if(count == 2) {
			System.out.println(num + " is a prime number.");
		}
		else {
			System.out.println(num + " is not a prime number.");
		}
		
		sc.close();
		
	}

}
