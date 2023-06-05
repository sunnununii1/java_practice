package day5.homework;

import java.util.Scanner;

public class UpDownEx {

	public static void main(String[] args) {
		/* 1~100 사이에 랜덤한 정수를 생성하고, 이 정수를 맞추는 게임을 구하시오.
		 * 랜덤한 수 : 45
		 * input : 50
		 * Down !
		 *
		 * input : 40
		 * Up !
		 * 
		 * input : 45
		 * Good !
		 */
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("input : ");
		num = sc.nextInt();
		
		if(num >=1 && num < 45) {
			System.out.println("Up !");
		}
		else if(num == 45) {
			System.out.println("Good !");
		}
		else {System.out.println("Down !");
		}
		
		
		sc.close();
	}

}
