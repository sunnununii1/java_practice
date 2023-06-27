package day20.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ListEx {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>(); //숫자 저장 리스트
		
		//1부터 5까지 차례추가
		for(int i=1; i<=5; i++) {
			list.add(i); //정수 i가 박싱으로 Integer클래스의 객체가 된 후 list에 추가
			
		}
		//1을 더 추가
		list.add(1); //중복 허용이라 추가됨
		System.out.println(list);
		
		//두가지 remove 예제 비교
		//1을 제거
		list.remove((Integer)1); //Integer박싱으로 첫번째 만나는 1을 제거 후 true 반환
		System.out.println(list);
		//1번지에 있는 객체(3)을 제거
		Integer num = list.remove(1); //1번지에 있는 요소 제거 후 제거요소를 반환
		System.out.println(num);
		System.out.println(list);
		System.out.println(list.size()); //size():현재 저장된 객체 수(최대 객체 수 저장X)
	
		
		//List
		//일반 : List는 특정 번지 접근O, get() 이용하여 반복문 활용 가능
		for(int i=0; i<list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
		
		//향상된 for문 : List와 Set 모두 가능!
		for(int tmp : list) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		//Iterator
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) { //hasNext()는 다음 주소 찾기
			Integer tmp = it.next();
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		//List의 확인 코드
		System.out.println(list.contains(1)); //List에 1이 있는지 없는지 확인
		System.out.println(list.indexOf(1)); //List에 1이 몇번지에 있는지 확인
	}

}
