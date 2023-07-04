package day16.homework.controller;

import java.util.Scanner;

import day16.homework.vo.Drink;

public class BeverageMachine {

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
		
	private Scanner sc = new Scanner(System.in);
	private final static int EXIT = 4; //프로그램 종료 번호
	
	
	private Drink list[] = new Drink[3]; //총 3개까지의 음료리스트
	private int money; //자판기 안 금액
	
	//음료수별 번지를 상수로 지정 
	private final static int SPRITE = 0;
	private final static int COKE = 1;
	private final static int FANTA = 2;
	
	
	private void printMenu() {
		System.out.println("============");
		System.out.println("금액 : " + money);
		System.out.println("============");
		System.out.println("메뉴");
		System.out.println("1. 금액 투입");
		System.out.println("2. 메뉴 선택");
		System.out.println("3. 제품 입고");
		System.out.println("4. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	public void run() {
		int menu;
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택
			menu = sc.nextInt();
			System.out.println("============");
			
			//메뉴에 따른 기능 실행
			runMenu(menu);
		}while(menu != EXIT);
	}
	
	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertCoin();
			break;
		case 2:
			selectBeverage();
			break;
		case 3:
			insertBeverage();
			break;
		case 4:
			break;
		default:
			System.out.println("잘못된 메뉴!");	
		}

	}

	//음료 배출
	private void generate(int beverage) {
		int amount = list[beverage].getAmount();
		if(amount<=0) {
			System.out.println("제고 없음!");
			return;
		}
		int money =list[beverage].getPrice(); 
		if(this.money < money) {
			System.out.println("금액 부족!");
			return;
		}
		//음료수 배출 시 수량 1 감소 
		list[beverage].setAmount(amount-1);
		this.money -= money;

		System.out.println(getBeverage(beverage)+"가 나옴");
		System.out.println("거스름돈 : " + this.money);
		this.money = 0;
	}
	
	//선택한 음료(정수)에 따른 음료수명(문자열)을 알려주는 메서드
	private String getBeverage(int beverage) {
		switch(beverage) {
		case SPRITE: return "사이다";
		case COKE: return "콜라";
		case FANTA: return "환타";
		default: return "없음";
		}
	}

	private void insertCoin() {
		System.out.print("금액 투입 : ");
		int money = sc.nextInt();
		this.money += money;
	}

	//음료 선택
	private void selectBeverage() {
		System.out.println("1. 사이다 : " + list[SPRITE].getPrice());
		System.out.println("2. 콜라  : " + list[COKE].getPrice());
		return;
	}
	
	private void insertBeverage() {
		System.out.println("1. 사이다");
		System.out.println("2. 콜라");
		System.out.println("3. 환타");
		System.out.print("음료 선택 : ");
		
		int selectBeverage = sc.nextInt() - 1;
		System.out.print("수량 : ");
		int amount = sc.nextInt();
		//콜라, 사이다, 환타를 입력하면 입고, 아니면 알림메세지 출력.
		switch (selectBeverage) {
		case COKE:
		case SPRITE:
		case FANTA:
			store(selectBeverage, amount);
			break;
		default:
			System.out.println("잘못 선택!");
			return;
		}
	}

	private void store(int selectBeverage, int amount) {
		if(amount < 0) {
			System.out.println("수량 오류!");
			return;
		}
		//선택한 음료수를 입고
		list[selectBeverage].store(amount);
		System.out.println("입고 완료!");
	}
}
		