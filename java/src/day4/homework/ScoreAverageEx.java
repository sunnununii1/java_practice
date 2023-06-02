package day4.homework;

import java.util.Scanner;

public class ScoreAverageEx {

	public static void main(String[] args) {
		// 국어, 영어, 수학 성적을 입력받아 평균을 출력하는 코드를 작성하세요.
		
		int kor, eng, math;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input score : ");
		kor = sc.nextInt();
		eng = sc.nextInt();
		math = sc.nextInt();
		
		System.out.println((kor + eng + math) / 3);
		
		
	sc.close();
	
	}

}
