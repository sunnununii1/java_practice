package day2.operator;

public class ArithmeticEx {

	public static void main(String[] args) {
		int num1 = 1, num2 = 2;
		int sum = num1 + num2;
		int sub = num1 - num2;
		int mul = num1 * num2;
		double div = (double)num1 / num2; // 실수가 나올 수 있기 때문에 double, 1/2의 결과가 0이어서 1.0/2가 되도록 형변환>0.5
		int mod = num1 % num2;
		
		System.out.println("" + num1 + '+' + num2 + "=" + sum);
		System.out.println("" + num1 + '-' + num2 + "=" + sub);
		System.out.println("" + num1 + '*' + num2 + "=" + mul);
		System.out.println("" + num1 + '/' + num2 + "=" + div);
		System.out.println("" + num1 + '%' + num2 + "=" + mod);
		
		int res = 0;
 		// 1 + res = 2; //대입연산자는 =이 왼쪽에 식이 와서 오류
		res = 2 - 1; //오른쪽에 식이 위치해야 함
		// 1 = res + 1; // 대입연산자는 왼쪽에 리터럴이 올 수 없음(상수나 변수만 가능)
		

	}

}
