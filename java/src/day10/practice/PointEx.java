package day10.practice;

public class PointEx {

	public static void main(String[] args) {
		/* 좌표의 점을 관리하는 클래스를 만들고 테스트하는 코드를 작성해라.
		 * 필요한 속성과 기능을 생각해서 추가해보세요.( 예: 그림판 하단의 좌표)
		 */
		
		Point pt1 = new Point();
		pt1.print();
		
		pt1.move(10,20);
		pt1.print();
		
		Point pt2 = new Point(30,40);
		pt2.print();

		
	}

}
//점을 관리하는 클래스
/* 클래스의 접근제어자가 public으로 올 수 있는 조건 => 파일명과 클래스명이 같아야 public 붙이기 가능
 * 같은 패키지에 같은 이름의 클래스가 있으면 안됨
 * */
class Point{
	//멤버변수(x좌표, y좌표 필요)
	private int x;
	private int y;
	
	//0으로 초기화할 생성자(()안에 x=0,y=0 안쓰는 이유는 이미 위에 멤버변수에서 초기화되어 있어서)
	public Point() {}
	
	//x,y좌표가 주어졌을 때 객체를 초기화해줄 생성자 (==2개이므로 생성자 오버로딩)
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	//getter, setter(원래는 메서드에 포함하나 편의상 분리)	
	/* public 리턴타입 get변수명(){
	 * 		 return 변수명;
	 * }
	 * get변수명에서 변수명의 첫글자를 대문자로 표기
	 * 리턴타입은 변수의 자료형
	 * 
	 * setter
	 * public void set변수명(자료형 변수명){
	 * 		this.변수명 = 변수명;
	 * }
	 * */
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}	
	
	//메서드
	/**현재 좌표를 출력하는 기능
	 * 매개변수 : 없음
	 * 리턴타입 : 없음 => void
	 * 메서드명 : print
	 */
	public void print() {
		System.out.println("" + x + "," + y + "px");
	}
	
	/**주어진 x,y좌표로 이동하는 메서드(=> 멤버변수 x,y를 주어진 x,y로 수정하는 메서드)
	 * 매개변수 : 주어진 x,y => int x, int y
	 * 리턴타입 : 없음 => void
	 * 메서드명 : move
	 */
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
}