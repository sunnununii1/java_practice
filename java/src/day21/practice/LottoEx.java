package day21.practice;

import java.util.HashSet;
import java.util.Scanner;

public class LottoEx {

	public static void main(String[] args) {
		/* 로또 프로그램을 Set을 이용해 구현 */
		
	  	int bonus;
		HashSet<Integer> lotto = new HashSet<>();
		HashSet<Integer> user = new HashSet<>();
		int min = 0, max = 45;
		
		
		// 로또번호 6개 + 보너스 번호 1개 랜덤 출력 (1~45)
		while(lotto.size() < 6) {
			lotto.add((int)(Math.random() * (max-min+1) + min));
		}
		
		do {
			bonus = (int)(Math.random() * (max-min+1) + min);
		}while(lotto.contains(bonus));

		
		System.out.println(lotto);
		System.out.println("bonus : " + bonus);
		
		
		//내가 번호 6개 입력
		Scanner sc = new Scanner(System.in);
		System.out.println("input 6 numbers : ");
		while(user.size() < 6) {
			user.add(sc.nextInt());
		}
		sc.close();
		
		//등수 체크
		//일치하는 개수 확인
		int count = 0;
		for(Integer tmp : user) {
			if(lotto.contains(tmp)) {
				count++;
			}
		}
		
		//개수 이용해서 등수 체크
		switch(count) {
		case 6: System.out.println("rank 1"); break;
		case 5: 
			if(user.contains(bonus)) {
				System.out.println("rank 2");
			}else {
				System.out.println("rank 3");
			}
			break;
		case 4: System.out.println("rank 4"); break;
		case 3: System.out.println("rank 5"); break;
		default: System.out.println("fail");
		}
		
	}
	

}
