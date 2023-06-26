package day19.format;

import java.text.MessageFormat;

public class MessageFormatEx {

	public static void main(String[] args) {

		int x = 1, y = 2;
		String str = "(" + x + "," + y + ")"; //기존은 문자열 + 이용
		System.out.println(str);
		
		x = 3;
		y = 5;
		str = "(" + x + "," + y + ")";
		System.out.println(str);
		
		
		//MessageFormat
		x = 10;
		y = 20;
		String message = "({0},{1})"; //한번 만들어 놓으면 밑에서 계속 사용
		String str2 = MessageFormat.format(message, x, y);
		System.out.println(str2);
		
		x = 30;
		y = 40;
		str2 = MessageFormat.format(message, x, y);
		System.out.println(str2);
	}

}
