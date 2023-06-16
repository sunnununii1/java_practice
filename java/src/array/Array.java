package array;

public class Array {
	
	public static void printArray(int arr[]) {
		System.out.print("[");
		for(int i=0 ; i<arr.length ; i++) {
			System.out.print(arr[i] + (i==arr.length-1 ? "" : ","));
		}
		System.out.println("]");
	}
	
	//위에꺼 오버로딩해서 아래로 수정한 것
	//배열을 start번지부터 end-1번지까지 출력
	public static void printArray(int arr[], int start, int end) {
		System.out.print("[");
		for(int i = start; i<end ; i++) {
			if(i >= arr.length) {
				break;
			}
			System.out.print(arr[i] + (i==end-1 ? "":", "));
		}
		System.out.print("]");
	}
	
	//num가 배열의 원소 중 0번지부터 count개 안에 있는지 확인하는 메서드
	public static boolean contains(int arr[], int num, int count) {
		for(int i=0 ; i<count ; i++) {
			if(num==arr[i]) {
				return true;	//증복 발견시 break로 멈출 필요 없이, 바로 메서드 종료로 중복 알림
			}
		}
		//여기까지 왔다는 건  return true를 못 만났다는 뜻 => 중복이 없었다는 뜻
		return false; //true false 둘 다 가능 (에러방지용)
	}
	
	public static int[] createRandomArray(int min, int max, int arr[]) {
		if(max < min) {
			//max가 min보다 작으면 두 수 교환
			int tmp = max;
			max = min;
			min = tmp;
		}
		
		//배열이 생성되어 있지 않으면 min과 max 사이의 랜덤한 수의 배열 생성
		if(arr == null) {
			arr = new int[max - min + 1];
		}
		
		/*랜덤으로 만들어지는 수의 개수가 배열의 크기보다 작으면 메서드 종료
		 * ex. 1~3이면 3개가 4개짜리 배열에 중복되지 않게 못들어감 */
		if(max - min +1 < arr.length) {
			return null;
		}
		
		int count = 0;
		while(count< arr.length) {
			int random = (int)(Math.random()*(max-min+1) + min);
			//중복되지 않았을 때, 배열에 저장 후 count 증가
			if(!contains(arr,random,count)) {
				arr[count] = random;
				count++;
			}
		}
		return arr;
	}
	/** 주어진 배열에 중복된 값이 있는지 없는지 알려주는 메서드
	 * 매개변수 : 배열 = int arr[]
	 * 리턴타입 : 중복 여부 => boolean
	 * 메서드명 : arrayCheck
	 */
	public static boolean arrayCheck(int arr[]) {
		if(arr == null) {
			return false;
		}
		//arr 배열의 다른 번지들끼리 비교해서 같은 값이 있는지 확인하는 반복문
		for(int i = 0 ; i<arr.length ; i++) {
			for(int j =0 ; j<arr.length ; j++) {
				//같은 번지일 땐 건너뜀
				if(i == j) {
					continue;
				}
				//다른 번지이고, 값이 같으면 중복되어 리턴
				if(arr[i] == arr[j]) {
					return true;
				}
			}
		}
		//반복문이 끝날 때까지 중복이 안나오면 안됐다고 리턴
		return false;
	}
	
	/** 정수형 배열이 주어지면 오름차순으로 버블 정렬하는 메서드
	 * 매개변수 : 정수형 배열 => int arr[]
	 * 리턴타입 : void
	 * 메서드명 : sort
	 */
	public static void sort(int arr[]) {
		if(arr == null) {
			return;
		}
		for(int i=0; i<arr.length-1; i++) {
			//-i의 유무는 선택가능(반복횟수 줄이기 위함)
			for(int j=0; j<arr.length-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
	}
}
