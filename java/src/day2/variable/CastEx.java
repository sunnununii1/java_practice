package day2.variable;

public class CastEx {

	public static void main(String[] args) {
		int pi = (int) 3.14; // 3.14는 double형 리터럴이라 int에 저장 못 함 -> 강제형변환 필요
		
		double num1 = 3; //3은 int형 리터럴이라 double형 변수에 저장 가능 -> 자동형변환이다.
		
		int num2 = (int) 123L; //123L은 long형 리터럴이라 int에 저장 못 함 -> 강제형변환 필요
		
		//실제 데이터 분실이 없어도 타입에 맞게 강제형변환을 해야한다.
		
		System.out.println(pi);
		System.out.println(num2);
		
		System.out.println((double)1/2);
	}

}
