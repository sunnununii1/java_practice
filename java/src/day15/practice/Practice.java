package day15.practice;

public class Practice {

	public static void main(String[] args) {
		//1. Hello를 10번 출력하려한다. 아래 코드에서 잘못된 부분 수정하세요.
		
		for(int i=0; i<10; i++) {
			System.out.println("Hello");
		}
		
		System.out.println("===========");
		//2. 1부터 10까지 짝수를 출력하려한다. 다음 빈칸에 맞는 코드를 작성하세요. 빈칸 외 수정X)
		
		for(int i=2; i<=10; i+=2) {
			System.out.println(i);		
		}
		
		//6. 다음 코드에서 잘못된 내용을 수정해라. 0번부터 차례대로 0,1,2,3,... 저장
		
		int arr[] = new int[10];
		for(int i=0; i<arr.length; i++) {
			arr[i] = i;
		}
		
		A a = new A(10);
		
	}

}

		//7. 다음 코드를 맞게 수정해라.
		class A{
			int num;
			public A(int num) {
				this.num = num;
			}
		}
