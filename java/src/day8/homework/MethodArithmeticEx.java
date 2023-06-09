package day8.homework;

import java.util.Scanner;

public class MethodArithmeticEx {

	public static void main(String[] args) {
		// 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 코드를 작성하세요. (단, 메서드 사용)
		/* 1. 연산자를 잘못 입력한 경우는 없다고 가정함
		 * 2. 0으로 나누는 일은 없다고 가정함 (ex. 1/0)
		 */
	
		int num1, num2;
		int sum;
		Scanner sc = new Scanner(System.in);
		System.out.println("input 2 number : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		int res1 = Sum(num1,2);
		System.out.println(num1 + " + " + num2 + " = " + res1);
		
		int res2 = Sub(num1,2);
		System.out.println(num1 + " - " + num2 + " = " + res2);
		
		int res3 = Mul(num1,2);
		System.out.println(num1 + " * " + num2 + " = " + res3);
		
		double res4 = Div((double)num1,2);
		System.out.println(num1 + " / " + num2 + " = " + res4);
		
		int res5 = Mod(num1,2);
		System.out.println(num1 + " % " + num2 + " = " + res5);
		
		sc.close();
	}
	
	public static int Sum(int num1, int num2) {
		int res1 = num1 + num2;
		return res1;
	}
	public static int Sub(int num1, int num2) {
		return num1 - num2;
	}
	public static int Mul(int num1, int num2) {
		return num1 * num2;
	}
	public static double Div(double num1, int num2) {
		return num1 / num2;
	}
	public static int Mod(int num1, int num2) {
		return num1 % num2;
	}
}
