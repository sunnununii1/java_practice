package day15.practice.shop.vo;

import lombok.Data;

@Data
public class Product {
	//멤버 변수 : 제품 판매와 관련된 정보가 필요
	private String name; //제품명
	private String modelName;//모델명
	private int price;//가격
	private int amount;//수량(판매 수량일 수도, 전체 재고량일 수도 있음)
	private String category;//분류
	
	//생성자
	public Product(String name, String modelName, int price, int amount, String category) {
		this.name = name;
		this.modelName = modelName;
		this.price = price;
		this.amount = amount;
		this.category = category;
	}
	
	//sell 판매정보의 복사생성자(깊은복사)
	public Product(Product product) {
		this.name = product.name;
		this.modelName = product.modelName;
		this.price = product.price;
		this.amount = product.amount;
		this.category = product.category;
	}

	//메소드
	/** 제품의 입고 기능을 알려주는 메소드 => 현재 수량에 추가 수량을 더해 누적
	 * 매개변수 : 추가할 수량 => int amount
	 * 리턴타입 : void
	 * 메소드명 : store
	 */
	public void store(int amount) {
		//창고에 제품을 추가해야하는데 음수면 성립X
		if(amount < 0) {
			return;
		}
		this.amount += amount;
		//accumulate(amount); //amount를 양수와 음수로 설정 후 윗줄 대신 사용가능
	}
	
	/** 제품 출고 기능을 알려주는 메소드 => 현재 수량에서 주어진 수량 감소시킴 */
	public void release(int amount) {
		if(amount < 0) {
			return;
		}
		this.amount -= amount;
		//accumulate(-amount);
	}
	private void accumulate(int amount) {
		this.amount += amount;
	}

	public void print() {
		System.out.println("제품명 : name");
		System.out.println("모델명 : modelName");
		System.out.println("분류 : category");
		System.out.println("재고 : amount");
		System.out.println("가격 : price");
	}
	
}
