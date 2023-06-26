package day19.exception;

public class NullPointerExceptionEx {

	public static void main(String[] args) {
		
		/* NullPointerExceptionEx : 객체가 null인 상태로 메서드나 멤버 호출시 발생 */
		String str = null; //NullPointerExceptionEx 발생
		//String str = "abc"; //정상작동
		//System.out.println(str.substring(0));
		test(str);
	}
	
	/* 메서드 생성 시 매개변수의 null체크 반드시 하기! */
	public static void test(String str) {
		if(str == null) {
			return;
		}
		System.out.println(str.substring(0));
	}
}
