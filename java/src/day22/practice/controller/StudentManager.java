package day22.practice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import day22.practice.vo.Student;

public class StudentManager implements Program {
	
	private List<Student> list = Arrays.asList(
			new Student(1,1,1,"Hong"),
			new Student(1,1,2,"Ling"),
			new Student(2,1,1,"Park"),
			new Student(3,1,1,"Lee"),
			new Student(3,3,2,"Kim")
	);
	private Scanner sc = new Scanner(System.in);
	private static final int EXIT = 4;
	
	@Override
	public void run() {
	int menu;
	do {
		printMenu();
		menu = sc.nextInt();
		runMenu(menu);
		
	}while(menu != EXIT);
	sc.close();
	}
	
	@Override
	public void printMenu() {
		System.out.println("1. 학생 전체 출력");
		System.out.println("2. 학생 학년 출력");
		System.out.println("3. 학생 검색 출력");
		System.out.println("4. 종료");
		System.out.println("메뉴 선택 : ");
	}

	@Override
	public void runMenu(int menu) {
		int grade, classNum, num;
		switch(menu) {
		case 1:
			printAll();
			break;
		case 2:
			//검색할 학년 입력
			System.out.print("학년 : ");
			grade = sc.nextInt();
			printGrade(grade);
			break;
		case 3:
			//검색할 학년, 반, 번호 입력
			System.out.print("학년 : ");
			grade = sc.nextInt();
			System.out.print("반 : ");
			classNum = sc.nextInt();
			System.out.println("번호 : ");
			num = sc.nextInt();
			printSearch(grade, classNum, num);
			break;
		case 4:
			System.out.println("종료");
			break;
		default:
			System.out.println("잘못된 입력");
		}
	
	}
	

	private void printSearch(int grade, int classNum, int num) {
		for(Student tmp : list) {
			if(tmp.equals(new Student(grade, classNum, num, ""))) {
			System.out.println(tmp);
			}
		}
	}

	private void printGrade(int grade) {
		for(Student tmp : list) {
			if(grade == tmp.getGrade()) {
				System.out.println(tmp);
			}
			System.out.println(tmp);
		}
	}

	private void printAll() {
		for(Student tmp : list) {
			System.out.println(tmp);
		}
	}

}