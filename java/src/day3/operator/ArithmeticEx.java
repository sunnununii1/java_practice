package day3.operator;

public class ArithmeticEx {

	public static void main(String[] args) {
		byte num1 = 3;
		num1 = (byte)(num1 + 5);
		/* byte + 정수나 char + 정수는 결과가 int라서 바로 byte나 char에 저장불가
		 * 자료형 변환을 이용하여 저장
		 * 뒤에 전체를 괄호로 묶어야 한다
		 */
		
		
		char ch = 'A';
		System.out.println(ch);
		ch = (char)(ch + 1);
		System.out.println(ch);
		
		int num2 = 3;
		System.out.println(num2);
		num2 = (int)(3 + 4.0);
		System.out.println(num2);
		/* 정수(3)와 실수(4.0)를 더하면 커지므로 형변환 필요
		 * 
		 */

	}

}
