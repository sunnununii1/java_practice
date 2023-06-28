package day21.set;

import java.util.ArrayList;
import java.util.HashSet;

public class SetRandomEx {

	public static void main(String[] args) {
		/* 1. 배열을 이용해서 1~9사이 중복없는 랜덤 수 3개를 저장 */
		int arr[] = new int[3];
		int count = 0;
		int min = 1, max = 9;
		
		while(count < 3) {
			int r = random(min, max);
			int i; //for문 안에 선언하면 빠져나왔을 때 위치를 알 수 없음
			for(i=0; i<count; i++) {
				if(arr[i] == r) {
					break;
				}
			}
			//중복된 값이 없으면
			if(i == count) {
				arr[count++] = r;
			}
		}
		System.out.print("[");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + (i == arr.length-1 ? "":", "));
		}
		System.out.println("]");
		
		
		/* 2. List를 이용해서 1~9사이 중복없는 랜덤 수 3개를 저장 */
		ArrayList<Integer> list = new ArrayList<>();
		
		while(list.size() < 3) { //List문은 count변수 필요없음
			int r = random(min,max);
			if(!list.contains(r)) { //contains가 코드를 줄여주는 역할!
				list.add(r); //list에 r이 없으면 r을 추가한다
			}
		}
		System.out.println(list);
		
		
		/* 3. Set을 이용해서 1~9사이 중복없는 랜덤 수 3개를 저장 */
		HashSet<Integer> set = new HashSet<>();
		
		while(set.size() < 3) {
			int r = random(min, max);
			set.add(r);
			
		}
		System.out.println(set);
		
	}

	public static int random(int min, int max) {
		if(min > max) {		//선택. 안정화 작업
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random() * (max-min+1) + min);
	}
}
