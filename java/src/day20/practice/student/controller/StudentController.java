package day20.practice.student.controller;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import day20.practice.student.vo.Student;

public class StudentController implements Program {
	private final static int EXIT = 4;
	Scanner sc = new Scanner(System.in);
	
	private ArrayList<Student> list = new ArrayList<>();
	
	@Override
	public void run() {
		System.out.println("Program Start");
		int menu;
		do {
			try {
			System.out.println(list);
			printMenu();
			menu = sc.nextInt();
			
			runMenu(menu);
			}catch(InputMismatchException e){
				menu = EXIT-1; //종료 메뉴가 아닌 아무 메뉴 추가
				sc.nextLine(); //앞에서 잘못 입력한 내용 비워주기
				System.out.println("잘못된 입력");
			}
		}while(menu != EXIT);
		sc.close();
	}

	@Override
	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 추가");
		System.out.println("2. 학생 수정");
		System.out.println("3. 학생 삭제");
		System.out.println("4. 프로그램 종료");

		System.out.print("메뉴 선택 : ");
	}
	
	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			updateStudent();
			break;
		case 3:
			deleteStudent();
			break;
		case 4:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("잘못된 번호입니다.");
		}
	}


	private void insertStudent() {
		//추가할 학생 정보 입력(학년, 반, 번호, 이름)
		System.out.println("학년 : ");
		int grade = sc.nextInt();
		System.out.println("반 : ");
		int classNum = sc.nextInt();
		System.out.println("번호 : ");
		int num = sc.nextInt();
		System.out.println("이름 : ");
		sc.nextLine(); //엔터 처리
		String name = sc.nextLine();
		
		//입력받은 정보로 학생 객체 생성
		Student std = new Student(grade, classNum, num, name); //객체 초기화코드
		
		//학생 리스트에 추가
			//리스트에 학생이 없으면(있는지 없는지 확인=>contains/학년,반,번호만 확인할 예정)
		if(!list.contains(std)) {
			list.add(std);
			//추가 성공시 성공했다, 실패하면 실패했다는 메세지 출력
			System.out.println("추가 성공");
			return; //리턴 입력시, else 생략가능
		}
		System.out.println("추가 실패");
	}
	
	
	private void updateStudent() {
		//수정할 학생정보 입력(학년, 반, 번호) : Student클래스 이퀄스와 헤즈코드 오버라이딩이 세개라서
		System.out.println("학년 : ");
		int grade = sc.nextInt();
		System.out.println("반 : ");
		int classNum = sc.nextInt();
		System.out.println("번호 : ");
		int num = sc.nextInt();
		
		//수정할 학생이 있는지 없는지 확인
		//학생 객체 생성
		Student tmp = new Student(grade, classNum, num, null);
		int index = list.indexOf(tmp); //수정코드에 index 이용할 예정
		
			//없으면 종료
			if(index == -1) {
				System.out.println("수정 실패");
				return;
			}
		
		//수정될 학생정보 입력(학년, 반, 번호, 이름)
		System.out.println("학년 : ");
		grade = sc.nextInt();
		System.out.println("반 : ");
		classNum = sc.nextInt();
		System.out.println("번호 : ");
		num = sc.nextInt();
		System.out.println("이름 : ");
		sc.nextLine();
		String name = sc.nextLine();
		
		//학생정보 수정
		//수정된 정보가 이미 있는 학생인지 확인
		tmp = new Student(grade, classNum, num, name); //새로운 tmp. 수정될 정보 이용한 학생객체 생성
		  //학년,반,번호 일치하는 학생 확인 후 있으면 종료
		if(list.contains(tmp)) {
			System.out.println("수정 실패");
			return;
		}
		list.get(index).update(grade, classNum, num, name);
	}
	
	private void deleteStudent() {
		//삭제할 학생정보 입력(학년,반,번호)
		System.out.println("학년 : ");
		int grade = sc.nextInt();
		System.out.println("반 : ");
		int classNum = sc.nextInt();
		System.out.println("번호 : ");
		int num = sc.nextInt();
		
		//삭제할 학생정보 이용해 학생객체 생성
		Student tmp = new Student(grade, classNum, num, null);
		
		//삭제 시도 후 성공시 성공했다, 실패시 실패했다는 메세지 출력
		if(list.remove(tmp)) {
			System.out.println("삭제 성공");
			return;
		}
		System.out.println("삭제 실패");
	}
}
