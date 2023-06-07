package day6.practice;

import java.util.Scanner;

public class AverageEx {

	public static void main(String[] args) {
		// 국어, 영어, 수학 성적을 입력받아 평균을 구하는 코드를 작성하세요. (n을 입력하기 전까지)
		/* 반복문 방법: 1. menu가 n이 아니면 반복(y,n이 아닌 다른 문자 입력시 반복)
		 * 		     2. menu가 y이면 반복(y,n이 아닌 문자 입력시 종료)
		* */
		
		int kor, eng, math;
		char menu = 'y'; // 메뉴 초기화
		double avg;
		Scanner sc = new Scanner(System.in);
		
		
		while(menu != 'n') {
			// 반복문 방법: 1. menu가 n이 아니면 반복(y,n이 아닌 다른 문자 입력시 반복)
			 		  // 2. menu가 y이면 반복(y,n이 아닌 문자 입력시 종료)
			System.out.println("input 3 score(kor, eng, math) : ");								
			kor = sc.nextInt();  // 국, 영, 수 점수 입력
			eng = sc.nextInt();
			math = sc.nextInt();
			
			avg = (kor + eng + math) / 3.0;
			System.out.println("avaerage : " + avg);
			// 평균을 계산 후, 출력
			
			System.out.println("continue? (y/n) : ");
			menu = sc.next().charAt(0);
			
		}
		System.out.println("EXIT!"); //EXIT! 출력
		sc.close();
	}

}
