package day13.sort;

import java.util.Arrays;
import java.util.Comparator;

import array.Array;

public class ArraySortEx {

	public static void main(String[] args) {
		// 배열정렬 - 버블정렬 예제
		int arr[] = {1, 4, 7, 9, 2, 8, 3, 6};
		
		Array.printArray(arr);
		System.out.println();
		
		for(int i=0; i<arr.length-1; i++) {
								//-i의 유무는 선택가능(반복횟수 줄이기 위함)
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
			
			Array.printArray(arr);
		}
		
		System.out.println();
		Integer arr2[] = {1, 4, 7, 9, 2, 8, 3, 6};
		//Arrays.sort(arr2); //오름차순
		Arrays.sort(arr2, Comparator.reverseOrder()); //내림차순
		for(Integer tmp : arr2) {
			System.out.print(tmp + " ");
		}
	}
}
