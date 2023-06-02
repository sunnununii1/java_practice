package day4.ifex;

public class NestedIfEx {

	public static void main(String[] args) {
		/* 2,3,6의 배수 판별 예제
		 * (day4.preactice 패키지에 IfMutipleEx2 문제)
		 */
		
		int num = 6;
		
		// 2의 배수(2,4,6,8,10,12)
		// **중첩 if문 사용**
		if(num % 2 == 0) {
			if(num % 3 ==0) {
				System.out.println("A myltiple of 6");
			}
		}
		//3의 배수 ==> 6의 배수가 됨(6,12,18)
		//3의 배수 가 아닌 수 ==> 2의 배수(2,4,6,8,10)
		else if(num % 3 == 0) {
			System.out.println("A nultiple of 3");
		}
		//아닌 수
		else {
			System.out.println("Not multiple of 2,3,6");
		}
		
	}

}
