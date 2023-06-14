package day11.array;

import java.util.Scanner;

public class ArrayEx1 {

	public static void main(String[] args) {
		/* 학생들의 국어 성적을 저장하기 위한 배열을 생성하세요.
		 * 학생들은 총 3명이다.
		 */
		
		//자료형[] 배열명 = new 자료형[개수];
		double [] studentKoreaScore = new double[3];
		double std1, std2, std3;
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0 ; i<3 ; i++) {
			System.out.print("input : ");
			studentKoreaScore[i] = sc.nextDouble(); //studentKoreaScore[i]가 하나의 변수처럼 사용됨
		}
		
		for(int i=0 ; i<3 ; i++) {
			System.out.println(studentKoreaScore[i]);
		}
		
		/* 학생 3명의 국어 점수 평균을 구하고 출력하는 코드를 작성하세요.
		 * */
		double sum = 0.0;
		for(int i=0 ; i<3 ; i++) {
			sum += studentKoreaScore[i];
		}
		double average = sum / 3;
		System.out.println("average : " + average);
		
		sc.close();
	}

}
