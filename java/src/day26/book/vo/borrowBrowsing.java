package day26.book.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import lombok.Data;

@Data
//도서 대출 열람 클래스
public class borrowBrowsing implements Serializable{
	
	private static final long serialVersionUID = 170869066542413329L;
	
	private Book book; //대출 도서
	private Date borrowDate; //대출일
	private Date returnDate; //반납일
	private Date estimatedDate; //반납 예정일
	
	public borrowBrowsing(Book book, Date date, int borrowPeriod) {
		this.book = book;
		this.borrowDate = date;
		//대출 기한을 이용하여 반납 예정일 추가
		calculateReturnDate(borrowPeriod);
	}

	private void calculateReturnDate(int borrowPeriod) {
		//반납 오류 해결 코드(Cannot invoke "" because "" is null) 
		if(borrowDate == null) {
			return;
		}
		
		Long borrowDateMs = borrowDate.getTime(); //대출일을 밀리초로 환산해줌
		Long periodMs = borrowPeriod * 24 * 60 * 60 * 1000L;
		/* new Date() : 현재 시간을 Date 객체로 생성
		 * new Date(a) : 1970년 1월 1일 0시 기준, a밀리초 만큼 흐른 날짜를 계산 */
		estimatedDate = new Date(borrowDateMs + periodMs);
	}
	

	public String getBorrowDateSrt() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		return format.format(borrowDate);	
	}
	public String getReturnDateSrt() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		return format.format(returnDate);
	}
	public String getEstimatedDateStr() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy년 MM월 dd일");
		return format.format(estimatedDate);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		borrowBrowsing other = (borrowBrowsing) obj;
		return Objects.equals(book, other.book);
	}

	@Override
	public int hashCode() {
		return Objects.hash(book);
	}

	
}

