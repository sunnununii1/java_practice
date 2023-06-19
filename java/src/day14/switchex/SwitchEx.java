package day14.switchex;

public class SwitchEx {

	public static void main(String[] args) {
		/* switch문 case에 변수 선언하면 다른 case에서 선언할 수 없음을 보여주는 예제
		 * case문에 break는 필수 아닌 선택!
		 * => break 없을시 다음 case의 실행문으로 이동됨
		 */
		
		int menu = 1;
		
		switch(menu) {
		case 1:
			String title = "title 1";
			System.out.println(title);
			//break;
		case 2:
			String title2 = "title 2"; //title이 case 1에 있어 선언불가
			/*case 2에서 title 출력하면 에러
			=> 만약 menu=2; 선언하면 case 2가 바로 실행되는데, 이때 case 1을 건너 뛰기 때문에
			title은 아예 선언되지 않아 에러가 남 */
			//System.out.println(title);
			System.out.println(title2);
			break;
		case 3:
			break;
		}
	}

}
