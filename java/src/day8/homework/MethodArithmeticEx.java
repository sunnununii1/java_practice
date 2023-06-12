package day8.homework;

import java.util.Scanner;

public class MethodArithmeticEx {

	public static void main(String[] args) {
		// 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 코드를 작성하세요. (단, 메서드 사용)
		/* 1. 연산자를 잘못 입력한 경우는 없다고 가정함
		 * 2. 0으로 나누는 일은 없다고 가정함 (ex. 1/0)
		 */
	
		int num1, num2;
		char operator;
		double res;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input (ex: 1 + 2) : ");
		num1 = sc.nextInt();
		operator = sc.next().charAt(0);
		num2 = sc.nextInt();
		
		res = arithmetic(num1, operator, num2);
		System.out.println(num1 + " " + operator + " " + num2 + " = " + res);
		
		res = arithmetic2(num1, operator, num2);
		System.out.println(num1 + " " + operator + " " + num2 + " = " + res);
		
		sc.close();
	}
	
	/** 두 정수와 산술 연산자가 주어지면 산술 연산 결과를 알려주는 메서드
	 * 매개변수 : 두 정수와 산술 연산자 =>  int num1, char operator, int num2 (순서 자유)
	 * 리턴타입 : 산술 연산 결과 => 실수 => double
	 * 메서드명 : arithmetic
	 */
	public static double arithmetic(int num1, char operator, int num2) {
		double res = 0.0; //초기값 설정
		switch(operator) { //if문도 가능
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num1 - num2;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num1 / (double)num2;
			break;
		case '%':
			res = num1 % num2;
			break;
			
		default:
		//throw new RuntimeException("Wrong operator!");
		//잘못된 연산자인 경우 예외처리를 해야하는데, 아직 배우지 않아서 주석처리함(당장은 불필요한 줄)
			
		}
		return res;
	}
	
	// switch-case문 안에 return이 들어가면 break문 필요없음!
	public static double arithmetic2(int num1, char operator, int num2) {
		switch(operator) { 
		case '+':
			return num1 + num2;
			// break; //위에 return이 있기 때문에 break가 실행될 일은 없음 => 에러
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		case '/':
			return num1 / (double)num2;
		case '%':
			return num1 % num2;
			
		default:
			return 0.0; // switch문 밖에다 두기도 가능
		}
		
	}
}

