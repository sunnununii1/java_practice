package day4.ifex;

public class NumberEx {

	public static void main(String[] args) {
		/* 정수 num가 양수이면 양수라고 출력, num가 음수이면 음수라고 출력,
		 * num가 0이면 0으로 출력하는 코드를 작성하세요.
		 */

		int num = 0;
		if(num > 0) {
			System.out.println(num + " is a positive number.");
		}
		
		else if(num < 0) {
			System.out.println(num + " is a nagative number.");
		}
		// num이 음수라면 양수가 아닌 수 중에 음수를 판별함
		
		else { System.out.println(num + " is a 0.");
		}
		// 0은 음수도 아니고 양수도 아닌 경우
		// 마지막 else문은 ①if문과 ②else if문이 아닐 경우 사용. 생략 가능하다.
	}

}
