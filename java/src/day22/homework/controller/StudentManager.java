package day22.homework.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day22.homework.vo.Student;

public class StudentManager implements Program{

	List<Student> list = new ArrayList<>();
	private Scanner sc = new Scanner(System.in);
	private static final int EXIT = 4;	
	
	@Override
	public void printMenu() {
		System.out.println("1. All" );
		System.out.println("2. Grade");
		System.out.println("3. Search");
		System.out.println("4. EXIT");
		System.out.println("Select : ");		
	}

	@Override
	public void run() {
		int menu;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			
		}while(menu != EXIT);
	}

	@Override
	public void runMenu(int menu) {
		int grade=1, classNum=1, num=1;
		switch(menu) {
		case 1:
			//전체 출력
			printAll();
			break;
		case 2:
			//검색할 학년 입력
			System.out.println("grade : ");
			grade = sc.nextInt();
			printGrade(grade);
			break;
		case 3:
			//검색할 학년, 반, 번호 입력
			System.out.print("grade : ");
			grade = sc.nextInt();
			System.out.print("class : ");
			classNum = sc.nextInt();
			System.out.print("number: ");
			num = sc.nextInt();
			printSearch(grade, classNum, num);
			break;
		case 4:
			System.out.println("EXIT");
			break;
		default:
			System.out.println("Wrong number!");
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
			if(tmp.getGrade() == grade) {
				System.out.println(tmp);
			}
		}
	}

	private void printAll() {
		for(Student tmp : list) {
			System.out.println(tmp);
		}
	}

}
