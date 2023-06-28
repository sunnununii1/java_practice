package day21.practice;

import java.util.ArrayList;
import java.util.Comparator;

public class ListSortEx {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(10);
		list.add(4);
		list.add(8);
		System.out.println(list);
		list.sort(null);
		
		/* 리스트에 있는 sort는 compare메서드를 가진 객체가 필요
		 * 왜? 정렬기준을 compare로 하기때문. compare값이 음수이면 앞으로, 같으면 0, 양수이면 뒤로 정렬 
		 * 객체가 compare메서드를 반드시 갖게 하려면 Comparator 인터페이스를 구현한 구현클래스만 오게 지정*/
		list.sort(new IntegerCompare());
		System.out.println(list);
		
	}

}
	class IntegerCompare implements Comparator<Integer>{
		
		@Override
		public int compare(Integer o1, Integer o2) {
			return o1 - o2;
		}
}