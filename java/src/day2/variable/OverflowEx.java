package day2.variable;

public class OverflowEx {

	public static void main(String[] args) {
		byte num =127;
		++num; //num에 1을 증가시킴
		System.out.println(num); //오버플로우 발생하여 음수로 변환
		
		num = -128;
		--num;
		System.out.println(num); //언더플로우 발생하여 양수로 변환

	}

}
