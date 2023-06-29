package day22.phone.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import day22.phone.vo.Phone;

public class PhoneManager {
	private List<Phone> list = Arrays.asList();
			
	private Scanner sc = new Scanner(System.in);
	private static final int EXIT = 4;

	public void run() {
		int menu;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			
		}while(menu != EXIT);
		sc.close();
	}

	private void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertNumber();
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			System.out.println("종료");
			break;
		default:
			System.out.println("잘못된 입력");
		}
		
	}

	private void printMenu() {
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 검색");
		System.out.println("4. 종료");
		System.out.println("1. 메뉴 선택 : ");
	}
	
	private void insertNumber() {
		System.out.println("이름 : ");
		String name = sc.nextLine();
		
		sc.nextLine();
		
		System.out.println("전화번호 : ");
		String phoneNumber = sc.nextLine();
		
		list.add(name);
		
	}
}
