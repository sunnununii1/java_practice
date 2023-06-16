package day13.practice;

public class SubjectEx {

	public static void main(String[] args) {
		// 성적을 관리하기 위한 Subject 클래스를 만드세요.
		
		Subject sub1 = new Subject("Kor");
		sub1.print();
		sub1.updateScore();
		
		System.out.println("==================");
		
		Subject sub2 = new Subject("Eng", 1, 1);
		sub2.print();
		
		System.out.println("==================");
		
		Subject sub3 = new Subject("Math", 1, 1);
		sub3.print();

	}

}
