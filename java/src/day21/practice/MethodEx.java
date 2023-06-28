package day21.practice;

public class MethodEx {

	public static void main(String[] args) {
		System.out.println(sum(1));
		System.out.println(sum(1,2));
		System.out.println(sum(1,2,3,4,5));

	}

	/* 여러개의 정수의 합을 알려주는 메서드 (가변 매개변수 이용) */
				 //매개변수가 두개일 땐, 가변 매개변수는 끝에만 사용가능
	public static int sum(int ... nums) {
		int sum = 0;
		for(int i=0; i<nums.length; i++) {
			sum += nums[i];
		}
		return sum;
	}
	
}
