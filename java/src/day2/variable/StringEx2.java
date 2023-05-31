package day2.variable;

public class StringEx2 {

	public static void main(String[] args) {
		String str = "";
		char op = '+';
		int num1 = 1, num2 = 2;
		
		str = num1 + op + num2 + "=" + (num1+num2);
		//앞에 ""를 붙이지 않으면 op가 정수 43으로 변환되어 ①43과 1이 더해짐> ②44와 2가 더해짐 : 46=3이 된다.
		
		str = "" + num1 + op + num2 + "=" + (num1+num2);
		// 맨 앞 빈 문자열 ""과 num1이 계산되어 문자열 1과 +가 더해짐 : 1+2=3이 된다.
		
		System.out.println(str);

	}

}
