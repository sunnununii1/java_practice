package day20.collection;

import java.util.ArrayList;

public class ListEx2 {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student(1,1,1,"Hong"));
		list.add(new Student(1,1,2,"Ga"));
		list.add(new Student(1,1,3,"Na"));
		list.add(new Student(1,1,4,"Ra"));
		list.add(new Student(1,1,5,"Ma"));
		System.out.println(list);
		
		//Hong 삭제하기
		/* remove메서드는 Objects클래스의 equals를 호출해서(Objects.equals(A,B)) true일때만 삭제!
		 * =>A가 자기자신, B가 삭제하려는 객체
		 * =>A, B의 클래스가 다르면 false를 리턴
		 * =>A, B의 클래스가 같으면 A.equals(B)를 호출해 결과 리턴
		 * Student 클래스에 equals를 오버라이딩하지 않으면 equals는 주소를 비교 
		 * =>학년,반,번호,이름은 같지만 새로운 객체를 만들었기 때문에 주소는 다름
		 * =>다른 객체를 판별해서 삭제가 안되는 것! 
		 * => 오버라이딩 필요.( @Date 필요 )*/
		//list.remove(new Student(1,1,1,"Hong"));
		System.out.println(list);
		
		//contains, indexOf도 Objects.equals 호출해서 같은 객체를 찾음
		System.out.println(list.contains(new Student(1,1,1,"Hong")));
		System.out.println(list.indexOf(new Student(1,1,1,"Hong")));
	}

}
