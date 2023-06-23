package day18.practice;

import java.util.Scanner;

public class StringCharAtEx {

	public static void main(String[] args) {
		// 영문 소문자로 된 문자열 입력받아 알파벳이 각각 몇개있는지 확인하는 코드 작성하세요.
		//input : hello world(d:1 e:1 h:1 l:3 o:2 r:1 w:1)

		Scanner sc = new Scanner(System.in);
		int alphabet[] = new int[26]; //각 알파벳 개수 저장하는 배열(0번지:a개수 1번지:b개수..)
		
		//입력
		System.out.println("input : ");
		String str = sc.nextLine();
		
		//반복(문자열 길이만큼)
		for(int i=0; i<str.length(); i++) {
			//문자열 한글자씩 가져와 알파벳 확인해 개수 증가
			char ch = str.charAt(i); //i번지 문자열을 가져옴
			int distance = ch - 'a'; //ch가 알파벳소문자이면 0~25 사이
			  //영문 소문자가 아닌 경우
			if(distance < 0 || distance > 25) {
				continue;
			}
			 //영어 소문자인 경우
			 alphabet[distance]++;
		}
		//알파벳 개수 추가
		for(int i=0; i<alphabet.length; i++) {
			if(alphabet[i] == 0) {
				continue;
			}
			
			System.out.println((char)('a' + i) + " : " + alphabet[i]);
		}
		sc.close();
	}
	
	
 }


