package day19.random;

import java.util.Random;

public class RandomEx {

	public static void main(String[] args) {
		/* min ~ max 사이의 랜덤한 정수 출력
		 * 1. Math.random 이용 */
		int min = 1, max = 9;
		
		int r = (int)(Math.random() * (max - min + 1) + min);
		System.out.println(r);
		
		/* min ~ max 사이의 랜덤한 정수 출력
		 * 2. Random 클래스 이용 */
		Random random = new Random(); //()은 종자값 자리. 매번 다른 종자값(현재 시간)을 이용해서 난수가 매번 바뀜
		r = random.nextInt(max - min + 1) + min;
		System.out.println(r);
		r = random.nextInt(max - min + 1) + min;
		System.out.println(r);
		r = random.nextInt(max - min + 1) + min;
		System.out.println(r);
		
	}

}
