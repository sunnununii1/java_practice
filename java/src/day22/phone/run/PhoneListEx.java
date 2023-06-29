package day22.phone.run;

import day22.phone.controller.PhoneManager;

public class PhoneListEx {

	public static void main(String[] args) {
		// 전화번호 관리 프로그램 구현
		/* 1. 전화번호 등록
		 * 2. 전화번호 수정
		 * 3. 전화번호 검색
		 * 4. 종료
		 * */

		PhoneManager pm = new PhoneManager();
		pm.run();
	}

}
