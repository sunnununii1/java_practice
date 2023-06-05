package day5.practice;

public class PrintEvenNumberEx {

	public static void main(String[] args) {
		/* 10 이하의 짝수를 출력하는 코드를 작성하세요.
		 * 2
		 * 4
		 * 6
		 * 8
		 * 10
		 */
		
		int i = 2;
		while(i <= 10) {
			System.out.println(i); // i가 짝수이면 i를 출력
			i = i+2;
		}
		
		System.out.println("======================");

		/* 다른 방법 1.
		 * 반복횟수 : i는 1부터 5까지 1씩 증가
		 * 규칙성 : 2*i 출력
		 */
			i = 1;
			while(i <= 5) {
				System.out.println(2*i);
			++i; }
		 
	   System.out.println("======================");
			
			
		 /* 2. 반복횟수 : i는 1부터 10까지 1씩 증가
		 * 규칙성 : i가 짝수이면 i를 출력
		 */
		 	i = 1;
		 	while(i <= 10) {
		 		if(i % 2 == 0) {
		 		System.out.println(i);
		 	 }
		 		++i;
		 	}
	}
}
		
	
