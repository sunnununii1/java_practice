package day26.book.run;

import day26.book.controller.BookManager;

public class BookRun{

	public static void main(String[] args) {
		// 도서관리 프로그램 작성하기
		/* 1. 도서 등록
		 * 2. 도서 대출
		 * 3. 도서 반납
		 * 4. 종료
		 */

		BookManager bm = new BookManager();
		bm.run();
	}

}
