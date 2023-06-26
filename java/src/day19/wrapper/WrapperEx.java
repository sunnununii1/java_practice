package day19.wrapper;

public class WrapperEx {

	public static void main(String[] args) {
		Integer num1 = 10; //박싱이다. 정수 10을 Integer 클래스 객체 num1에 저장 (int num == Integer)
		//num1 = null;
		int num2 = 0; 
		if(num1 != null) {
			num2 = num1; //언박싱이다. Integer 클래스 객체 num1에 있는 값을 num2에 저장(예외처리)
		}
		
		System.out.println(num1);
		System.out.println(num2);
		
		//ArrayList<Integer>list;
		
		//Integer.parseInt처럼 문자열>기본자료형 변환 메서드 사용시엔 예외처리해주는 것이 좋다
		int num3 = Integer.parseInt("123");
		System.out.println(num3);
	}

}
