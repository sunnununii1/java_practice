package day7.homework;

public class StarEx5 {

	public static void main(String[] args) {
		/*     *        i=1  공=5    *=1
		 *    ***       i=2  공=4    *=3
		 *   *****      i=3  공=3    *=5
		 *  *******     i=4  공=2    *=7
		 *     +
		 *   *****      i=5  공=3    *=5
		 *    ***       i=6  공=4    *=3   
		 *     *		i=7  공=5	*=1
		 * */ 

		for(int i=0 ; i<4 ; ++i) {
		
			for(int j=0 ; j<5-i; ++j) {
				System.out.print(' ');
			}
			for(int j=0 ; j<i*2+1 ; ++j) {
			System.out.print('*');
			}
			System.out.println();
		}
		
		for(int i=0 ; i<3 ; i++) {
			for(int j=0 ; j<3+i ; ++j) {
				System.out.print(' ');
			}
			for(int a=0 ; a<(3-i)*2-1 ; ++a) {
				System.out.print('*');
			}
			System.out.println();
		}
		
		
	}

}
