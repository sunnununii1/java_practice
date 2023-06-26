package day19.exception;

public class ExceptionEx1 {

	public static void main(String[] args) {
		/*num2의 값이 0이어도 오류 표시 없음
		 * but, 예외 발생으로 run시 프로그램 중단(==ArithmeticException)
		 * => 코드상으론 오류 표시 없지만 의도치않은 프로그램 중단은 RuntipmeException! */
		int num1 = 1, num2 = 0;
		
		System.out.println(num1/num2);

	}

}

class A implements Cloneable{
	
	/* clone 메서드 오버라이딩을 위해 Onject 클래스의 clone을 호출시,
	 * =>CloneNotSupportedException 발생할 수 있음(반드시 발생x, 가능성이 있다o)
	 
	 * CloneNotSupportedException는 RuntimeException 클래스의 자식 클래스가 아님 
	 * => 반드시 예외처리를 해야한다는 뜻! */
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
