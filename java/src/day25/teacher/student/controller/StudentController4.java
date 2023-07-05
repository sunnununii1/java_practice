package day25.teacher.student.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import day25.teacher.student.vo.Student;

public class StudentController4 {
	//File 이용한 풀이(load, save 추가하기)
	
	private Scanner sc = new Scanner(System.in);
	private List<Student> list = new ArrayList<Student>();

	public void run() {
		int menu;
		String fileName = "student.txt";
		load(fileName);
		do {
			//메뉴 출력
			printMenu();
			//메뉴 선택(입력받음)
			menu = sc.nextInt();
			//메뉴 기능 실행
			runMenu(menu);
		
		}while(menu != 3);
		save(fileName);
		sc.close();
	}

	public void save(String fileName) {
		//학생 정보 저장(리스트에) => 하나씩 꺼내서 저장
		// => 저장		 : OutputStream
		// => 객체단위로 저장 : ObjectOutputStream(보조라서 기반 스트림인 FileOutputStream 필요) 
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				//Student가 시리얼라이즈 된 클래스여야함(vo)
			for(Student tmp : list) {
				oos.writeObject(tmp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void load(String fileName) {
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(fileName))){
				while(true) {
					Student tmp = (Student)ois.readObject();
					list.add(tmp);
				}
		} catch (FileNotFoundException e) {
			System.out.println("불러올 파일 없음");
		} catch (EOFException e) {
			System.out.println("불러오기 완료");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			/* ObjectInputStream 이용해서 객체 단위로 읽어올 때, 
			클래스가 Serializable 인터페이스를 구현하지 않을 시 발생 */
			System.out.println("Student 클래스를 찾을 수 없음");
		}
	}
	
	private void runMenu(int menu) {
		String name, classNumber, major;
		Student tmp;
		switch(menu) {
		case 1:
			//학생정보 저장
			insertStudent();
			break;
		case 2:
			//학생 전체 확인
			print();
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

	
	public void insertStudent() {
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
		tmp = new Student(classNumber, name, major);
		//리스트에 학생 객체 추가
		list.add(tmp);
	}
	
	public void print() {
		for(Student tmp2 : list) {
			System.out.println(tmp2);
			System.out.println("=======");
		}
	}


}