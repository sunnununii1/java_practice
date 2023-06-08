package day7.practice;

public class PrintEx {

	public static void main(String[] args) {
		
		// PrintIn(): 원하는 값을 출력한 후 엔터까지 입력
		System.out.println("abc");
		System.out.println("a");
		System.out.println(1);
		
		// Print() : 원하는 값을 출력 (붙어서 나옴)
		System.out.print("abc\n");
		System.out.print("a");
		System.out.print(1);
		System.out.println();
		
		// Printf() : 원하는 값을 출력, 서식문자 이용 (\n 은 엔터)
		System.out.printf("String : %s\n", "abc");
		System.out.printf("Integer : %d\n", 1);
		System.out.printf("Char : %c\n", 'a');
		System.out.printf("double : %.2f\n", 3.12345678987); //.2가 소수점 자리 의미

	}

}
