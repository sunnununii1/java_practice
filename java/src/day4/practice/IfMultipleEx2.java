package day4.practice;
import java.util.Scanner;

public class IfMultipleEx2 {

	public static void main(String[] args) {
		/* 정수 num을 입력받아 2의 배수이면 2의 배수라고 출력,
		 * 3의 배수이면 3의 배수라고 출력, 6의 배수이면 6의 배수라고 출력,
		 * 2,3,6의 배수가 아니면 2,3,6의 배수가 아니라고 출력하는 코드 작성해라.
		 */
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("input integer number : ");
		num = sc.nextInt();
		
		
		// 공배수가 나오는 오류 문제시, 순서를 바꾸면 결과값이 달라진다. (6-3-2 순서)
		//6의 배수가 아닌 2의 배수만 찾기 위해 2의 배수이지만 3의 배수가 아닌 정수를 확인!
		/* 다만, 2,3,6 순서대로 작성하고 싶으면
		 * (num % 2 == 0 && num % 3 != 0)
		 * 처럼 추가적인 작업이 필요하다.
		 */
		if(num % 6 == 0) {
			System.out.println("6의 배수이다.");
		}
		else if(num % 3 == 0) {
			System.out.println("3의 배수이다.");
		}
		else if(num % 2 == 0) {
			System.out.println("2의 배수이다.");
		}
		else {
			System.out.println("2,3,6의 배수가 아니다.");
		}
		
		sc.close();
		
	}

}
