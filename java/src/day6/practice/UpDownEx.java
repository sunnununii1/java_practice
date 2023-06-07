package day6.practice;

import java.util.Scanner;

public class UpDownEx {

	public static void main(String[] args) {
		// updown 게임코드를 작성하세요.
		// 한판이 끝나면 더 할건지를 물어서 n을 입력하면 종료, y를 입력하면 이어서 게임 진행
		
		/* 외부 반복문 : 게임을 더 진행할 건지 결정하는 반복문
		 * 반복횟수 : 입력받은 문자가 n이 아니면 반복
		 * 규칙성 : up down 게임 한 판 진행
		 * 
		 * 내부 반복문 : up, down 게임을 진행하는 반복문
		 * 반복횟수 : 입력받은 숫자가 랜덤한 숫자와 일치하지 않으면 반복
		 * 규칙성 : 입력받은 숫자가 정답보다 크면 down, 작으면 up, 맞으면 good을 출력
		 * */

		
		//①for문 이용 예제
		/* int min = 1, max = 100;
		int num = min - 1;
		Scanner sc = new Scanner(System.in);
		
		for(char menu = 'y' ; menu != 'n';) {
			int random = (int)(Math.random() * (max-min+1) + min);
			System.out.println("random input : " + random);
			
			for(menu = 'y' ; random != num;) {
				System.out.println("input number (1~100) : ");
				num = sc.nextInt(); 
				
				if(num < random) {
					System.out.println("Up !");
					}else if(num > random) {
					System.out.println("Down !");
					}else {
						System.out.println("Good !");
					}
			}
			System.out.println("Contine? (y/n) : ");
			menu = sc.next().charAt(0);
			}
			System.out.println("Exit");
			sc.close();
			}
		} * */


		//②while문 이용 예제 
		int min = 1, max = 100;
		int num = min - 1;
		char menu = 'y';
		Scanner sc = new Scanner(System.in);
		
		
		while(menu != 'n') {
			int random = (int)(Math.random() * (max-min+1) + min); 
			System.out.println("random input : " + random);
		 
			
			while(random != num) { 
				System.out.println("input number (1~100) : ");
				num = sc.nextInt(); 
			
					if(num < random) {
					System.out.println("Up !");
					}else if(num > random) {
					System.out.println("Down !");
					}else {
						System.out.println("Good !");
					}
			
			}
		System.out.println("Contine? (y/n) : ");
		menu = sc.next().charAt(0);
		}
		System.out.println("Exit");
		sc.close();
	}
	}


//③ do-while문도 가능




