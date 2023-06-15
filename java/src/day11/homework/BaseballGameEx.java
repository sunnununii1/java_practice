package day11.homework;

import java.util.Scanner;

import array.Array;

public class BaseballGameEx {

	public static void main(String[] args) {
		// 숫자 야구 게임을 구현하세요. 1~9 사이의 중복되지 않은 세 수를 맞추는 게임
		/* 규칙 : B: 같은 숫자가 있지만 위치가 다름
		 * 		 S: 같은 숫자가 있고 위치가 같음
		 *		 30: 일치하는 숫자가 하나도 없음
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
		
		/* 풀이 순서
		 * 1. 맞춰야 할 숫자 3개 랜덤 생성(중복X)
		 * 2. 반복문 사용
		 * 	 2-1. 사용자가 숫자 3개를 입력
		 * 3. 판별하기
		 */
		
		int com[] = new int[3];
		int user[] = new int[3];
		//1. 랜덤한 수를 저장할 배열과 사용자 입력 수 저장할 배열
		int min = 1, max = 9;
		
		int strike = 0; //스트라이크
		int ball = 0; //볼의 갯수
		Scanner sc = new Scanner(System.in);
		
		Array.createRandomArray(min, max, com);
		//Array.printArray(com); //얜 나중에 주석처리
		//1. 맞춰야할 숫자 3개 랜덤생성
		
		//반드시 한번은 실행되는 반복문 == do
		do {
			//2-1. 사용자가 숫자 3개 입력
			System.out.print("user : ");
			for(int i = 0 ; i<user.length ; i++) {
				user[i] = sc.nextInt();
			}
			//사용자 입력 체크
			if(Array.arrayCheck(user)) {
				System.out.println("You must not enter the same number!");
				continue;
			}
			
			//3. 판별
			//스트라이크 갯수 판별
			strike = strike(com,user);
	
			//볼의 갯수 판별
			ball = ball(com,user);
	
			//스트라이크와 볼의 갯수에 맞게 출력
			printResult(strike,ball);

		} while(strike < 3);
		
		System.out.println("Good!");
		sc.close();
	}

	/** 스크라이크 개수를 판별하는 메서드
	 * => 두 배열에서 같은 번지에 있는 값들이 몇개 같은지 알려주는 메서드
	 * 매개변수 : 두 배열 => int arr1[], int arr2[]
	 * 리턴타입 : 같은 번지에 있는 값들이 몇개 같은지 => 몇개 => 정수 => int
	 * 메서드명 : strike 
	 * */
	public static int strike(int arr1[], int arr2[]) {
		//배열 생성이 안됨, 배열이 하나라도 있으면 비교할 수 없어서 0으로 리턴
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		//배열의 개수가 다른 경우 작은 크기의 배열의 기준으로 비교위해 size 계산
		int size = arr1.length < arr2.length ? arr1.length : arr2.length;
		
		int count = 0; //스트라이크 개수
		for(int i = 0 ; i<size; i++) {
			//같은 번지에 있는 값들이 서로 같을시(스트라이크일 때)
			if(arr1[i] == arr2[i]) {
				count++;
			}
		}
		return count;
	}
	/** 볼의 개수를 판별하는 메서드
	 * => 두 배열에서 다른 번지에 있는 값들이 몇개 같은지 알려주는 메서드
	 * 매개변수 : 두 배열 => int arr1[], int arr2[]
	 * 리턴타입 : 다른 번지에 있는 값들이 몇개 같은지 => 몇개 => 정수 => int
	 * 메서드명 : strike 
	 * */
	public static int ball(int arr1[], int arr2[]) {
		//배열 생성이 안됨, 배열이 하나라도 있으면 비교할 수 없어서 0으로 리턴
		if(arr1 == null || arr2 == null) {
			return 0;
		}
		
		//방법 1.
		int count = 0;
		//다른 번지를 비교해서 찾아도 되나, 두 배열에서 같은 숫자의 개수에서 스트라이크 갯수 뺴면 볼 개수가 됨
		for(int tmp :arr1) {
			//배열1에서 꺼낸 값이 배열2에 있으면 개수를 증가 
			if(Array.contains(arr2, tmp, arr2.length)) {
				count++;
			}
		}
		return count - strike(arr1, arr2);
		
		//방법2. 이중 반복문 이용해서 다른 번지 비교하는 코드
		/*for(int i = 0 ; i<arr1.length ; i++) {
			for(int j = 0; j<arr2.length ; j++) {
				if(i ==j) {
					continue;
				}
				if(arr1[i] == arr2[i]) {
					count++;
				}
			}
		}
		return count;
		*/
	}
	/** 스트라이크와 볼의 개수가 주어지면 결과를 출력하는 메서드
	 * 매개변수 : 스트라이크 개수, 볼의 개수 => int strike, int ball
	 * 리턴타입 : 출력이라 없음 => void
	 * 메서드명 : printResult
	 */
	public static void printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.print(strike + "S");
		}
		if(ball != 0) {
			System.out.print(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.print("3O");
		}
		System.out.println();
	}
}
