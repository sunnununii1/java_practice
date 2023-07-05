package day26.book.vo;

import java.io.Serializable;
import java.util.Objects;

import lombok.Data;

@Data
public class Book implements Serializable {

	private static final long serialVersionUID = 466300774616839952L;
	/* 도서 번호 : 도서관에서 저장
	 * 도서명, 저자, ISBN */
	private String name, writer, isbn, num;
	private boolean borrow; //도서 대출 여부
	
	public String toString() {
		return "도서 번호 : " + num +
				"\n도서 제목 : " + name +
				"\n저자 : " + writer +
				"\nISBN : " + isbn + "\n";
	}
	public Book(String num, String name, String writer, String isbn) {
		this.name = name;
		this.writer = writer;
		this.isbn = isbn;
		this.num = num;
	}
	public void borrowBook() {
		this.borrow = true; //setBorrow(true);
	}
	public void returnBook() {
		this.borrow = false; //setBorrow(false);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(num, other.num);
	}
	@Override
	public int hashCode() {
		return Objects.hash(num);
	}
	
}
