package day22.practice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import day22.practice.vo.Student;

public class StudentManager2 implements Program {
	/* 람다식 버전으로 바꿔보기 */
	
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
		switch(menu) {
		case 1:
			print(s->true); //학생 정보가 주어지면 true로 리턴하여 출력
			break;
		case 2:
			//검색할 학년 입력
			System.out.print("학년 : ");
			final int grade1 = sc.nextInt();
			final int fGrade = grade1; //람다식 안의 지역변수는 상수(final ..)만 가능(밖에서 사용하는 변수는 상수로 변환 필)
			print(s->s.getGrade() == grade1);
			break;
		case 3:
			//검색할 학년, 반, 번호 입력
			System.out.print("학년 : ");
			final int grade2 = sc.nextInt();
			System.out.print("반 : ");
			final int classNum2 = sc.nextInt();
			System.out.println("번호 : ");
			final int num2 = sc.nextInt();
			print(s->s.equals(new Student(grade2, classNum2, num2, "")));
			break;
		case 4:
			System.out.println("종료");
			break;
		default:
			System.out.println("잘못된 입력");
		}
	
	}
	
	private void print(Predicate<Student> p) {
		for(Student tmp : list) {
			//test의 조건을 만족하면 출력, 아니면 안함
			if(p.test(tmp)) {
				System.out.println(tmp);
			}
		}
	}

}