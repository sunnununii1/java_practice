package day8.overroading;

public class Ex1 {

	public static void main(String[] args) {
		
		System.out.println(1);
		System.out.println("1");
		System.out.println(1.1);
		System.out.println('c');
		//PrintIn에 마우스를 댔을 때, () 안 매개변수가 각각 다름을 알 수있음.
		// => PrintIn의 메서드 오버로딩
		
		System.out.println();
		
		System.out.println(sum(1,1));
		System.out.println(sum(1.1,1));
		System.out.println(sum(1,1.1));
		System.out.println(sum(1.1,1.1));
		
		//System.out.println(sum(1,2,3));
	}

	
	public static int sum(int num1, int num2) {
		return num1 + num2;
	}
	
	// 아래 3개는 매개변수의 타입이 다른 경우
	public static double sum(double num1, int num2) {
		return num1 + num2;
	}
	public static double sum(int num1, double num2) {
		return num1 + num2;
	}
	public static double sum(double num1, double num2) {
		return num1 + num2; //가장 효율적인 코드, 이 코드 하나만으로도 위 4개 출력이 가능
	}
	
	// 매개변수의 개수가 다른 경우
	/**public static int sum(int num1, int num2, int num3) {
		return num1 + num2 + num3;
	}
	*/
	
	// 리턴 타입만 다른 메서드는 오버로딩이 될 수 없다. () 안 매개변수가 달라 불가능
	/*public static double sum(int num1, int num2) {
		return num1 + num2
	* */
	
	}
	
	
