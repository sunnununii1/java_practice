package day17.practice.controller;

import java.util.Scanner;

import day17.practice.vo.Customer;
import day17.practice.vo.Product;
import day17.practice.vo.Sales;
import day17.interfaceex.RunInterface;
import day17.practice.service.ShopService;
import day17.practice.service.ShopServiceImp;

public class ShopController implements RunInterface {
	
	
	private Scanner sc = new Scanner(System.in);
	
	private Product list[] = new Product[10]; //제품 리스트
	private int count = 0; //저장된 제품 개수
	
	private Customer customerList[] = new Customer[10]; //최대 10명의 고객 리스트
	private int customerCount = 0; //저장된 고객 수
	
	private Sales salesHistory[] = new Sales[100]; //판매 기록
	private int salesCount = 0; //기록된 판매수

	private int totalPrice; //매출 금액
	
	private ShopService shopService = new ShopServiceImp();
	
	
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
				//제품명 입력
				System.out.print("제품명 : ");
				sc.nextLine();
				String name = sc.nextLine();
				
				//제품명의 개수 입력
				System.out.println("수량 : ");
				int amount = sc.nextInt();
				
				//고객 전번 입력
				System.out.println("번호 : ");
				String phoneNumber = sc.next();
				
				int salesCount = 
				shopService.sell(list, count, //제품 리스트 정보
								customerList, customerCount, //고객 리스트
								salesHistory, this.salesCount, // 판매내역 정보
								name, amount, phoneNumber
								);
				if(salesCount == -1) {
					System.out.println("제품 판매 실패");
				} else {
					System.out.println("제품 판매 성공");
					this.salesCount = salesCount;
				}
				break;
			case 2 :
				//입고한 제품 정보 입력받아 제품 객체 생성
				Product product = inputStoreProduct();
				//제품 리스트, 제품 수, 입고된 제품으로 입고관리하라 시킨 것
				//새 제품이 입고된 경우, 제품 리스트에 추가되고 제품 수가 1 증가해야해서
				count = shopService.store(list, count, product);
				break;
			case 3 :
				//제품명을 입력받음
				System.out.println("제품명 : ");
				sc.nextLine();
				String search = sc.nextLine();
				
				//제품 검색 후 출력
				shopService.printProduct(list, count, search);
				break;
			case 4 :
				shopService.printSales(salesHistory, this.salesCount);
				break;
			case 5 : 
				Customer customer = inputRegisterCustomer();
				int count = shopService.registerCustomer(customerList,
														customerCount, customer);
				if(count == -1) {
					System.out.println("고객 등록 실패");
				}else {
					System.out.println("고객 등록 성공");
					customerCount = count;
				}
				break;
			case 6 : 
				break;
			default:
				System.out.println("잘못된 메뉴");
			}
	}


	private Product inputStoreProduct() {
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
			return null;
		}
		
		int index = indexOf(name);	
		
		if(index != -1) {
			Product product = new Product(list[index]);
			product.setAmount(amount);
			return product;
		}
		
		if(count == list.length) {
			System.out.println("제품 리스트 초과");
			return null;
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
		
		Product product = new Product(name, modelName, price, amount, category);
		
		return product;
	}


	private Customer inputRegisterCustomer() {
		//고객 이름 입력받기
		System.out.println("고객이름 : ");
		String name = sc.next();
		//고객 전화번호 입력받기
		System.out.print("전화번호 : ");
		String phoneNumber = sc.next();
		
		return new Customer(name, phoneNumber);
		/*Customer customer = new Customer(name, phoneNumber);
		return customer; */ //윗줄을 풀어쓴 것!
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
		
		
}		

	

