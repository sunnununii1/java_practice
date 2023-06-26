package day16.homework.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
//@AllArgsConstructor /생성자 자동생성
public class Drink {

	//멤버변수
	private String name; //음료수 이름
	private int price;	 //가격
	private int amount;
	
	//생성자
	public Drink(String name, int price, int amount) {
		this.name = name;
		this.price = price;
		this.amount = amount;
	}
	
	
	//메소드
		/** 제품의 입고 기능을 알려주는 메소드 => 현재 수량에 추가 수량을 더해 누적
		 * 매개변수 : 추가할 수량 => int amount
		 * 리턴타입 : void
		 * 메소드명 : store
		 */
		public void store(int amount) {
			if(amount < 0) {
				return;
			}
			this.amount += amount;
		}
	
	//메서드
	public void print() {
		System.out.println("음료수 이름 : " + name);
		System.out.println("음료수 가격 : " + price);
		System.out.println(" : " + amount);
	}
}
