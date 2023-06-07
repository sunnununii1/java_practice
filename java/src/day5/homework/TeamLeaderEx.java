package day5.homework;

import java.util.Scanner;

public class TeamLeaderEx {

	public static void main(String[] args) {
		/* 30명의 학생이 있는 반에서 1번부터 연속된 번호를 가진 3명의 학생이 1조가 된다.
		 * 이때 가장 큰 번호인 학생이 조장이 된다.
		 * 번호가 주어졌을 때 조장인지 조원인지 판별하는 코드를 작성하세요. (switch문으로)
		 * 
		 * input student number : 
		 * 1
		 * student number 1 is a member of the team.
		 * input student number : 
		 * 6
		 * student number 6 is a member of the leader.
		 * */
		
		
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("input student number : ");
		num = sc.nextInt();		
		//학생 번호 입력받음
		
			//학생 번호가 팀장 번호인지 아닌지 판별
			//번호가 3의 배수이면 팀장 출력, 아니면 팀원 출력
			switch(num % 3) {
				 // num을 3으로 나누었을 때 나머지가 0과 같다면 팀장, 아니면 팀원 -> num&3==0
			case 0:
			System.out.println("student number " + num + " is a member of the leader");
			break;
			
			default:
			System.out.println("student number " + num + " is a member of the team");
			
			}
			

			sc.close();
	}

}
