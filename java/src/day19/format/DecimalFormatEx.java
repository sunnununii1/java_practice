package day19.format;

import java.text.DecimalFormat;

public class DecimalFormatEx {

	public static void main(String[] args) {
		int price = 10000; //10,000처럼 표현하고 싶다
		DecimalFormat df = new DecimalFormat("\u00A4###,###"); //정수 3자리마다 ,를 추가
		String str1 = df.format(price);
		System.out.println(str1);
		
		df = new DecimalFormat("000,000"); //#과 달리 빈자리 있을 경우 앞을 0으로 채움
		String str2 = df.format(price);
		System.out.println(str2);
	}

}
