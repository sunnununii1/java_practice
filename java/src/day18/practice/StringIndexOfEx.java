package day18.practice;

public class StringIndexOfEx {

	public static void main(String[] args) {
		/*Hello World에서 l이 몇개 있는지 확인 코드 작성하기
		=> l 발견지점에서부터 계속 다시 반복해서 l 찾기  */

		String str = "Hello World";
		int count = 0;
		String search = "l";
		int index = -1;
		
		//반복문 (찾으면 반복, 못찾으면 종료)
		do {
			//Hello World에서 l의 위치 찾기 => lo world에서 l 위치 찾기 => o world에서 l => d에서 l
			index = str.indexOf(search, ++index);
			//찾으면 개수 증가
			if(index != -1) {
				count++;
			}
		}while(index != -1);
		
		//개수 출력
		System.out.println(str + " : " + search + " : " + count);

	}

}
