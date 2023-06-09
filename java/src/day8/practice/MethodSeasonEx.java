package day8.practice;

import java.util.Scanner;

public class MethodSeasonEx {

	public static void main(String[] args) {
		// 월을 입력받아 계절을 출력하는 코드를 작성하세요.
		/* Spring : 3,4,5
		 * Summer : 6,7,8
		 * Fall : 9,10,11
		 * Winter : 12,1,2
		 * Wrong Month : 그 외
		 */
		
		int month;
		Scanner sc = new Scanner(System.in);
		System.out.println("input month : ");
		month = sc.nextInt();
		
		season(month);
		
		String season = getSeason(month);
		System.out.println(season);
		System.out.println(getSeason(month));
		//둘다 가능
		
		sc.close();
	}
	/**방법 1.
	 * 매개변수 : 판별할 정수 => int month
	 * 리턴타입 : void
	 * 메서드명 : season
	 */
	public static void season(int month) {
		//월이 3이거나 4이거나 5이면 봄 출력
		if(month >=3 && month <=5) {
			System.out.println("Spring");
		}
		//월이 6이거나 7이거나 8이면 여름 출력
		else if(month >=6 && month <=8) {
			System.out.println("Summer");
		}
		//월이 9이거나 10이거나 11이면 가을 출력
		else if(month >=9 && month <=11) {
			System.out.println("Fall");
		}
		//월이 12이거나 1이거나 2이면 겨울 출력
		else if(month ==12 || month ==1 || month==2) {
			System.out.println("Winter");
		}
		//월이 그 외 숫자이면 wrong month 출력
		else {
			System.out.println("Wrong Month");
		}
	}
	
	/**방법 2.
	 * 월이 주어지면 주어진 월에 맞는 계절을 알려주는 메서드
	 * 매개변수 : 판별할 정수 => int month
	 * 리턴타입 : 계절 => String
	 * 메서드명 : getSeason
	 */
	public static String getSeason(int month) {
			if(month >=3 && month <=5) {
				return "Spring";
			}
			else if(month >=6 && month <=8) {
				return "Summer";
			}
			else if(month >=9 && month <=11) {
				return "Fall";
			}
			else if(month ==12 || month ==1 || month==2) {
				return "Winter";
			}
			else {
				return "Wrong Month";
			}
		}
	}
	


