package day9.classex;

public class Car {
	
	//Car 클래스에 멤버변수(필드) 생성
	private String name;			//차 이름
	private String company;			//제조사
	private int year;				//연식
	private int speed;				//속력
	private char gear;				//P:주차,R:후진,D:주행,N:중립
	private boolean power;			//전원	
	
	
	//생성자 생성(마우스 우클릭-source-generate constructor using field)
	public Car(String _name, String _company, int _year) {
		name = _name;
		company = _company;
		year = _year;
		gear = 'P';
	}

	//메서드
	/** 자동차 정보를 출력하는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printInfo
	 */
	public void printInfo() {
		System.out.println("VIEW");
		System.out.println("COMPANY	: " + company);
		System.out.println("MODEL	: " + name);
		System.out.println("YEAR	: " + year);
		System.out.println("POWER	: " + (power ? "On":"Off"));
		System.out.println("GEAR	: " + gear);
		System.out.println("SPEED	: " + speed);
	}
	
	/** 속력이 1 증가 또는 1 감소하는 메서드
	 * 매개변수 : 증가할건지, 감소할건지 => boolean positive
	 * 리턴타입 : 없음 => void
	 * 메서드명 : speedChange
	 */
	public void speedChange(boolean positive) {
		
		//속력이 꺼져있으면 종료
		if(!power) {
		return;
		}
		
		//기어가 중립 또는 주차 중이면 종료
		if(gear == 'N' || gear == 'P') {
		return;
		}
		
			//속력이 증가하는 경우이면 
			if(positive) {
			speed += 1;
			}
			//속력이 감소하는 경우이고, 속력이 0보다 크면
			else if(speed > 0) {
			speed -= 1;
			}
	}
	
	/**자동차 시동을 켜거나 끄는 메서드
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 = void
	 * 메서드명 : turn
	 */
	public void turn() {

		//시동이 꺼져 있으면 켬
		if(!power) {
			power = true;
		}
		else if(gear == 'P') {
			power = false;
		}
	}

	public String getName() {
		return name;
	}

	public String getCompany() {
		return company;
	}

	public int getYear() {
		return year;
	}

	public int getSpeed() {
		return speed;
	}

	public boolean isPower() {
		return power;
	}

	public void setGear(char _gear) {
		gear = _gear;
	}
	
}
