package day22.lambda;

public class LambdaEx1 {

	public static void main(String[] args) {
		//1.오버라이딩
		InterfaceA a = new InterfaceA() {
			
			@Override
			public int getMax(int num1, int num2) {
				return num1 >= num2 ? num1 : num2;
			}
		};
		System.out.println(a.getMax(10, 20));
		
		
		//2.람다식으로(1보다 코드 간결)
		InterfaceA b = (num1, num2) ->{
			return num1 >= num2 ? num1 : num2;
		};
		System.out.println(b.getMax(10, 20));
		
		
		//2-2. 람다식 간소화 : 실행문 1줄일 때 {} + return 생략
		InterfaceA c = (num1, num2) -> num1 >= num2 ? num1 : num2;
		System.out.println(c.getMax(10, 20));
		
	}

}	


interface InterfaceA{
	int getMax(int num1, int num2);
}
