package day9.classex;

public class CarMain {

	public static void main(String[] args) {
	/* 현대 뉴 아반떼 2023년식 자동차 객체를 생성하는 코드를 작성하세요.
	 * */
		
		Car myCar = new Car("The new ABANTE", "Hyundai", 2023);
		
		//현재 내 차의 정보를 조회하는 코드
		myCar.printInfo();
		
		//전원 켜고, 기어를 D로 변환
		myCar.turn();
		myCar.setGear('D');
		myCar.speedChange(false);
		myCar.speedChange(false);
		myCar.speedChange(false);
		myCar.printInfo();
		
		//속력이 3 증가
		myCar.speedChange(true);
		myCar.speedChange(true);
		myCar.speedChange(true);
		myCar.printInfo();
		
		//속력이 1 감소
		myCar.speedChange(false);
		myCar.printInfo();


	}

}