package day4.homework;

import java.util.Scanner;

public class TriangleEx {

	public static void main(String[] args) {
		/* 세 변의 길이를 정수로 입력받아 세 변으로 삼각형을 만들 수 있는지 확인하는 코드를 작성하세요.
		(package : day4.homework, file : TriangleEx)
		세 변 중 작은 두 변의 길이의 합이 큰 변보다 커야 삼각형을 만들 수 있다.
		input 3 integer num : 
		1 2 3 
		Unable to create triangle.
		input 3 integer num : 
		2 2 3 
		Able to create triangle.
		**/
		
		int a, b, c;
		int max; // a,b,c 중 가장 큰 변의 길이
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input 3 integer num : ");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		
		if(a > b ) {
				//a > b 이면 max에 a를 저장
				if(a > c) {
					max = a;
			}
			// 아니면 c를 max에 저장
			else {
				max = c;
			}
		}
	
		// 아니면 b가 c보다 크면 max에 b를 저장
		else if (b > c){
				max = b;
			}
			
			// 아니면 max에 c를 저장
			else {
					max = c;
			}
		
		// max = a> b ? (a > c ? a : c) : (b > c ? b : c); >>같은 결과!
		/* 작은 두 변의 합 > max
		 * 세 변의 합 - max == 작은 두 변의 합
		 * 세 변의 합에서 max를 뺀 값이 max보다 크면 삼각형이라고 출력, 아니면 아니라고 출력
		 */
		if( a + b + c - max > max) {
			System.out.println("Able to create triangle.");
		}
		else {
			System.out.println("Unable to create triangle.");
		}
		
		sc.close();
	}

}
