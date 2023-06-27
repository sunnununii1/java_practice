package day20.practice.student.run;

import day20.practice.student.controller.StudentController;

public class StudentEx {

	public static void main(String[] args) {
		// Student클래스를 이용해서 학생을 등록,수정,삭제하는 기능 프로그램 작성하세요.
		/* 1. 학생 추가
		 * 2. 학생 삭제
		 * 3. 학생 수정
		 * 4. 프로그램 종료
		 * 메뉴 선택 : 
		 */
		
		StudentController sc = new StudentController();
		sc.run();
		
	}
}
