package day26.book.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import lombok.Data;

@Data
//도서 대출 열람 클래스
public class borrowBrowsing implements Serializable{
	
	private static final long serialVersionUID = 170869066542413329L;
	
	private Book book; //대출 도서
	private Date borrowDate; //대출일
	private Date returnDate; //반납일
	
	public borrowBrowsing(Book book, Date date, int borrowPeriod) {
		this.book = book;
		this.borrowDate = date;
	}

	public String getBorrowDateSrt() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		return format.format(borrowDate);
				
	}
	public String getreturnDateSrt() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		//대출일로부터 14일 후 날짜로 고정
		Calendar cal = Calendar.getInstance();
		cal.add(borrowDate, 14);
		return format.format(returnDate);
	}
}

