package day16.homework.controller;

import java.util.Scanner;

import day16.homework.run.Run;

import day16.homework.vo.Drink;

public class BeverageMachineEx {

		// 음료수를 뽑는 자판기 프로그램을 작성하세요. (단, 음료수는 사이다, 콜라, 환타 고정)
		// 메뉴를 선택시 음료수와 잔액이 나옴(출력)
		/* 1. 금액 투입
		 * 2. 메뉴 선택
		 * 	1.사이다
		 * 	2.콜라
		 * 	3.환타
		 * 	사이다를 선택했습니다. > (금액있) 사이다가 나옵니다. > 잔돈 xxx이 나옵니다.
		 * 					> (금액부족) 금액이 부족합니다. > 잔돈 xxx이 나옵니다.
		 * 3. 제품 입고
		 * 4. 프로그램 종료
		 */
		
	Scanner sc = new Scanner(System.in);
		
	private Drink drinkList[] = new Drink[10]; //총 10개까지의 음료리스트
	private int drinkCount = 0;
	
		
	public void run() {
	System.out.println("자판기 프로그램 시작");
			
	int menu = -1;
	final int EXIT = 6;
			
		//반복(선택한 메뉴가 종료가 아닐때)
		do {
			//메뉴 출력
			printMenu();
			
			//메뉴 선택
			menu = sc.nextInt();
			
			//선택 메뉴의 기능 실행
			runMenu(menu);
			
		}while(menu != EXIT);	
			System.out.println("프로그램 종료");
		}
		
	private void printMenu() {
		System.out.println("\n메뉴");
		System.out.println("1. 금액 투입");
		System.out.println("2. 메뉴 선택");
		System.out.println("3. 제품 입고");
		System.out.println("4. 프로그램 종료");
		System.out.println("\n메뉴 선택 : ");
		
	}
		
	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			getMoney();
			break;
		case 2:
			getMenu();
			break;
		case 3:
			store();
			break;
		case 4:
			break;
		default :
			System.out.println("잘못된 선택입니다.");
		}
	}
		
	private void getMoney() {
		//넣을 돈 입력
		System.out.print("넣으실 금액 : ");
		int money = sc.nextInt();
		//돈이 0보다 적으면 에러
		if(money < 0) {
			System.out.println("잘못된 입력");
			return;
		}
		//자판기에 입력한 돈 저장하기
	}
		
	private void getMenu() {
		
		//사이다, 콜라, 환타 메뉴 출력
		for() {
			
		}
		
		//금액이 있으면 음료, 잔돈 출력
		
		//없으면 돈이 부족하다는 메세지와 잔돈 출력
	}
		
	private void store() {
		//입고할 제품명 입력
		System.out.println("입고 제품 : ");
		String name = sc.nextLine();
		
		//입고할 제품 수량 입력
		System.out.println("입고 수량 : ");
		int amount = sc.nextInt();
		
		//수량이 음수이면 잘못됐다는 메세지 출력
		if(amount < 0) {
			System.out.println("수량 입력 오류");
			return;
		}
		
	}
		
}


