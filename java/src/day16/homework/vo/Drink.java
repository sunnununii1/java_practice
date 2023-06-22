package day16.homework.vo;

import lombok.Data;

@Data
public class Drink {

	//멤버변수
	private String name; //음료수 이름
	private int money; 	 //고객이 가진 돈
	private int price;	 //가격
	private int changes; //잔돈
	private int amount;
	
	//생성자
	public Drink(String name, int money, int price, int changes) {
		this.name = name;
		this.money = money;
		this.price = price;
		this.changes = changes;
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
		System.out.println("가진 돈 : " + money);
		System.out.println("음료수 가격 : " + price);
		System.out.println("잔돈 : " + changes);
	}
}
