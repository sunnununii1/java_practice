package day5.practice;

public class RandomEx {

	public static void main(String[] args) {
		/* min 부터 max 사이에 랜덤한 정수를 만드는 코드를 작성하세요.
		 * Math.random() : 0 이상 1 미만의 실수를 랜덤으로 생성 
		 * 0 <= r < 1 이 기본값
		 * 0 * (max-min+1) <= r * (max-min+1) < 1 * (max-min+1)
		 * 0 <= r * (max-min+1) < max - min + 1
		 * 0 + min <= r * (max-min+1) + min < max - min + 1 + min
		 * min <= r * (max-min+1) + min < max + 1
		 */
		
		
		int min = 1, max = 10;
		int random = (int)(Math.random() * (max-min+1) + min); // 공식! 외우기*
					//=>결과가 double이라서 빨간줄
		System.out.println(random);
	
		}
	

}
