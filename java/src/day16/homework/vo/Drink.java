package day16.homework.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Drink {

	private int price;
	private int amount;
	
	public void store(int amount) {
		if(amount < 0) {
			return;
		}
		this.amount += amount;
	}
}
