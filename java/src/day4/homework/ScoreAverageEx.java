package day4.homework;

import java.util.Scanner;

public class ScoreAverageEx {

	public static void main(String[] args) {
		// 국어, 영어, 수학 성적을 입력받아 평균을 출력하는 코드를 작성하세요.
		
		int kor, eng, math;
		double avg; // ^
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input score(kor, eng, math) ex : 100, 90, 80 : ");
		kor = sc.nextInt();
		eng = sc.nextInt();
		math = sc.nextInt();
		
		avg = (kor + eng + math) / 3.0; // 평균을 계산하는 식 필요^
		/* 형변환 double을 따로 붙이지 않아도
		 * 3을 3.0으로 바꾸면 더블이 된다
		 */
		System.out.println("avg : " + avg);
		
		
	sc.close();
	
	}

}
