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
		
		
		
		int min = 1, max = 100;
		int num = min - 1; // 최솟값 - 1은 랜덤에서 나올 수 없는 숫자 <로 초기화
		Scanner sc = new Scanner(System.in);
		
		
		int random = (int)(Math.random() * (max-min+1) + min); 
		System.out.println("random input : " + random);
		
		 
		while(random != num) { 
			 
			System.out.println("input number (1~100) : ");
			num = sc.nextInt(); // 정수를 입력
			
			if(num < random) {
			System.out.println("Up !");
			}else if(num > random) {
			System.out.println("Down !");
			}else {
				System.out.println("Good !");
			}
			// 정수와 정답을 비교해서 판별
			
		}
		sc.close();
		}
		
		
	}
	


