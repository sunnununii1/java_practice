package day5.whileex;

public class HelloWorldEx {

	public static void main(String[] args) {
		// Hello World를 10번 출력하는 코드 작성하기(반복문 while)
		/* 반복 횟수 : 10번, 1번부터 10번까지 1씩 증가
		 *  => 변수의 초기값 : 1
		 *  => 조건식 : 10까지 => 
		 *  => 증가하는 식 : 1씩 증가
		 * 규칙성(실행문) : Hello World를 출력
		 */

		
		int i = 1; // 변수의 초기값 담당
		while(i <= 10) {
			//10보다 작거나 같을 때까지
			System.out.println("Hello World");
			++i; // 또는 i++;, i= i+1;, i+=1; 세개 다 대체 가능
		}
		
		System.out.println("===========================");
		
		/*int max = 10;
		while(i <= max) {
			System.out.println("Hello World");
			++i;
		}
		값은 같고 다른 예제
		* */
		
		/* 반복 횟수 : i는 10부터 1까지 1씩 감소
		 *  */
		
		i = 10;
		while( i >= 1) {
			//i=max; while( --i > 0 )로도 가능
			System.out.println("Hello World");
			--i;
		}
		
	}

}
