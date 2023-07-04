package day25.teacher.student.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day25.student.vo.Student;

public class StudentController {

	public void run() {
		Scanner sc = new Scanner(System.in);
		int menu;
		String name, classNumber, major;
		List<Student> list = new ArrayList<>();
		Student tmp; //학생객체 만듦
		
		do {
			System.out.println("메뉴");
			System.out.println("1. 학생 등록");
			System.out.println("2. 학생 확인");
			System.out.println("3. 종료");
			System.out.println("메뉴 선택 : ");
			
			//메뉴 선택(입력받음)
			menu = sc.nextInt();
			//메뉴 기능 실행
			switch(menu) {
			case 1:
				//학생정보 저장
				//학번(문자열, 공백없)
				classNumber = sc.next();
				
				//이름(문자열, 공백있)
				sc.nextLine();
				name = sc.nextLine();
				
				//과 (문자열, 공백있)
				major = sc.next();
				
				//리스트에 저장
				//입력 정보를 이용해 학생 객체 생성
				tmp = new Student(name, classNumber, major);
				//리스트에 학생 객체 추가
				list.add(tmp);
				System.out.println(list);
				break;
			case 2:
				//학생 전체 확인
				for(Student tmp2 : list) {
					System.out.println(tmp2);
				}
				break;
			case 3:
				break;
			default:
			}
		
		}while(menu != 3);
		
	}

}