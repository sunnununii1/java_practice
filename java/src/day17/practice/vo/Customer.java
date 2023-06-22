package day17.practice.vo;

import lombok.Data;

@Data
public class Customer {

	//CID00001처럼 표시되도록 함
	private String customerId;	//고객 추가시 자동발급
	private String name;
	private String phoneNumber;

	//고객 아이디 발급 위한 클래스 변수
	//등록된 고객의 수를 의미
	private static int count;	
	//고객 아이디의 앞 부분
	private final static String CID = "CID";
	//고객 아이디의 뒷 부분
	private final static int MAX_SIZE = 5;

	
	//생성자
	public Customer(String name, String phoneNumber) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		generateCustomerId(); //customerId 발급이 완료됨
	}

	//ShopServiceImp에서 고객번호 1씩 증가위한 코드
	public Customer(Customer customer) {
		this.name = customer.name;
		this.phoneNumber = customer.phoneNumber;
		this.customerId = customer.customerId;
	}


	private void generateCustomerId() {
		//1 => 00001 로 맞춰주기
		//숫자를 문자열로(1 => "1")
		String num = "" + ++count; //문자열 + 정수 => 문자열
		//"1".length == 1"
		int length = num.length();
					//-랭스 이유 : 숫자 부분 제외한 나머지를 빼줘야해서
		for(int i=0; i<MAX_SIZE - length; i++) {
			num = "0" + num;	
		}
		
		customerId = CID + num;
		
	}
	
	//메소드
	public void print() {
		System.out.println("고객번호	: " + customerId);
		System.out.println("고객이름	: " + name);
		System.out.println("전화번호	: " + phoneNumber);
	}
}


