package day22.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamEx {

	public static void main(String args[]) {
		Integer arr[] = {1,2,3,4,5};
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		
		Stream<Integer> arrStream = Arrays.stream(arr);
		Stream<Integer> listStream = list.stream();
		
		//전체 출력
		//배열이나 리스트나 스트림을 사용하는 순간 동일해진다.
		arrStream.forEach(num->System.out.println(num));
		System.out.println("========");
		listStream.forEach(num->System.out.println(num));
		System.out.println("========");

		
		//3보다 큰 수 출력
		//filter로 중간연산(num이 3보다 큰) => 최종연산 순서
		arrStream = Arrays.stream(arr); //스트림은 일회용이라 출력 전 각각 추가해야함
		arrStream.filter(num-> num>3).forEach(num->System.out.println(num));
		
		System.out.println("========");
		
		listStream = list.stream();
		listStream.filter(num-> num>3).forEach(num->System.out.println(num));
		
	}
}
