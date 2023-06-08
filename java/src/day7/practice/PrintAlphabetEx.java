package day7.practice;

public class PrintAlphabetEx {

	public static void main(String[] args) {
		// a부터 z까지 출력하는 코드를 작성하세요.
		// abcde...z
		
		/* 방법 1.
		 * 문자형 변수 ch++을 하면 char
		 * 반복횟수 : ch는 'a'부터 'z까지' 1씩 증가
		 * 규칙성 : ch을 출력
		 * */
		char ch;
		for(ch='a' ; ch<='z' ; ++ch) {
			System.out.print(ch);
		}
		
		System.out.println("\n==========================");
		
		
		/* 방법 2.
		 * 'a'에 1을 더하면 'b' 2를 더하면 'c'...25를 더하면 'z'
		 * 'a'+정수 => int형 사용
		 * 반복횟수 : i는 0부터 26보다 작을 때까지 1씩 증가
		 * 규칙성 : 'a'에 i를 더한 값 전체(a+i)를 문자형으로 자료형 변환하여 출력
		 * */
		char a = 'a';
		int i;
		
		for(i=0 ; i<26 ; i++) {
			System.out.print((char)(a + i));
		}
	}

}
