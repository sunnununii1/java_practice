package day19.practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ArithmeticEx {

	public static void main(String[] args) {
		// 두 정수와 산술연산자를 입력했을 때 연산결과를 출력하는 코드를 작성해라. 예외처리 추가해서!
		/* input : 1 + 2
		 * 1 + 2 = 3
		 * input : 1 ? 2 또는 1 / 0
		 * Not operator!
		 */

		Scanner sc = new Scanner(System.in);
		System.out.print("input(ex. 1 + 2) : ");

		//두 정수와 산술연산자 입력
		try{
			int num1 = sc.nextInt();
			char op = sc.next().charAt(0);
			int num2 = sc.nextInt();
		
		//연산자에 따른 결과 출력
		
		switch(op) {
		case '+':
			System.out.println("" + num1 + op + num2 + "=" + (num1 + num2));
			break;
		case '-':
			System.out.println("" + num1 + op + num2 + "=" + (num1 - num2));
			break;
		case '*':
			System.out.println("" + num1 + op + num2 + "=" + (num1 * num2));
			break;
		case '/':
			System.out.println("" + num1 + op + num2 + "=" + ((double)num1 / num2));
			break;
		case '%':
			System.out.println("" + num1 + op + num2 + "=" + (num1 % num2));
			break;
		default:
			System.out.println("Not operator!");
			}
		}catch(InputMismatchException e){
			System.out.println("Wrong Input!");
		}catch(ArithmeticException e) {
			System.out.println("Not operation!");
		}catch(Exception e){
			System.out.println("Exception");
		}finally {
			System.out.println("EXIT!");
		}
		test1();
		test2();
		sc.close();
	}
	
	//try-catch-finally문
	//return으로 끝내도, finally로 반드시 들려서 실행시키는 코드!
	public static void test1() {
		try {
			System.out.println(1/0);
		}catch(Exception e) {
			System.out.println("Exception!!");
			return;
		}finally {
			System.out.println("Method1 EXIT!!");
		}
	}

	public static void test2() {
		try {
			System.out.println(1/0);
		}catch(Exception e) {
			System.out.println("Exception!!");
			return;
		}
		System.out.println("Method2 EXIT!!");
	}
	
}
