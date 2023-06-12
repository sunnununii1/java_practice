package day8.homework;

import java.util.Scanner;

public class MethodScoreEx {

	public static void main(String[] args) {
		// 성적을 입력받아 학점을 출력하는 코드를 작성하세요. (단, 메서드 이용)

		double score;
		Scanner sc = new Scanner(System.in);
		System.out.println("input score : ");
		score = sc.nextInt();
		
		getGrade(score);
		System.out.println(getGrade2(score));
		
		
		sc.close();
		
	}
	
	/** 성적이 주어지면 주어진 학점을 알려주는 메서드
	 * 매개변수 : 성적 => 실수 => double
	 * 리턴타입 : 학점 => 문자열 => String
	 * 메서드명 : getGrade
	 */
	public static String getGrade(double score) {
		if(score == 100) {
			System.out.println("A");
		}
		else if(score >=90 && score <100) {
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
		else {
			System.out.println("F");
		}
		return null;
	}
	
	// switch문 이용하기
	public static String getGrade2(double score) {
		if(score >100 || score <0) { 
			return "Wrong score";
		}
		int res = (int)(score/10); // 성적이 몇점대인지 확인하기 위한 정수 => 9가 나오면 90점대
		switch(res) {
		case 10:
		case 9:
			return "A";
		case 8:
			return "B";
		case 7:
			return "C";
		case 6:
			return "D";
		default:
			return "F";
		}
	}
}
