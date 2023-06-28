package day21.practice.updown.controller;

import java.util.ArrayList;
import java.util.Scanner;

import day21.practice.updown.vo.RecordGame;

public class GameManager implements Program{
	
	private static final int EXIT = 3; //private 붙는 이유: 리터럴 3에 이름을 붙여 명확한 전달 위함
	private Scanner sc = new Scanner(System.in); //다른 메서드에서 매번 객체 생성하는게 번거로워서
	
	//기록을 저장하는 리스트 생성
	private ArrayList<RecordGame> list = new ArrayList<>();
	
	
	@Override
	public void printMenu() {
		System.out.println("Menu");
		System.out.println("1. Play");
		System.out.println("2. Record");
		System.out.println("3. Exit");
		System.out.println("Select Menu : ");
	}

	@Override
	public void run() {
		System.out.println("Program Start");
		
		int menu = -1;
		do {
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
		}while(menu != EXIT);
	}

	@Override
	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			playGame();
		break;
		case 2: 
			recordGame();
		break;
		case 3:
			System.out.println("Exit");
		break;
		default:
			System.out.println("Wrong Menu!");
		}		
	}

	private void recordGame() {
		for(RecordGame tmp : list) {
			System.out.println(tmp);
		}
		
	}

	public static void playGame() {

		int min = 1, max = 100;
		int num = min - 1; // 최솟값 - 1은 랜덤에서 나올 수 없는 숫자 <로 초기화	
		Scanner sc = new Scanner(System.in);
	
		int random = (int)(Math.random() * (max-min+1) + min); 
		System.out.println(random);
		
		int count = 0; 
		while(random != num) { 
			System.out.println("input number (1~100) : ");
			num = sc.nextInt();
			
			if(num < random) {
			System.out.println("Up !");
			}else if(num > random) {
			System.out.println("Down !");
			}else {
				System.out.println("Good !");
			}
			count++;
		}
		sc.close();
		
		//기록 : 아이디(입력), 플레이 횟수
		//아이디 입력	
		System.out.print("Record ID : ");
		String id = sc.next();
		//어떻게 저장하고 관리할 건지
		RecordGame rec = new RecordGame(id, count);
		list.add(rec);
		sort();
	}
	
	public void sort() {
		for(int i=0; i<list.size()-1; i++) {
			for(int j=0; j<list.size()-1; j++) {
				if(list.get(i).getCount() > list.get(j+1).getCount()) {
					RecordGame tmp = list.get(j);
					list.set(j, list.get(j+1));
					list.set(j+1, tmp);
				}
			}
		}
	}
}