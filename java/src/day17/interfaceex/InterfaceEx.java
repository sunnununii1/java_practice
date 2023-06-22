package day17.interfaceex;

import day13.homework.controller.VocalbularyNoteController;
import day15.practice.shop.controller.ShopManager;

public class InterfaceEx {

	public static void main(String[] args) {
		/* 인터페이스 이용해서 객체 생성 X */
		//RunInterface run = new RunInterface();
		System.out.println(RunInterface.NUM);
		
		//구현클래스는 객체생성O
		Run run = new Run();
		run.run();
		run.load();
		
		//구현클래스로 생성한 객체를 RunInterface가 관리함
		RunInterface runInterface = new Run();
		runInterface.run();
		//runInterface.load(); //RunInterface엔 load가 추상메서드로 존재하지 않아 에러!
		((Run)runInterface).load(); //Run클래스의 객체로 클래스 변환 완. => load() 메서드 호출 가능해짐
		
		//단어장, 판매관리 불러오기 가능해짐! 단, 하나씩만!
		run(new ShopManager());
		//run(new VocalbularyNoteController()); 
	}
	
	/* 인터페이스 매개변수 다형성 (중요)
	 * -매개변수를 인터페이스의 객체로 선언하면,
	 * 호출할 때 매개변수로 구현 클래스들이 객체들이 올 수 있음
	 * => 다양한 클래스들의 객체가 올 수 있다.
	 * - RunInterface의 객체를 매개변수로 하면,
	 * RunInterface를 구현한 구현 클래스인 ShopManager,VocalbularyNoteController의 객체가 와서 프로그램 실행 가능
	 */
	
	public static void run(RunInterface program) {
		program.run();
	}

}


interface Stop{
	void stop();
}

/*구현클래스 : 인터페이스를 구현한 클래스
 * 구현클래스는 인터페이스의 모든 추상 메서드를 반드시 오버라이딩 해야함.
=> class 클래스명 implements 추상 메서드명 */

//구현클래스는 여러 인터페이스 구현 가능
class Run implements RunInterface, Stop{
	
	public void load() {
		System.out.println("loading...");
	}
	
	@Override
	public void run() {
		System.out.println("Start!");
		stop();
	}

	@Override
	public void stop() {
		System.out.println("Stop!");
	}
}