package day3.practice;

import java.util.Scanner;

public class Ex2 {

	public static void main(String[] args) {
		/*성적을 입력받아 입력받은 성적이 60점 이상인지 확인하는 코드를 작성하세요.
		 *  단, 값이 true나 false 말고 pass나 fail이 나오도록 하세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input score : ");
		int score = sc.nextInt();
		String result = score >= 60 ? "pass" : "fail";
		//조건 연산자를 사용
				
				
		System.out.println("Do you pass " + score + " point? " + result);
				
				
		sc.close();

	}

}
