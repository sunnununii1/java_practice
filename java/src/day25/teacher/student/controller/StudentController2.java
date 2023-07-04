package day25.teacher.student.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day25.student.vo.Student;

public class StudentController2 {
	//메소드 나눠서 작업ver.

	public void run() {
		Scanner sc = new Scanner(System.in);
		int menu;
		List<Student> list = new ArrayList<>();
		
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택(입력받음)
			menu = sc.nextInt();
			//메뉴 기능 실행
			runMenu(menu, sc, list);
		
		}while(menu != 3);
		
	}

	private void runMenu(int menu, Scanner sc, List<Student> list) {
		String name, classNumber, major;
		Student tmp;
		switch(menu) {
		case 1:
			//학생정보 저장
			insertStudent(sc, list);
			break;
		case 2:
			//학생 전체 확인
			print(list);
			break;
		case 3:
			break;
		default:
		}
	}

	private void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 확인");
		System.out.println("3. 종료");
		System.out.println("메뉴 선택 : ");
	}

	
	public void insertStudent(Scanner sc, List<Student> list) {
		String name, classNumber, major;
		Student tmp;
		//학번(문자열, 공백없)
		System.out.println("학번 : ");
		classNumber = sc.next();
		//이름(문자열, 공백있)
		sc.nextLine();
		System.out.println("이름 : ");
		name = sc.nextLine();
		//과 (문자열, 공백있)
		System.out.println("전공 : ");
		major = sc.nextLine();
		
		//리스트에 저장
		//입력 정보를 이용해 학생 객체 생성
		tmp = new Student(name, classNumber, major);
		//리스트에 학생 객체 추가
		list.add(tmp);
	}
	
	public void print(List<Student> list) {
		for(Student tmp2 : list) {
			System.out.println(tmp2);
			System.out.println("=======");
		}
	}
}