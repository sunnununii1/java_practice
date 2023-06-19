package day14.inheritance;

import lombok.Data;

public class ClassInheritanceEx {

	public static void main(String[] args) {
		/* 스마트폰은 폰이다 => 상속
		 * => 스마트폰 : 자식 클래스 / 폰 : 부모 클래스
		 * 스마트폰은 카메라를 가지고있다. => 포함
		 * => 스마트폰 : 클래스 / 카메라 : 멤버변수
		 
		 * 부모 클래스에게 상속받은 기능들은 사용할 수 있다.
		 * 단, 접근 제어자가 public이나 protected인 경우만 가능
		 * (디폴트는 같은 패키지인 경우 가능하나, 다른 패키지일 땐 불가능)
		 */
		
		SmartPhone phone1 = new SmartPhone();
		phone1.call("010-1234-5678");
		phone1.answer("02-123-4567");
		System.out.println(phone1.getNum());
		phone1.take();
		
		
		//*다운 캐스팅 : 안되는 경우
		Phone p1 = new Phone("010-123-4567");
		//문법적 에러는 없지만, 예외 발생(다운캐스팅이 안되는 경우라서)
		if(p1 instanceof SmartPhone) {
			SmartPhone.c1 = (SmartPhone) p1;
			c1.call("국제번호");
		}
		
		//*다운 캐스팅 : 가능한 경우
		//업캐스팅이 된 객체를 다운캐스팅할 경우
		Phone p2 = new SmartPhone(); //업캐스팅
		SmartPhone c2 = (SmartPhone)p2;
		c2.call("123-4567");
		
	
	}	

}
@Data
class Phone{
	private String num = "010-1111-1111"; //전화번호
	
	//전화 걸기
	public void call(String num) {
		System.out.println(num); //내가 전화를 거는 상대방 번호
		System.out.println("calling...");
	}
	//전화 받기
	public void answer(String num) {
		System.out.println(num); //나한테 전화를 건 상대방 번호
		System.out.println("Answering...");
	}
	public Phone(String num) {
		this.num = num;
		}
	//public Phone(){} //생성자가 하나도 없으면 컴파일할 때 기본 생성자가 자동 호출됨
}

class SmartPhone extends Phone{
	Camera camera = new Camera();
	public void take() {
		camera.take();
	}
	
	public SmartPhone() {
		//부모 클래스의 생성자가 호출
		/*super()를 이용하여 부모 클래스의 생성자를 직접 호출하지 않으면
		 * 기본 생성자인 super()가 자동 추가 후 호출됨
		 * 이때, 부모 클래스의 기본 생성자가 없으면 에러!
		 */
		//super(); //주석 해제시 에러발생
		super("");
	}
	
	//@Override로 내가 오버라이딩을 맞게 했는지 체크할 수 있다.
	@Override
	public void call(String num) {
		System.out.println(num);
		super.call(num);
		System.out.println("SmartPhone!");
	}
}

class Camera{
	public void take() {
		System.out.println("take a picture!");
	}
}