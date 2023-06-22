package day17.object;

import java.util.Objects;

import lombok.Data;

public class ObjectEx {

	public static void main(String[] args) throws CloneNotSupportedException{
		/*toString1*/Point1 pt1 = new Point1(10, 20);
		System.out.println(pt1);
		System.out.println(pt1.toString());
		
		/*equals1*/Point1 pt11 = new Point1(10, 20);
		System.out.println(pt1 == pt11);
		System.out.println(pt1.equals(pt11));
		
		System.out.println("==================");
		
		/*toString2*/Point2 pt2 = new Point2(30, 40);
		System.out.println(pt2);
		
		/*equals2*/Point2 pt21 = new Point2(30, 40);
		System.out.println(pt2 == pt21);
		System.out.println(pt2.equals(pt21));
		
		System.out.println("==================");
		
		//clone()을 이용하여 복제 성공
		/*clone*/Point2 pt22 = (Point2)pt2.clone();//다운캐스팅 => (클래스명) 반드시 추가
		//주소가 다르지만 
		System.out.println(pt2 == pt22);
		//두 객체는 같다는 판별
		System.out.println(pt2.equals(pt22));
		System.out.println(pt22);
	}

}

@Data //toString 1. @Data 붙이는 방법 (단, 이 방법은 toString()/equals()/hashcode() 세개 한번에 오버라이딩)
class Point1{
	private int x, y;
	
	public Point1(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Point2 implements Cloneable{
	private int x, y;
	
	public Point2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	//toString 2. toString 직접 입력방법
	/*public String toString() {
		return "(" + x + "," + y + ")";
	}*/
	
	//toString 3. 마우스 우클릭-소스-toString 클릭 자동완성 방법
	@Override
	public String toString() {
		return "Point2 [x=" + x + ", y=" + y + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		//주소가 같으면 같은 객체를 공유
		if (this == obj)
			return true;
		//없는 객체와 비교할 수 없다.
		if (obj == null)
			return false;
		//내 클래스와 비교할 객체의 클래스가 다른 경우 비교 안함 => 상황에 따라 비교코드 만들 수도 있음
 		if (getClass() != obj.getClass())
			return false;
 		//비교할 객체의 클래스가 같은 클래스인 경우
		Point2 other = (Point2) obj;
		//멤버들 각각 비교해 같은지 확인
		return x == other.x && y == other.y;
	}
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	
	
}