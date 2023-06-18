package day13.homework;

import java.util.Scanner;

public class VocabularyNoteEx2 {

	public static void main(String[] args) {
		// 영어 단어장 프로그램 구현하세요.
		/* 메뉴
		 * 1. 단어 추가
		 * 2. 단어 삭제
		 * 3. 단어 수정
		 * 		a. 단어 수정
		 * 		b. 뜻 수정
		 * 		c. 뜻 삭제
		 * 4. 단어 출력
		 * 		a. 전체 출력
		 * 		b. 검색
		 * 5. 프로그램 종료
		 */
		
		/* 예. 메뉴 [엔터] 1~5번 출력
		 * 	  메뉴 선택 : [입력]
		 * 	  서브 메뉴 [엔터] a~c 출력
		 */

	
		Scanner sc = new Scanner(System.in);
		 String input;
		int count = 0;
		
	
		do {
			System.out.println("메뉴");
			System.out.println("1. 단어 추가");
			System.out.println("2. 단어 삭제");
			System.out.println("3. 단어 수정");
			System.out.println("4. 단어 출력");
			System.out.println("5. 프로그램 종료");
		}
			
		while(true){
			if(input.equals("1")) {
				for(int i=0; i<=5; i++) {
					System.out.println("추가할 단어를 입력하세요.");
				break;
				}
			}
			else if(input.equals("2")) {
				for(int i=0; i<=5; i++) {
					System.out.println("삭제할 단어를 입력하세요.");
					break;
				}
			}
			else if(input.equals("3")) {
				for(int i=0; i<=5; i++) {
					System.out.println("a.단어 수정");
					System.out.println("b.뜻 수정");
					System.out.println("c.뜻 삭제");
					break;
				}
			}
			else if(input.equals("4")) {
				for(int i=0; i<=5; i++) {
					System.out.println("a.전체 출력");
					System.out.println("b.검색");
					break;
				}
			}
			else {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
	}

}
