package day20.collection;

import java.util.HashSet;

public class SetEx {

	public static void main(String[] args) {
		
		HashSet<Integer> set = new HashSet<>();
		set.add(10);
		set.add(20);
		set.add(30);
		System.out.println(set); //set은 순서보장X
		set.remove(10);
		System.out.println(set);
		System.out.println(set.contains(20)); //20이 있는지 확인
		System.out.println(set.size()); //저장된 갯수 확인
	}

}
