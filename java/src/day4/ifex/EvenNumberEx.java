package day4.ifex;

public class EvenNumberEx {

	public static void main(String[] args) {
		// if else문을 이용한 홀짝 판별 예제
		// num가 짝수이면 짝수 출력, 아니면(else) 홀수라고 출력하세요.
		// > num을 2로 나누었을 때 나머지가 0과 같다 = 짝수
		
		int num = 3;
		if(num % 2 == 0) {
			System.out.println(num + "은 짝수이다.");
		}
		else {
			System.out.println(num + "은 홀수이다.");
		}
		
	}

}
