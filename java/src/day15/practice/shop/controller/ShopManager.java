package day15.practice.shop.controller;

import java.util.Scanner;

import day15.practice.shop.vo.Customer;
import day15.practice.shop.vo.Product;
import day15.practice.shop.vo.Sales;

public class ShopManager {
	
	
	private Scanner sc = new Scanner(System.in);
	
	private Product list[] = new Product[10]; //제품 리스트
	private int count = 0; //저장된 제품 개수
	
	private Customer customerList[] = new Customer[10]; //최대 10명의 고객 리스트
	private int customerCount = 0; //저장된 고객 수
	
	private Sales salesHistory[] = new Sales[100]; //판매 기록
	private int salesCount = 0; //기록된 판매수
	
	private int totalPrice; //매출 금액
	
	
	public void run() {
		System.out.println("프로그램 시작");
		
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
		System.out.println("===================");
		System.out.println("메뉴");
		System.out.println("1. 제품 판매");
		System.out.println("2. 제품 입고");
		System.out.println("3. 제품 조회");
		System.out.println("4. 매출 조회");
		System.out.println("5. 고객 등록");
		System.out.println("6. 프로그램 종료");
		System.out.println("메뉴 선택 :");
	}
	
	private void runMenu(int menu) {
		System.out.println("===================");
		
			switch(menu) {
			case 1 :
				sell();
				break;
			case 2 :
				store();
				break;
			case 3 :
				printProduct();
				break;
			case 4 :
				printSales();
				break;
			case 5 : 
				registerCustomer();
				break;
			case 6 : 
				break;
			default:
				System.out.println("잘못된 메뉴");
			}
	}

	
	private void sell() {
		//판매할 제품명 입력받음
		System.out.print("제품명 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		//제품명의 개수 입력
		System.out.println("수량 : ");
		int amount = sc.nextInt();
		
		//고객 정보 입력
		System.out.println("번호 : ");
		String phoneNumber = sc.next();
		
		
		//있는 제품인지(제품명, 제품수량) 확인
		int index = indexOf(name);
		if(index < 0) {
			System.out.println("제품명 오류");
			return;
		}
		if(amount < 0) {
			System.out.println("제품 수량 오류");
			return;
		}
		//있는 고객인지
		int customerIndex = indexOfCustomer(phoneNumber);
		if(customerIndex < 0) {
			System.out.println("전화번호 오류");
			return;
		}
		
		
		//판매 내역에 추가
		//판매 정보 => 복사 생성자 이용하여 제품 정보 복사 필요(반드시 깊은 복사로!)
									//list[index]는 창고 안 제품들을 의미
		Product product = new Product(list[index]);
		product.setAmount(amount);
		//고객 정보
		Customer customer = customerList[customerIndex];
		
		Sales sales = new Sales(customer,product);
		salesHistory[salesCount++] = sales;
		
		//판매된 개수만큼 재고량에서 빼주기
		list[index].release(amount);
		//매출 금액을 추가
		totalPrice += sales.getTotalPrice();
		
		System.out.println(totalPrice);
		
	}
	

	private void store() {
		//입고할 제품명 입력
		System.out.println("제품명 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		//입고할 제품 수량
		System.out.println("수량 : ");
		int amount = sc.nextInt();
		
		//수량이 음수로 입력되면 오류 있다는 메세지 출력
		if(amount < 0) {
			System.out.println("입고 수량이 잘못되었습니다.");
			return;
		}
		
		/*제품 리스트에서 입고할 제품명이 있는지 없는지 찾기
		제품 배열에 있는 제품명과 입고할 제품명이 같은지 확인 => 같으면 위치 기억*/
		int index = indexOf(name);	
		
		/*있으면, 입고할 제품 수량만큼 해당 제품에 입고해줌
		=> 위치가 0 이상이면*/
		if(index != -1) {
			list[index].store(amount);
			System.out.println("입고 완료");
			return;
		}
		/*없으면, 제품 리스트에 제품 정보를 추가해줌(입고할 수량도 함께)
		=> 위치가 -1이면*/
		//최대치로 등록되어 있으면
		if(count == list.length) {
			System.out.println("제품 리스트 초과");
			return;
		}
		//모델명 입력
		System.out.println("새 제품 등록");
		System.out.print("모델명 : ");
		sc.nextLine();
		String modelName = sc.nextLine();
			
		//가격 입력
		System.out.print("가격 : ");
		int price = sc.nextInt();
			
		//분류 입력
		System.out.print("분류 : ");
		String category = sc.next();
			
		//제품 리스트에 추가
		list[count++] = new Product(name, modelName, price, amount, category);
			
		System.out.println("제품 추가 후 입고 완료");
	}
		
	
	//제품을 검색해서 조회하는 메소드
	private void printProduct() {
		//검색할 제품 입력받음
		System.out.print("제품명 : ");
		sc.nextLine();//엔터. 이전 입력에서 엔터가 있어서 제거
		
		String name = sc.nextLine();
		
		//입력한 검색어에 맞는 제품 출력
		//등록된 제품들 중 검색어와 일치하는 제품 위치 확인
		int index = indexOf(name);
			
		//있으면 제품 정보 출력
		if(index >= 0) {
			list[index].print();
			return; //리턴 안쓰면 else처리 따로 해야함
		}
		//없으면 없다고 출력(return으로 대신함)
		System.out.println("없는 제품");
	}
		

	private void printSales() {
		//매출 내역 출력
		for(int i=0; i<salesCount; i++) {
			salesHistory[i].print();
		}
		
		//누적 매출액 출력
		System.out.println("누적 매출액 : " + totalPrice);
	}


	private void registerCustomer() {
		//고객 이름 입력받기
		System.out.println("고객이름 : ");
		String name = sc.next();
		//고객 전화번호 입력받기
		System.out.print("전화번호 : ");
		String phoneNumber = sc.next();
		
		//고객 리스트에 등록하기
		//전화번호 중복시 등록X => 전화번호 조회
		for(int i=0; i<customerCount; i++) {
			  //i번지에 있는 고객정보. i번지 고객의 전화번호. 두 개가 같으면 등록실패
			if(customerList[i].getPhoneNumber().equals(phoneNumber)) {
				System.out.println("이미 등록된 번호입니다. 등록 실패");
				return;
			}
		}
		//새로운 전화번호면 등록O
		//입력받은 고객 정보를 이용해 고객 객체 생성 후, 마지막 고객 다음에 새 고객 추가하고 등록 고객 수 증가시킴
		customerList[customerCount++] = new Customer(name, phoneNumber);
	}

	
		/** 제품 리스트에 제품명과 일치하는 제품이 있으면 있는 위치를 알려주는 메서드
		 * 만약 없으면, -1로 함
		 * 매개변수 : 제품명 => String name
		 * 리턴타입 : 위치 => 번지 => 정수 => int
		 * 메서드명 : intdexOf(주소나 번지 찾는 단어)
		 */
		public int indexOf(String name) {
			for(int i=0; i<count; i++) {
				if(list[i].getName().equals(name)) {
					return i;
				}
			}
			return -1;
		}
		

		private int indexOfCustomer(String phoneNumber) {
			for(int i=0; i<customerCount; i++) {
				//고객의 번호가 같으면
				if(customerList[i].getPhoneNumber().equals(phoneNumber)) {
					return i;
				}
			}
			return -1;
		}
		
}		

	

