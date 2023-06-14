package day11.array;

public class ForEx1 {

	public static void main(String[] args) {
		int arr[] = new int[] {4,5,2,1,9};
		
		//일반 for문
		for(int i=0 ; i<arr.length ; i++) {
			int tmp = arr[i];
			System.out.println(tmp);
		}
		arr = new int[] {4,5,2,1,9};
		System.out.println("====");
		
		//향상된 for문
		for(int tmp : arr) {
			System.out.println(tmp);
		}
		
		System.out.println("====");
		//중간 수정했을 경우
		for(int tmp : arr) {
			tmp=0; //변수인 tmp의 값만 0으로 바꾸고, 배열은 그대로라 초기값 4,5,2,1,9는 그대로이다.
			System.out.println(tmp);
		}
	}

}
