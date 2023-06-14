package day11.practice;

public class ArrayRandomEx2 {

	public static void main(String[] args) {
		// 1~9 사이의 랜덤한 수를 3개 만들어서 배열에 저장한 후, 출력하는 코드를 작성하세요.
		// 단, 중복되지 않게

		int min = 1, max = 9;
		//자료형[] 배열명 = new 자료형[개수];
		int[] arr = new int[3];
		
		/* 방법 1. 9번지까지 있는 배열을 이용
		 * 장점 : 작업이 단순 / 단점 : 저장공간 필요
		 */
		boolean checkArr[] = new boolean[10];
		for(int i=0 ; i<3 ;) {
			int random = (int)(Math.random() * (max-min+1) + min);
			//checkArr배열에 random번지에 있는 값이 false이면
			if(!checkArr[random]) {
				//random을 배열에 저장
				arr[i] = random;
				//i를 증가(윗줄 증감식과는 다름)
				i++;
				//checkArr배열에 random번지에 있는 값을 true로 변경
				checkArr[random] = true;
				}
		}
		
		for(int i=0 ; i<3 ; i++) {
			System.out.println(arr[i]);
		}
		
		// 방법 2. 저장된 값들을 비교(이중반복문 사용)
		int count = 0; //현재 저장된 랜덤 수 갯수
		int i = 0; //반복문에서 사용할 변수
		
		while(count<3) {
			int random = (int)(Math.random() * (max-min+1) + min);
			//이미 저장된 랜덤 수들과 하나하나 비교해서 같은게 있는 지 확인하여 있으면 반복문 종료
			for(i=0 ; i<count ; i++) {
				if(random==arr[i]) {
					break;
				}
			}
			/* 위 반복문에서 break를 만나지 않으면 i는 count일 때 종료함
			 * 반복문 종료 후 i는 count와 같다.
			 * 단, break를 만나서 중간에 빠져나오면 i는 count보다 작다.
			 */
			if(i==count) {
				arr[count] = random;
				count++;
				//arr[count++] = random;
			}
		}
		System.out.println("========");
		printArray(arr);
		
		
		//방법 3. 방법2를 메서드로 변형
		createRandomArray(min,max,arr);
		System.out.println("========");
		printArray(arr);
		
	}
	
		
	/** 정수형 배열이 주어지면, 정수형 배열의 값을 콘솔에 출력하는 메서드
	 * 매개변수 : 배열과 배열의 개수 => 정수 => int arr[], int size
	 * 리턴타입 : 없음 => void
	 * 메서드명 : printArray
	 */
	public static void printArray(int arr[]) {
		int i;
		for(i=0 ; i<arr.length ; i++) {
			System.out.println(arr[i]);
		}
	}
	
	/**정수 num가 배열의 0번지부터 count개 만큼 확인했을 때 중복된 값이 있는지 없는지 알려주는 메서드
	 * 매개변수 : 중복을 확인할 배열, 비교할 정수 num, 비교할 갯수 count
	 * 			=> int arr[], int num, int count
	 * 리턴타입 : 있는지 없는지(A아니면 B) => boolean
	 * 메서드명 : contains
	 */
		//static는 객체 만들지 않아도 contains을 쉽게 호출위함
	public static boolean contains(int arr[], int num, int count) {
		for(int i=0 ; i<count ; i++) {
			if(num==arr[i]) {
				return true;	//증복 발견시 break로 멈출 필요 없이, 바로 메서드 종료로 중복 알림
			}
		}
		//여기까지 왔다는 건  return true를 못 만났다는 뜻 => 중복이 없었다는 뜻
		return false; //true false 둘 다 가능 (에러방지용)
	}
	
	/** min에서 max 사이의 랜덤한 수를 생성해서 배열에 저장하는 메서드
	 * 매개변수 : 최소값, 최대값, 배열 => int min, int max, int arr[]
	 * 리턴타입 : 없음 => void
	 * 메서드명 : createRandomArray
	 */
	public static void createRandomArray(int min, int max, int arr[]) {
		//배열이 생성되어 있지 않으면 (배열이 null) 메서드 종료
		if(arr == null) {
			return;
		}
		
		/*랜덤으로 만들어지는 수의 개수가 배열의 크기보다 작으면 메서드 종료
		 * ex. 1~3이면 3개가 4개짜리 배열에 중복되지 않게 못들어감
		 */
		if(max - min +1 < arr.length) {
			return;
		}
		
		int count = 0;
		while(count<3) {
			int random = (int)(Math.random()*(max-min+1) + min);
			//중복되지 않았을 때, 배열에 저장 후 count 증가
			if(!contains(arr,random,count)) {
				arr[count] = random;
				count++;
			}
		}
	}
}
