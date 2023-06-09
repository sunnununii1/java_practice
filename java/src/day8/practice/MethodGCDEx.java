package day8.practice;

import java.util.Scanner;

public class MethodGCDEx {

	public static void main(String[] args) {
		// 정수 num1과 num2를 입력받아 두 정수의 최대 공약수를 구하는 코드를 작성하세요. (단, 메서드 이용)

		int num1, num2;
		Scanner sc = new Scanner(System.in);
		System.out.println("input 2 numbers : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		int gcd = GCD(num1, num2);
		System.out.println("gcd is : " + gcd);
		
		sc.close();
		
	}
	public static boolean isMultiple(int num1, int num2) {
		return num1 % num2 == 0;
	}
	
	/**
	 * 매개변수 : 두 정수 => int num1, int num2
	 * 리턴타입 : 최대 공약수 => 정수 => int
	 * 메서드명 : GCD
	 */
	public static int GCD(int num1, int num2) {
		for(int i = num1 ; i >=1; --i) {
			//i가 num1의 약수이다 == num1은 i의 배수이다
			if(isMultiple(num1, i) && isMultiple(num2,i)) {
				return i;
			}
		}
		return 1;
	}

}
