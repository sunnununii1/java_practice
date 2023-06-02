package day4.practice;

import java.util.Scanner;

public class IfArithmeticEx {

	public static void main(String[] args) {
		// 산술 연산자(op)와 두 정수를 입력받아 산술연산자에 맞는 연산 결과를 출력하는 코드를 작성하세요.
		/* 1) input 2 nums and operator :
		 * 1 + 2 [엔터]
		 * 1 + 2
		 * 2) input 2 nums and operator :
		 * 1 ? 2 [엔터]
		 * ? is not arithmetic operator!
		 */
		
		int num1, num2;
		char op;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input 2 nums and operator(ex: 1 + 2) :");
		num1 = sc.nextInt();
		op = sc.next().charAt(0);
		num2 = sc.nextInt();
		
		int sum = num1 + num2;
		int sub = num1 - num2;
		int mul = num1 * num2;
		double div = (double)num1 / num2;
		int mod = num1 % num2;
	
		
		if(op == '+') {
			System.out.println(num1 + " " + op + " " + num2 + " = " + sum);}
		else if(op == '-') {
			System.out.println(num1 + " " + op + " " + num2 + " = " + sub);}
		else if(op == '*') {
			System.out.println(num1 + " " + op + " " + num2 + " = " + mul);}
		else if(op == '/') {
			System.out.println(num1 + " " + op + " " + num2 + " = " + div);}
		else if(op == '%') {
			System.out.println(num1 + " " + op + " " + num2 + " = " + mod);}
		else{
			System.out.println(op + " is not arithmetic operator!");}
		

		sc.close();
	}

}
