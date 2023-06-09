package day8.homework;

import java.util.Scanner;

public class MethodScoreEx {

	public static void main(String[] args) {
		// 성적을 입력받아 학점을 출력하는 코드를 작성하세요. (단, 메서드 이용)

		int score;
		Scanner sc = new Scanner(System.in);
		System.out.println("input score : ");
		score = sc.nextInt();
		
		getScore(score);
		
		sc.close();
		
	}
	
	public static void getScore(int score) {
		if(score >=90 && score <=100) {
			System.out.println("A");
		}
		else if(score >=80 && score <90) {
			System.out.println("B");
		}
		else if(score >=70 && score <80) {
			System.out.println("C");
		}
		else if(score >=60 && score <70) {
			System.out.println("D");
		}
		else if(score >=50 && score <60) {
			System.out.println("E");
		}
		else {
			System.out.println("F");
		}
	}

}
