package day15.polymorphism;

public class InstancePolymorphismEx {

	public static void main(String[] args) {
		/* TV 1대, 에어컨 2대, 라디오 3대를 객체로 생성한 후
		 * 전원을 켜는 기능을 실행해보세요. */
		
		RemoteControl remocon = new RemoteControl();		
		
		/*1. 한대씩 각각 코드 입력하는 방법
		TV tv = new TV();
		AirCounditioner aircon1 = new AirCounditioner();
		AirCounditioner aircon2 = new AirCounditioner();
		Radio radio1 = new Radio();
		Radio radio2 = new Radio();
		Radio radio3 = new Radio();
		
		remocon.turnOn(tv);
		remocon.turnOn(aircon1);
		remocon.turnOn(aircon2);
		remocon.turnOn(radio1);
		remocon.turnOn(radio2);
		remocon.turnOn(radio3);
		*/
		
		/*2. 배열 생성 후, 향상된 for문 이용하기 (포함 다형성 X)
		
		TV tv = new TV();
		AirCounditioner aircons[] = new AirCounditioner[2];
		Radio radios[] = new Radio[3];
		
		for(int i=0; i<aircons.length; i++) {
			aircons[i] = new AirCounditioner();
		}
		for(int i=0; i<radios.length; i++) {
			radios[i] = new Radio();
		}
		
		remocon.turnOn(tv); //remocon 이용 => 매개변수의 다형성
		for(AirCounditioner aircon : aircons) {
			aircon.turnOn(); //매개변수의 다형성
		}
		for(Radio radio : radios) {
			radio.turnOn(); //매개변수의 다형성
		}*/
		
		
		/*3. 포함 다형성+객체 다형성 예제! (부모클래스의 배열을 이용하여 자식클래스 관리)
			=> 에어컨,라디오, 티비를 가전으로 묶어서 다같이 관리*/
		int tvCount = 1, airconCount = 2, radioCount = 3;
		int total = tvCount + airconCount + radioCount;
		HomeAppliances homeAppliances[] = new HomeAppliances[total];
		int count = 0;//현재 만들어진 제품 개수
		//tv 1대 생성
		for(int i=0; i<tvCount; i++) {
			homeAppliances[count++] = new TV(); //업캐스팅
		}
		//에어컨 2대 생성
		for(int i=0; i<airconCount; i++) {
			homeAppliances[count++] = new AirCounditioner(); //업캐스팅
		}
		//라디오 3대 생성
		for(int i=0; i<radioCount; i++) {
			homeAppliances[count++] = new Radio(); //업캐스팅
		}
		//모든 제품 전원 키기
		for(HomeAppliances homeAppliance : homeAppliances) {
			remocon.turnOn(homeAppliance);
		}
		
		System.out.println("=====================");
		
		//모든 라디오의 전원을 끄기
		for(HomeAppliances homeAppliance : homeAppliances) {
			//라디오로 다운캐스팅이 가능한 객체만 끔 => 라디오만 끔
			if(homeAppliance instanceof Radio) {
			remocon.turnOff(homeAppliance); //아직 다운캐스팅 X
			Radio radio = (Radio)homeAppliance; //다운캐스팅 O
			System.out.println(radio.frequecry);
			}
		}
	}
	
}	


class HomeAppliances{
	boolean power;
	void turnOn() {
		power = true;
	}
	void turnOff() {
		power = false;
	}
	
}
	
class RemoteControl{
	public void turnOn(HomeAppliances appliance) {
		appliance.turnOn();
		System.out.println("전원이 켜졌습니다.");
	}
	public void turnOff(HomeAppliances appliance) {
		appliance.turnOff();
		System.out.println("전원이 꺼졌습니다.");
	}
}

//가전제품을 상속받는 자식클래스(리모콘, 에어컨, 티비 등..) 생성
class TV extends HomeAppliances{
	int channel;
}
class AirCounditioner extends HomeAppliances{
	double CurrentTemperature;
	double DesiredTemperature;
}

class Radio extends HomeAppliances{
	double frequecry;
}




