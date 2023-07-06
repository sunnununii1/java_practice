package day27.attendance.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import day27.attendance.vo.Attendance;
import day27.attendance.vo.AttendanceBook;
import day27.attendance.vo.Student;

public class AttendanceController implements Program{

	private AttendanceBook book = new AttendanceBook(); //출석부
	Scanner sc = new Scanner(System.in);
	public static final int EXIT = 4;
	
	public void run() {
		int menu;
		String fileName = "attendanceBook_day27.txt";
		load(fileName);
		do {
		System.out.println("=============");
		printMenu();
		menu = sc.nextInt();
		runMenu(menu);
		System.out.println("=============");

		} while(menu != EXIT);
		save(fileName);
		sc.close();
	}
	
	
	private void load(String fileName) {
		try(ObjectInputStream ois 
			= new ObjectInputStream(new FileInputStream(fileName))){
			//book에 바로 저장
			book = (AttendanceBook)ois.readObject();
					
		} catch(FileNotFoundException e) {
			System.out.println("불러올 파일이 없음");
		} catch(EOFException e) {
			System.out.println("불러오기 완료");
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			System.out.println("AttendanceBook 클래스를 찾을 수 없음");
		}
		System.out.println(book);
	}
		
	private void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(book);
			} catch(IOException e) {
				e.printStackTrace();
			}
		}


	public void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. 학생 등록");
		System.out.println("2. 출석 체크");
		System.out.println("3. 출석 확인");
		System.out.println("4. 종료");
		System.out.print("메뉴 선택 : ");
	}

	
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			attendance();
			break;
		case 3:
			printAttendance();
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못된 번호입니다.");
		}
	}

	private void insertStudent() {
		//이름, 학번 입력
		System.out.println("학생 이름 : ");
		String name = sc.next();
		System.out.println("학생 학번 : ");
		String num = sc.next();
		
		//출석부 이용해서 학생 객체 생성 후, 추가
		Student std = new Student(num, name); //학생 객체 생성
		boolean insertSuccess = book.insertStudent(std);
		//학번 중복체크
		if(insertSuccess) {
			System.out.println("학생 정보 추가 성공");
		}else {
			System.out.println("학생 정보 추가 실패");
		}
		System.out.println("[" + std + "]" + "\n등록 완료");
	}

	private void attendance() {
		//날짜 입력
		System.out.println("날짜(yyy-MM-dd) : ");
		String dateStr = sc.next();
		//날짜가 제대로 입력됐는지 체크 => SimpleDateFormat 이용
		Date date = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try{
			date = format.parse(dateStr); //문자열->날짜열로 변환작업(날짜 형식 오류시 해결 위한 try-catch 필요)
		}catch(ParseException e) {
			System.out.println("날짜 형식이 아닙니다, 다시 입력하세요.");
			return;
		}
		
		//AttendanceBook에 학생정보들을 가져오도록 추가 작업
		List<Student> stdList = book.getStdList();
		//반복문
		for(Student tmp : stdList) {
			//학생 정보 출력
			System.out.print(tmp + " : ");
			//학생의 출결을 입력(O or X)
			char state;
			do {
				state = sc.next().charAt(0);
			}while(state != 'O' && state != 'X');
			//츨삭부에 체크(학생 정보, 출결로 출석객체 생성 > 출석부에 출석 객체 추가)
			//나중에 학생 삭제기능이 추가되어도 기존 출석기록 삭제 없도록 깊은 복사생성자 이용
			Attendance attendance = new Attendance(date, new Student(tmp), state);					
			//AttendanceBook에 출석 객체가 주어지면 출석명단에 추가하는 작업
			if(!book.insertStudent(attendance)) {
			System.out.println("이미 등록된 출석입니다.");	
			}else {
				System.out.println("출석체크 완료!");
			}
		}
		//System.out.println(book.getList());//확인용
	}

	private void printAttendance() {
		//출석부에 있는 모든 출석정보를 확인
		book.printAttendance();
	}

}
