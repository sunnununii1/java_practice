package day19.date;

import java.util.Calendar;
import java.util.Date;

public class CalendarEx {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR); // == get(1)
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(year + "-" + month + "-" + day);
	
		//Date 객체를 Calendar 객체로
		Date date = new Date();
		cal = Calendar.getInstance();
		cal.setTime(date);
		
		//Calendar 객체를 Date 객체로
		cal = Calendar.getInstance();
		//Date(밀리초) 생성자는 1970년 1/1 0시 기준 밀리초만큼 흐른 뒤의 날짜를 초기화해주는 것
		Date date2 = new Date(cal.getTimeInMillis());
		
		
		//1970년 1/1 기준 1000ms 흐른 날짜객체 생성(==1초)
		//1초만 흐르게 했는데 9시간 추가된 이유 : 한국 시간대여서. 한국 시간은 UTC+9
		date2 = new Date(1000);
		System.out.println(date2);
	}
}
