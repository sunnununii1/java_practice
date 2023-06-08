package day7.practice;

public class StarEx4 {

	public static void main(String[] args) {
		/*     *         i=1  공=5   *=1  *=0
		 *    ** *       i=2  공=4   *=3  *=1
		 *   *** **      i=3  공=3   *=5  *=2
		 *  **** ***     i=4  공=2   *=7  *=3
		 * ***** ****    i=5  공=1   *=9  *=4
		 *                    공=?   *=i  *=i-1개 추가됨
		 * */ 
		
	
		
		/* 외부 반복문
		 * 반복횟수 : i는 0부터 5까지 1씩 증가
		 * 규칙성 : * 1개를 출력 후 엔터
		 * */
		for(int i=0 ; i<5 ; ++i) {
			
			/* 공백 출력
			 * 내부 반복문
			 * 반복횟수 : j는 i부터 5까지 1씩 증가
			 * 규칙성 : ' '를 출력
			 * */
			for(int j=i ; j<5;++j) {
				System.out.print(' ');
			}
			
			/* * 출력
			 * 내부 반복문
			 * 반복횟수 : j는 1부터 i*2+1까지 1씩 증가
			 * 규칙성 : *을 출력
			 */
			for(int j=1; j<=i*2+1 ;++j) {
			System.out.print('*');
			}
			
		System.out.println();
		}
	}
}

	

