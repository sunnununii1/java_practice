package day5.switchex;

public class EvenEx {

	public static void main(String[] args) {
		// 홀짝 예제 (switch문 활용)

		int num = 4;
		
		switch(num % 2) {
		//num를 2로 나눈 나머지 값을 활용
		case 0:
			System.out.println(num + " is a even number.");
			break;
		default :
			System.out.println(num + " is a odd number.");
		}
	}

}
