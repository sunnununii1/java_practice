package day11.array;

public class ArrayCopyEx {

	public static void main(String[] args) {
		//배열인 arr1과 arr2는 참조변수(값 저장x, 값이 있는 주소 저장o)
		//=> arr2 0번지만 10으로 바꿨음에도 arr1의 0번지도 같이 공유되어 바뀜
		int arr1[] = new int[] {1,2,3,4,5};
		int arr2[] = arr1; //arr2의 배열을 arr1과 공유한다는 코드

		arr2[0] = 10;
		
		for(int tmp : arr1) {
			System.out.println(tmp);
		}
		
		arr2[0] = 1; //다시 초기값으로 되돌림
		
		arr2 = new int[arr1.length]; //복사 위한 배열을 새로 생성
		for(int i=0 ; i<arr1.length ; i++) {
			arr2[i] = arr1[i];
		}
		
		arr2[0] = 10; //반복문으로 복사된 arr2에 0번지를 수정해도 arr1은 변하지 않음을 볼수있다.
		
		System.out.println("=====");
		for(int tmp : arr1) {
			System.out.println(tmp);
		}
		
		//방법2.
		
		int arr3[] = new int[arr1.length];
		//arr1의 0번지부터 복사본arr3의 0번지부터 arr1.length까지 복사
		System.arraycopy(arr1, 0, arr3, 0, arr1.length); 
		
		arr3[0] = 10;
		
		System.out.println("=====");
		for(int tmp : arr3) {
			System.out.println(tmp);
		}
	}

}
