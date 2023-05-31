package day2.variable;

public class ConstantEx {
    
	public static void main(String[] args) {
		final int MAX_AGE; 
		//MAX_AGE : 상수, 100 : 리터럴
		MAX_AGE = 100;
		//MAX_AGE = 101; <- 추가시 에러 발생, 1번 초기화 한 후 수정하려고 했기 때문이다.
		System.out.println(MAX_AGE);
		
// 상수는 선언과 동시에 반드시 초기화하는 것이 좋다.
		
		int totalCount;
		//totalCount는 지역변수! 지역변수는 자동으로 초기화 안되므로 사용 전에 반드시 초기화 해야함. 되어있지 않아서 사용이 불가능 -> 에러 발생
        //System.out.println(totalCount); 
	
	}

}
