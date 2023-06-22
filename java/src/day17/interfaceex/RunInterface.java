package day17.interfaceex;

public interface RunInterface {
		/*public final static*/int NUM = 10; //클래스 상수. 클래스 이용하여 호출
		/*public abstract*/ void run(); //인터페이스 메소드엔 public abstract 자동붙음 + 추상메서드라서 구현부 {} 없음
	
		default void stop() {
			System.out.println("Program stop");
		}
}
