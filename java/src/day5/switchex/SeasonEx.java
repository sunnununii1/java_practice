package day5.switchex;

import java.util.Scanner;

public class SeasonEx {

	public static void main(String[] args) {
		/* 월을 입력받아 입력받은 월의 계절을 출력하세요. (switch문 활용)
		 * 3,4,5 : 봄
		 * 6,7,8 : 여름
		 * 9,10,11 : 가을
		 * 12, 1, 2 : 겨울
		 * 그 외 : 잘못된 월 
		 */

		int month;
		Scanner sc = new Scanner(System.in);
		System.out.println("input month : ");
		month = sc.nextInt();
		
		
		switch(month) {
		//case 3: case 4: case 5: >>의 경우 사실상 5의 실행문이며, 3,4는 실행문과 break문이 없어서 건너뛰어 5로 가는 것
		case 3: case 4: case 5: // case 3,4,5처럼 콤마로도 가능하나 버전에 따라 안될 수 있어 기본형 기억!
			System.out.println("봄이다.");
			break;
		
		case 6: case 7: case 8:
			System.out.println("여름이다.");
			break;
		
		case 9: case 10: case 11:
			System.out.println("가을이다.");
			break;
		
		case 1: case 2: case 12:
			System.out.println("겨울이다.");
			break;
			
		default : System.out.println("잘못된 월이다.");
	}
		sc.close();
		
	}

}
