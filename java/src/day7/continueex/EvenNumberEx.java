package day7.continueex;

public class EvenNumberEx {

	public static void main(String[] args) {
		// continue문을 이용한 10 이하 짝수 출력 예제
	
		// 규칙적인 증가문이므로 for문 사용
		int i;
		for( i=1 ; i<=10 ; i++ ) {
			//i가 홀수이면 건너 뜀
			if(i % 2 != 0) {
				continue; // i가 홀수일 때 참, 다시 위로 올라가서 ++로 +1 됨
			}
			System.out.println(i);
		}
		
		
		i = 1;
		while(++i<=10) {
			if(i % 2 != 0) {
				continue; 
			} // while문은 continue시 증감식X 조건식(i<=10)으로 이동, if문에 증감식 추가 안할시 계속 아래 위로 무한루프
			System.out.println(i);
			i++;
		}

	}

}
