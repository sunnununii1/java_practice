package day25.student.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day25.student.vo.Student;

public class StudentManager implements Program {

	private List<Student> list = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	public static final int EXIT = 3;
	
	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 확인");
		System.out.println("3. 종료");
		System.out.println("메뉴 선택 : ");
	}
	
	@Override
	public void run() {
		int menu;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
		}while(menu != 3);
		sc.close();
	}
	
	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insert();
			break;
		case 2:
			check();
			break;
		case 3:
			System.out.println("종료합니다.");
			break;
		default :
			System.out.println("잘못된 번호");
		}

	}

	private void check() {
		for(Student tmp : list) {
			System.out.println(tmp);
		}
	}

	private void insert() {
		//이름, 과, 학번 추가
		System.out.println("이름 : ");
		String name = sc.next();
		
		System.out.println("과 : ");
		String major = sc.next();
		
		System.out.println("학번 : ");
		String classNumber = sc.next();
		
		//등록 성공시 성공 메세지 출력
		if(insertStudent(name, major, classNumber)) {
			System.out.println("등록 성공");
		}else {
			System.out.println("등록 실패");
		}
		
	}

	private boolean insertStudent(String name, String classNumber, String major) {
		Student s = new Student(name,major,classNumber);
		list.add(s); //패턴에 맞으면 학생 리스트에 추가
		return true;
	}

}
