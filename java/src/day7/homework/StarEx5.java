package day7.homework;

public class StarEx5 {

	public static void main(String[] args) {
		/*    *        i=1   공=3     *=1
		 *   ***       i=2   공=2     *=3
		 *  *****      i=3   공=1     *=5
		 * *******     i=4   공=0     *=7
		 *    +			  공=half-i 	 *=2*i-1
		 *  *****      i=5   공=1     *=5 (5는 2*3-1과 같다)
		 *   ***       i=6   공=2     *=3 (3는 2*2-1과 같다)
		 *    *		   i=7   공=3     *=1 (1는 2*1-1과 같다)
		 *    			  공=i-half   *=2*(num+1-i)-1 (은 2*(num-i)+1과 같다)
		 * */ 	

		
		//위 4줄부터 먼저 출력 => (num+1) / 2 
		int num = 7;
		for(int i=1 ; i<=num; ++i) {
			int half = (num+1) / 2;
			
			if(i <= half ) {
				//half-i개 공백 출력
				for(int j =1; j<=half-i; j++) {
					System.out.print(' ');
				}
				for(int j=1; j<=2*i-1; j++) {
					System.out.print('*');
				}
				System.out.println();
			}
			//3줄
			else {
				//i-half개 공백 출력
				for(int j =1; j<=i-half; j++) {
					System.out.print(' ');
				}
				//2*(num-i)+1개 *출력
				for(int j=1; j<=2*(num-i)+1; j++) {
					System.out.print('*');
				}
				//엔터
				System.out.println();
			}
		}
	}
}
