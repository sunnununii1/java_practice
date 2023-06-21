package day16.homework.vo;

import lombok.Data;

@Data
public class Drink {

	//멤버변수
	private String name; //음료수 이름
	private int money; 	 //고객이 가진 돈
	private int price;	 //가격
	private int changes; //잔돈
	
	//생성자
	public Drink(String name, int money, int price, int changes) {
		this.name = name;
		this.money = money;
		this.price = price;
		this.changes = changes;
	}
	
	//메서드
	public void print() {
		System.out.println("음료수 이름 : " + name);
		System.out.println("가진 돈 : " + money);
		System.out.println("음료수 가격 : " + price);
		System.out.println("잔돈 : " + changes);
	}
}
