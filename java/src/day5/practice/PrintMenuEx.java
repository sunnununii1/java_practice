package day5.practice;

import java.util.Scanner;

public class PrintMenuEx {

	public static void main(String[] args) {
		/* 다음과 같은 메뉴를 출력하고 프로그램 종료를 선택하기 전까지 반복적으로 실행되는 코드를 작성하세요.
		 * Menu
		 * 1. Start
		 * 2. Save
		 * 3. Exit
		 * Select Menu : 
		 * 1 [입력]
		 * Program Start!
		 * Menu
		 * 1. Start
		 * 2. Save
		 * 3. Exit
		 * Select Menu : 
		 * 2 [입력]
		 * Program Save!
		 * Menu
		 * 1. Start
		 * 2. Save
		 * 3. Exit
		 * Select Menu : 
		 * 3 [입력]
		 * Program Exit!
		 */
		/* 반복횟수 : menu가 3이 아닐 때 까지
		 * 규칙성 : 메뉴를 출력 > 메뉴를 입력 > 입력받은 메뉴에 따라 콘솔에 출력
		 *        > 입력받은 메뉴가 1이면 Program Start!
		 *        > 입력받은 메뉴가 2이면 Program Save!
		 *        > 입력받은 메뉴가 3이면 Program Exit!
		 */
		
		int menu = 0;
		
		Scanner sc = new Scanner(System.in);
	
		while(menu != 3) {
			System.out.println("Menu");
			System.out.println("1. Start");
			System.out.println("2. Save");
			System.out.println("3. Exit");
			System.out.println("Select Menu : ");
		
		menu = sc.nextInt();
		
		
		// if문도 가능
		switch(menu) {
		case 1:
			System.out.println("Program Start!");
			break;
		case 2:
			System.out.println("Program Save!");
			break;
		case 3: 	
			System.out.println("Program Exit!");
			break;
		}
		}
		sc.close();

	}

}
