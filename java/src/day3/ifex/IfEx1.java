package day3.ifex;

public class IfEx1 {

	public static void main(String[] args) {
		// 정수 num가 0이면 0입니다, 라고 출력하는 코드를 작성해라.
		// if(조건식) {실행문;} > if(정수 num이 0이다.) {0입니다 라고 출력;}
		
		int num = 10;
		if(num == 0) {
		System.out.println("0입니다.");
		// num이 0이 아닐시 출력이 종료(결과값 없음)
	}
		
		
		//정수 num이 0이 아니면 num은 0이 아닙니다. 라고 출력하는 코드를 작성해라.
	
		if(num != 0) {
		System.out.println("0이 아닙니다.");
		}
		// 앞선 if문에서 끝나지 않아서 아래 if문까지 내려와 출력한 것이다.

	}
}
