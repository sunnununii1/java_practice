package day8.homework;

import java.util.Scanner;

public class MethodMonthEx {

	public static void main(String[] args) {
		// 월을 입력받아 월에 맞는 영어를 출력하세요. (단, 메서드 이용)
		/* 예 :
		 * input month :
		 * 3
		 * March
		 */

		int month;
		Scanner sc = new Scanner(System.in);
		System.out.println("input month :");
		month = sc.nextInt();
		
		Month(month);
		
		sc.close();
	}
	
	public static void Month(int month) {
		switch(month) {
		case 1:
			System.out.println("January");
		break;
		case 2:
			System.out.println("Fabruary");
		break;
		case 3:
			System.out.println("March");
		break;
		case 4:
			System.out.println("April");
		break;
		case 5:
			System.out.println("May");
		break;
		case 6:
			System.out.println("June");
		break;
		case 7:
			System.out.println("July");
		break;
		case 8:
			System.out.println("August");
		break;
		case 9:
			System.out.println("Semtember");
		break;
		case 10:
			System.out.println("October");
		break;
		case 11:
			System.out.println("Nomember");
		break;
		case 12:
			System.out.println("Desember");
		break;
		
		default :
			System.out.println("Wrong Month");
		}
	}
		
}

