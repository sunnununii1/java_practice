package day27.attendance.run;

import day27.attendance.controller.AttendanceController;

public class Run {

	public static void main(String[] args) {
		// 학번, 이름을 이용하여 출석부 프로그램 작성해라
		/* 학생 등록
		 * 출석
		 * 출석부 확인
		 * 종료
		 */
		AttendanceController ac = new AttendanceController();
		ac.run();
	}
}
