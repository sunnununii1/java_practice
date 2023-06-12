package day9.classex;

import java.util.Scanner;

public class StudentScoreManager {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.close();
		
			//korScore를 인스턴스, 객체 == 객체생성한 것
		Score1 korScore = new Score1();
		//Score1 korScore = new Score1(1,2,"korea Language");
		korScore.title = "korea Language";
		korScore.grade = 1;
		korScore.semester = 2;
		Score1 engScore = new Score1(1,2,"English");
		System.out.println(engScore.title);

	}

}

//성적 클래스
class Score1{
	String title;						//과목명
	int grade;							//학년
	int semester;						//학기
	double total;						//총점수
	double midTerm;						//중간고사
	double finalExam;					//기말고사
	double performance;					//수행평가
	
	//Score1 클래스의 기본 생성자
	public Score1() {
		/* title의 기본값은? null
		 * grade의 기본값은? 0
		 * total의 기본값은? 0.0
		 * */
		title = ""; //기저에 null로 초기화됨이 깔려있고, 생성자에서 한번 더 초기화한 것(총 2번 => 생성자 오버로드)
		grade = 1;
		semester = 1;
	}
	public Score1(int _grade, int _semester, String _title) {
		grade = _grade;
		semester = _semester;
		title = _title;
	}
}

//학생 클래스
class Student1{
	String name;							//이름
	String residentNumber;					//주민번호
	int grede;								//학년
	int classNum;							//반
	int number;								//번호
	int admissionYear;						//입학년도
	Score1 korScore, engScore, mathScore;	//국어,영어,수학 성적
}