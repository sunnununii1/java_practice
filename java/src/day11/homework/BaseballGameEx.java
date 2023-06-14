package day11.homework;

import java.util.Scanner;

public class BaseballGameEx {

	public static void main(String[] args) {
		// 숫자 야구 게임을 구현하세요. 1~9 사이의 중복되지 않은 세 수를 맞추는 게임
		/* 규칙 :
		 *  B: 같은 숫자가 있지만 위치가 다름
		 *  S: 같은 숫자가 있고 위치가 같음
		 *  30: 일치하는 숫자가 하나도 없음
		 *  
		 *  예.	랜덤숫자: 1 9 5 
		 * 		사용자 : 1 2 3
		 * 			1S
		 * 		사용자 : 4 5 6
		 * 			1B
		 * 		사용자 : 1 2 9
		 * 			1S1B
		 * 		사용자 : 2 3 4
		 * 			30
		 * 		사용자 : 1 9 5
		 * 			3S
		 * 			Good!
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int min = 1, max = 9;
		
		int[] random = new int[3];
		int[] intput = new int[3];
		
		int S = 0;
		int B = 0;
		
		for(int i=1 ; i<=random.length ; i++) {
			random[0] = (int)(Math.random() * (max-min+1) + min); 
			random[1] = (int)(Math.random() * (max-min+1) + min); 
			if(random[0] == random[1]) {
					i--;
					break;//같을시 전단계로+빠져나옴			
				}
			random[3] = (int)(Math.random() * (max-min+1) + min); 
			if(random[0] == random[3]) {
				i--;
				break;			
			}
			
			
			for(int j=0 ; j<i ; j++) {
				
			}
		}
	
	}

}
