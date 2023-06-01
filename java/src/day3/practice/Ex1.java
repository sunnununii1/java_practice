package day3.practice;

import java.util.Scanner;

public class Ex1 {

	public static void main(String[] args) {
		// 성적을 입력받아 입력받은 성적이 60점 이상인지 확인하는 코드를 작성하세요.
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input score : ");
		int score = sc.nextInt();
		boolean result = score >= 60;
		
		System.out.println("Do you pass " + score + " point? " + result);
		
		
		sc.close();
	}

}
