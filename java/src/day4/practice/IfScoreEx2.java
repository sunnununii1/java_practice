package day4.practice;

import java.util.Scanner;

public class IfScoreEx2 {

	public static void main(String[] args) {
		
		/* score가 0 미만이거나 100 초과이면 wrong score! 출력
		 * 90 이상 A
		 * 80 이상 B
		 * 70 이상 C
		 * 60 이상 D
		 * 아니면 F
		 */
		
		
		int score;
		Scanner sc = new Scanner(System.in);
		System.out.println("input score : ");
		score = sc.nextInt();
		
		if(score < 0 || score > 100) {
			System.out.println("wrong score!");
		}
		else if(score >=90) {
			System.out.println("A");
		}
		else if(score >=80) {
			System.out.println("B");
		}
		else if(score >=70) {
			System.out.println("C");
		}
		else if(score >=60) {
			System.out.println("D");
		}
		else {
			System.out.println("F");
		}
		//wrong score를 맨 앞 if에 둠으로써 아래 조건식이 더 간단하게 출력됨
		
		sc.close();
		
	}

}
