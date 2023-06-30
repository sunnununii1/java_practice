package day22.practice.phone.controller;

import java.util.Scanner;

import day22.practice.phone.vo.PhoneBook;

public class PhoneManager implements Program {
			
	private Scanner sc = new Scanner(System.in);
	private static final int EXIT = 4;
	private PhoneBook pb = new PhoneBook();

	@Override
	public void printMenu() {
		System.out.println("1. 전화번호 등록");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 검색");
		System.out.println("4. 종료");
		System.out.println("1. 메뉴 선택 : ");
	}
	
	@Override
	public void run() {
		int menu;
		do {
			System.out.println("========");
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			System.out.println("========");
		
		}while(menu != EXIT);
		sc.close();
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertNumber();
			break;
		case 2:
			update();
			break;
		case 3:
			search();
			break;
		case 4:
			System.out.println("종료");
			break;
		default:
			System.out.println("잘못된 입력");
		}
		
	}

	private void insertNumber() {
		//이름, 전화번호 입력받기
		System.out.println("이름 : ");
		String name = sc.next();
		
		System.out.println("전화번호 : ");
		String number = sc.next();
		
		//추가 성공시 성공 메세지 출력
		if(pb.insertPhone(name, number)) {
			System.out.println("등록 성공");
		}else { //실패시 실패 메세지 출력
			System.out.println("등록 실패");
		}
	}
	
	private void update() {
		//이름, 수정할 이름과 수정할 전화번호 입력받기
		System.out.println("이름 : ");
		String name = sc.next();
		
		System.out.println("수정할 이름 : ");
		String updateName = sc.next();
			
		System.out.println("전화번호 : ");
		String number = sc.next();
		
		//전화번호부에 수정 후 성공하면 성공 메세지 출력
		if(pb.update(name,updateName, number)) {
			System.out.println("수정 성공");
		}else { //실패시 실패 메세지 출력
			System.out.println("수정 실패");
		}
	}
	
	private void search() {
		//검색할 이름 입력
		System.out.println("이름 : ");
		String name = sc.next();
		
		//검색 결과 출력
		//equals가 아닌 contains인 이유 : 해당 단어가 일부 있어도 검색되도록 하려고
		pb.print(s->s.getName().contains(name));
		//pb.print(s->true); //전체 출력을 의미!
		
	}
}


