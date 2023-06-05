package day5.practice;

public class MultplicationTableEx {

	public static void main(String[] args) {
		/* 구구단 2단을 출력하세요.
		 * 2 x 1 = 2
		 * 2 x 2 = 4
		 * .
		 * .
		 * 2 x 9 = 18
		 */
		
		/* 반복횟수 : i는 1부터 9까지 1씩 증가 
		 * 규칙성 : 2 x i = 를 출력
		 */
		
		int i = 2;
		while(i <= 9) {
			System.out.println(2 + " x " + i + " = " + 2*i);
			++i;
		}
	}

}
