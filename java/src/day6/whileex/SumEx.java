package day6.whileex;

public class SumEx {

	public static void main(String[] args) {
		// 1부터 n까지의 합을 구하는 코드를 작성하세요. (n은 10)
		/* 반복횟수 : i는 1부터 n까지 1씩 증가
		 * 규칙성 : 
		 * 반복문 종류 후 : 누적합인 sum을 출력
		 * sum의 초기값은 0 (sum0 = 0)
		 * i = 1		 sum = 0+1 (또는 sum1 = sum0+1)
		 * i = 2		 sum = 0+1+2 (또는 sum2 = sum1+2)
		 * i = 3		 sum = 0+1+2+3 (또는 sum3 = sum2+3)
		 * ...
		 * i = 10		 sum = 0+1+2+3...+10 (또는 sum10 = sum9+10)
		 * i = n 		 sum = sum + i (또는 sum += i)
		 */

		int n = 10, sum = 0;
		int i = 1; //i는 1부터
		while(i <= n) { //i는 n까지
			sum += i;
			++i; //1씩 증가
		}
		System.out.println("1~ " + n + " sum : " + sum);
	}

}
