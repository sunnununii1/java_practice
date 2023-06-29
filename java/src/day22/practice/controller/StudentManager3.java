package day22.practice.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

import day22.practice.vo.Student;

public class StudentManager3 implements Program {
	/* 스트림 버전으로 바꿔보기 */
	
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
		Stream<Student> stream = list.stream();
		switch(menu) {
		case 1:
			stream.forEach(std->System.out.println(std));
			break;
		case 2:
			//검색할 학년 입력
			System.out.print("학년 : ");
			final int grade1 = sc.nextInt();
			final int fGrade = grade1;
			/* filter는 매개변수로 predicate 인터페이스의 객체가 필요
			 * 익명클래스(=filter())를 람다식으로 만든 후에 객체를 생성해서 전달 
			 * std는 매개변수 이름.(수정가능) */
			stream.filter(std->std.getGrade() == grade1)
				  .forEach(std->System.out.println(std));
			break;
		case 3:
			//검색할 학년, 반, 번호 입력
			System.out.print("학년 : ");
			final int grade2 = sc.nextInt();
			System.out.print("반 : ");
			final int classNum2 = sc.nextInt();
			System.out.println("번호 : ");
			final int num2 = sc.nextInt();
			stream.filter(std->std.equals(new Student(grade2, classNum2, num2, null)))
				  .forEach(std->System.out.println(std));
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