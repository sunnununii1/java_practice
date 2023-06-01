package day3.operator;

public class SCEEx {

	public static void main(String[] args) {
		String str = "null";
		System.out.println(str + "는 abc와 같은가?" 
		+(str != null && str.equals("abc")));
		// str이 null이기 떄문에 str.xx으로 된 모든 곳에서 에러발생
		/* 단, && 앞에 null 체크한 코드가 먼저 오면 앞 부분 자체가 거짓이 되기 때문에
		 *  뒷 코드를 실행하지 않아도 넘어가진다 (SCE)
		 */
		
		// 아래 코드는 순서만 변경한 코드로, 문제 코드를 먼저 실행해서 결과 에러가 남
		/*System.out.println(str + "는 abc와 같은가?" 
				+(str.equals("abc") && str != null));
				* */
		
	}

}