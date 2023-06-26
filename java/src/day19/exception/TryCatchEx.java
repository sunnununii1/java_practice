package day19.exception;

public class TryCatchEx {

	public static void main(String[] args) {
		/* catch는 최소 1개 이상 필요 
		 * 어떤 예외가 발생할지 모를 땐 Exception 이용하기 */
		
		try {
			//예외가 발생할 수 있는 코드
			System.out.println(1 / 0); //ArithmeticException이 발생
		}catch(ArithmeticException e) {
			System.out.println("예외처리");
		}catch(Exception e){		   /*첫번째 catch로 가서 ArithmeticException 클래스의 객체를
										Exception으로 변환 가능한지 확인 후, 가능하면 처리*/
			//예외처리
			System.out.println("예외처리");
		
		//위에 Exception에서 모든 예외가 걸리기 때문에 아래의 catch를 실행X
		}/*catch(ArithmeticException e) {
			System.out.println("예외처리");
		}*/
		System.out.println("프로그램 종료");
	}

}
