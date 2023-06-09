package day8.practice;

import java.util.Scanner;

public class MethodMultipleEx {

	public static void main(String[] args) {
		// 정수 num을 입력받아 2,3,6의 배수인지 아닌지 판별하는 코드 작성해라 (단, 메서드 이용)
		// System.out.println(MethodEvenNumberEx.isMultiple(4,2));
	
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("input number : ");
		num = sc.nextInt();
		
		if(EvenNumber1(num,6)) {
			System.out.println("multiple of 6");
		}
		else if(num % 3 == 0) {
			System.out.println("multiple of 3");
		}
		else if(num % 2 == 0) {
			System.out.println("multiple of 2");
		}
		else {
			System.out.println("not a multiple of 2,3,6");
		}
		
		isEvenNumber(num);
		
		if(EvenNumber2(num)) {
			System.out.println("multiple of 6");
		}
		else if(num % 3 == 0) {
			System.out.println("multiple of 3");
		}
		else if(num % 2 == 0) {
			System.out.println("multiple of 2");
		}
		else {
			System.out.println("not a multiple of 2,3,6");
		}
		
		sc.close();
	}
	
	/**
	 * 매개변수 : 두 정수 => int num1, int num2
	 *  리턴타입 : 2,3,6의 배수인지(참) 아닌지(거짓) => boolean
	 * 메서드명 : EvenNumber1
	 */
	public static boolean EvenNumber1(int num1, int num2) {
		return num1 % num2 == 0;
	}
	
	/**
	 * 매개변수 : 판별할 정수 => int num
	 * @return 없음 ==> void
	 * 메서드명 : isEvenNumber
	 */
	public static void isEvenNumber(int num) {
		if(num % 6 == 0) {
			System.out.println("multiple of 6");
		}
		else if(num % 3 == 0) {
			System.out.println("multiple of 3");
		}
		else if(num % 2 == 0) {
			System.out.println("multiple of 2");
		}
		else {
			System.out.println("not multiple of 2,3,6");
		}
	}
	
	/**
	 * 매개변수 : 판별할 정수 => int num
	 *  리턴타입 : 2,3,6의 배수인지(참) 아닌지(거짓) => boolean
	 * 메서드명 : EvenNumber2
	 */
	public static boolean EvenNumber2(int num) {
		return num%6==0 && num%3==0 && num%2==0;
	}
	
}
