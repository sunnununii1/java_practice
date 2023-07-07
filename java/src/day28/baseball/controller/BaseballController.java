package day28.baseball.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import day27.attendance.vo.AttendanceBook;
import day28.baseball.vo.BaseballGame;
import day28.baseball.vo.Record;

public class BaseballController implements Program{

		// 숫자 야구 게임을 구현하세요. 1~9 사이의 중복되지 않은 세 수를 맞추는 게임
		/* 규칙 : B: 같은 숫자가 있지만 위치가 다름
		 * 		 S: 같은 숫자가 있고 위치가 같음
		 *		 30: 일치하는 숫자가 하나도 없음
		 */
		
	private Scanner sc = new Scanner(System.in);
	private BaseballGame bbGame;
	private List<Record> recordList = new ArrayList<>();
	
	public void run() {
		int menu;
		String fileName = "baseball_day28.txt";
		load(fileName);
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
		}while(menu != 3);
		save(fileName);
	}
	
	private void save(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				oos.writeObject(recordList);
				} catch(IOException e) {
					e.printStackTrace();
				}
	}

	private void load(String fileName) {
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(fileName))){
			recordList = (List<Record>)ois.readObject();
						
			} catch(FileNotFoundException e) {
				System.out.println("불러올 파일이 없음");
			} catch(IOException e) {
				e.printStackTrace();
			} catch(ClassNotFoundException e) {
				System.out.println("List<Record> 클래스를 찾을 수 없음");
			}
	}

	public void printMenu() {
		System.out.println("Memu");
		System.out.println("1. Play");
		System.out.println("2. Record");
		System.out.println("3. Exit");
		System.out.println("Select : ");
	}


	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			play();
			break;
		case 2:
			recordGame();
			break;
		case 3:
			System.out.println("EXIT");
			break;
		default:
			System.out.println("Worng number");
		}
	}

	private void play() {
		//게임 할 때마다 랜덤수 새로 만들게끔 함
		bbGame = new BaseballGame();
		
		//맞출 때까지 반복
		List<Integer> user = new ArrayList<>();
		int count = 0;
		do {
			user.clear(); //기존값 누적 방지
			//사용자가 입력
			System.out.print("user : ");
			for(int i = 0; i<3; i++) {
				user.add(sc.nextInt());
			}
			
			/*입력한 값을 게임에 넣어줌. 단, 값이 중복되거나 값이 넘어가면 알림창 출력
			 * 잘못된 값 출력 */
			if(!bbGame.setUser(user)) {
				System.out.println("Duplicated or Out of bounds");
				continue;
			}
			//결과 출력
			bbGame.printResult();
			count++;
			
		}while(bbGame.getStrike() != 3);
		//기록 관리(개수제한X)
		System.out.print("input name : ");
		String name = sc.next();
		Record record = new Record(name, count);
		recordList.add(record);
	}

	private void recordGame() {
		Collections.sort(recordList, (o1,o2)->{
			return o1.getCount() - o2.getCount();
		});
		recordList.stream().forEach(r->System.out.println(r));
	}

}
