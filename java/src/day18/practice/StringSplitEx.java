package day18.practice;

import java.util.Scanner;

public class StringSplitEx {

	public static void main(String[] args) {
		/* 문장을 입력받아 단어의 개수를 출력하는 코드 작성
		 *  input : Hi. My name is hong.
		 *  word : 5 */
		
		//문장 입력
		System.out.println("input : ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		
		//공백을 기준으로 단어들을 배열에 저장
		String word[] = str.split(" ");
		
		//개수 출력
		System.out.println("Word : " + word.length);
		
		sc.close();
	}

}
