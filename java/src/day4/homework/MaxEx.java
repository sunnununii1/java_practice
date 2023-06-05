package day4.homework;

import java.util.Scanner;

public class MaxEx {

	public static void main(String[] args) {
		// 두 정수를 입력받아 두 정수 중 큰 수를 출력하는 코드를 작성하세요.
		
		int num1, num2;
		int max; //둘 중 더 큰 수를 선언할 때 저장할 변수^
		
		Scanner sc = new Scanner(System.in);
		System.out.println("input 2 integer number : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		
		if(num1 >= num2) {
			max = num1;
		}
		else { max = num2;
		} /* max를 출력
		num1이 num2보다 크거나 같으면 max에 num1을 저장함^
		* */
		
		System.out.println(num1 + "과 " + num2 + " 중 더 큰 수는 " + max +" 입니다.");
		
		
		sc.close();
	}

}
