package day10.thisex;

public class StudentMain {

	public static void main(String[] args) {
		Student1.printCount(); //객체 만들기 전
		
					//new는 Student1() < 즉 생성자만 조절
		Student1 std1 = new Student1(1,1,1,"Hong"); 
		Student1.printCount(); //"홍길동" 객체 만든 후

		Student1 std2 = new Student1(1,1,1,"Lim");
		Student1.printCount(); //"홍길동" "임꺽정" 객체 만든 후
		
		//std2.studentCount = 1; 
		//System.out.println(std1.studentCount); //std1, std2 서로 공유하고 있어 영향 줌
		std1.print();
		// Student.print(); // static이 print에는 안붙어서 에러
		std2.print();
		System.out.println(std1);
		System.out.println(std2);
	}

}
class Student1{
	static int studentCount;
	private int grade, classNum, number;
	private String name;
	
	//아래 생성자는 매개변수가 있고, 매개변수와 멤버변수가 이름이 같아 멤버변수 호출시 this 반드시 붙임!
	public Student1(int grade, int classNum, int number, String name) {
		this.grade = grade;
		this.classNum = classNum;
		this.number = number;
		this.name = name;
		studentCount++;
	}
	
	//기본 생성자는 매개변수가 없기 때문에 this를 쓰지 않아도 가능
	public Student1() {
		//멤버변수와 이름이 같은 지역 변수를 만들수도 있다.(다만, 비추천)
		//int grade = 10;
		//this.grade = grade;
		this(1,1,1,""); // this로 호출시, 코드 첫라인에만 가능! (예로, 아래 name 코드를 위로 옮기면 오류)
		name = "";
		/*grade = 1;
		classNum = 1;
		number = 1;
		name = "";
		* */
		
	}
	public void print() {
		System.out.println("=================");
		System.out.println("grade		: " + grade); //객체변수 사용가능
		System.out.println("classNum	: " + classNum);
		System.out.println("number		: " + number);
		System.out.println("name		: " + name);
			
		//클래스 변수 사용 가능
		//System.out.println("count		: " + studentCount);
		//클래스 메서드 사용 가능
		//printCount();
	}
		//클래스 메서드
	public static void printCount() {
		//클래스 변수 사용 가능
		System.out.println("Resistered student count : " + studentCount);
		//grade = 1;	//객체변수 직접 사용 불가능
		//print();		//객체메서드 직접 사용 불가능
			
		//객체 생성 후, 호출해서 사용 가능
		Student1 std1 = new Student1();
		std1.name = "Hong";
		std1.print();
	}
}

		
	
