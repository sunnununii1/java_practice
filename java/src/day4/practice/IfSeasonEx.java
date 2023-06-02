package day4.practice;

import java.util.Scanner;

public class IfSeasonEx {

	public static void main(String[] args) {
		/* 월을 입력받아 입력받은 월의 계절을 출력하세요.
		 * 3,4,5 : 봄
		 * 6,7,8 : 여름
		 * 9,10,11 : 가을
		 * 12, 1, 2 : 겨울
		 * 그 외 : 잘못된 월 
		 */

		int month;
		Scanner sc = new Scanner(System.in);
		System.out.println("input month : ");
		month = sc.nextInt();
		
		
		// 월이 3이거나 월이 4이거나 월이 5이면 봄 (월이 3 이상 5이하이면)
		// &&(~이고, 하고)
		if(month >=3 && month <=5) {
			System.out.println(month + "월은 봄이다.");
		}
		
		// 월이 6이거나 월이 7이거나 월이 8이면 봄(6 이상 8 이하)
		else if(month >=6 && month <=8) {
			System.out.println(month + "월은 여름이다.");}
			
		// 월이 9이거나 월이 10이거나 월이 11이면 봄(9 이상 11 이하)
		else if(month >=9 && month <=11) {
			System.out.println(month + "월은 가을이다.");}
		
		// 월이 12이거나 월이 1이거나 월이 2이면 봄(12이거나 1 이상 1 이하)
		// || (~거나)
		/* (month >=1 && month <=2 || month ==12)
		* &&와 ||가 섞이면 오류 가능성(둘 중 우선 순위 따라 괄호치기)
		* */
		else if(month ==1 || month ==2 || month ==12) {
			System.out.println(month + "월은 겨울이다.");}
		
		else {System.out.println("잘못된 월이다.");
			}

		sc.close();
	}
	
	}


