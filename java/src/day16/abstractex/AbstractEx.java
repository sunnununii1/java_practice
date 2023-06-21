package day16.abstractex;

public class AbstractEx {

	public static void main(String[] args) {
		// 추상클래스 이용해 객체 만들 수 없음
		// A a = new A();
		
		/* 구현되지 않은 추상메서드를 객체 생성 후, 오버라이딩하면 가능*/
		A a = new A() {
			public void test() {
				System.out.println("class A Test.");
			}
		};
		a.test();
		A a2 = new A() {
			public void test() {
				System.out.println("class A Test.");
			}
		};
		a2.test();
		//ChildA1도 추상클래스라서 ChildA1으로 객체 생성 X
		//ChildA1 ca1 = new ChildA1();
		
		/*추상클래스를 상속받은 ChildA2는 일반클래스라 객체 생성 O */
		/* => 모든 기능 구현되어있음 > 객체생성O
			  모든 기능 구현되어있지 않음 > 추상메서드 있음 > 객체생성X */
		ChildA2 ca2 = new ChildA2(); 
		ca2.test();
		
		//다형성 : 하나의 객체에 여러타입이 온다
		a = ca2; //업캐스팅에 의해 ca2객체를 a가 다룰 수 있음
		a.test();
	}

}

/* 추상 클래스는 추상 메서드를 가진다.
 * 추상 메서드가 있는 클래스 앞에 abstract 붙이지 않으면 에러! */
abstract class A{
	public abstract void test();
}

/* 추상 클래스 상속 받는 방법 
 * ① 추상 클래스 A를 상속받은 자식 클래스는 추상 클래스로 만들어야 함
 */
abstract class ChildA1 extends A{
	
}

/* 추상 클래스 상속 받는 방법
 * ② 부모 클래스의 추상 메서드를 오버라이딩 후 재정의하기 (중요***) */
class ChildA2 extends A{

	@Override
	public void test() {
		System.out.println("Test");
	}
	
}