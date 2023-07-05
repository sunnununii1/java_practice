package day26.book.controller;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import day26.book.vo.Book;
import day26.book.vo.borrowBrowsing;

public class BookManager implements Program {

	private List<Book> list = new ArrayList<>(); //도서 리스트
	private List<borrowBrowsing> borrowList = new ArrayList<>(); //대출 열람 리스트
	
	Scanner sc = new Scanner(System.in);
	public static final int EXIT = 4;
	
	public void run() {
		int menu;
		String bookName = "book_day26.txt";
		loadBook(bookName);
		do {
			System.out.println("===========");
			printMenu();
			menu = sc.nextInt();
			runMenu(menu);
			System.out.println("===========");
			
		}while(menu != EXIT);
		saveBook(bookName);
		sc.close();
	}
	
	private void saveBook(String fileName) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
				ObjectOutputStream oos = new ObjectOutputStream(fos)){
				for(Book tmp : list) {
					oos.writeObject(tmp);
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}


	private void loadBook(String fileName) {
		try(ObjectInputStream ois 
				= new ObjectInputStream(new FileInputStream(fileName))){
					while(true) {
						Book tmp = (Book)ois.readObject();
						list.add(tmp);
					}
		} catch(FileNotFoundException e) {
			System.out.println("불러올 파일이 없음");
		} catch(EOFException e) {
			System.out.println("불러오기 완료");
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			System.out.println("Book 클래스를 찾을 수 없음");
		}
		System.out.println(list);
	}

	public void printMenu() {
		System.out.println("1. 도서 등록");
		System.out.println("2. 도서 대출");
		System.out.println("3. 도서 반납");
		System.out.println("4. 종료");
		System.out.print("메뉴 선택 : ");
	}

	public void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertBook();
			break;
		case 2:
			borrowBook();
			break;
		case 3:
			returnBook();
			break;
		case 4:
			System.out.println("종료합니다.");
			break;
		default:
			System.out.println("잘못된 번호");
		}
	}

	private void insertBook() {
		//책 제목, 저자, isbn(고유도서번호), 도서번호 입력
		System.out.println("책 제목 : ");
		String name = sc.next();
		System.out.println("저자 이름 : ");
		String writer = sc.next();
		System.out.println("도서 번호 : ");
		String num = sc.next();
		System.out.println("ISBN : ");
		String isbn = sc.next();
		
		//책 객체 생성 후, 리스트에 추가
		Book book = new Book(name, writer, isbn, num);
		list.add(book);
		System.out.println(list);
	}

	private void borrowBook() {
		//대출 가능한 도서들을 조회(필터 작업 필요)
		//Stream<Book> stream = list.stream(); //람다식 이용에 필요!
		
		list
			.stream() //boolean이라서 get.. X is.. O
			.filter(b->!b.isBorrow()) //대출 중이 아닌 책 찾기(=>!붙임)
			.forEach(b->{		 	  //추출한 도서 출력
				System.out.println("===========");
				System.out.println(b);
				System.out.println("===========");
			});
		/*for(Book tmp : list) {
			if(!tmp.isBorrow()) {
				System.out.println("===========");
				System.out.println(b);
				System.out.println("===========");
			}
		}*/
		
		//도서 번호 입력받음
		System.out.print("대출할 도서 번호 : ");
		String num  = sc.next();
		
		//대출 신청
		//도서 번호가 올바른지 확인 => 번호에 맞는 도서찾기(있으면 올바름, 없으면 대출 중인지 확인)
		boolean possible 
			= list
				.stream() //대출되지 않았고, 검색 도서와 같은 번호인 책이 0보다 크면
				.filter(b->!b.isBorrow() && b.getNum().equals(num))
				.count() > 0;
		
				
		//올바르지 않으면(없는 도서번호인 경우,대출 중인 도서인 경우) => 대출 불가 출력
		if(!possible) {
			System.out.println("대출 불가");
			return;
		}	
		//올바르면 대출 진행
		//도서 객체(도서, 대출일, 기간) 생성
		int index = list.indexOf(new Book(num, null, null, null));
		Date borrowDate = new Date();
		borrowBrowsing bb 
			= new borrowBrowsing(list.get(index), borrowDate, 14);
		//대출 열람 출력
		borrowList.add(bb);
		list.get(index).borrowBook(); //도서에 대출했다고 수정
		//대출일 출력
		System.out.println("대출일 : " + bb.getBorrowDateSrt());
		//반납예정일 출력
		System.out.println("반납 예정일 : " + bb.getreturnDateSrt());
	}

	private void returnBook() {
		//반납할 책 이름 입력
		System.out.print("반납할 도서 번호 : ");
		String num = sc.next();
		
		//반납 신청
		//도서 번호 올바른지 확인(대출 중이고 검색 도서 개수가 0이면 OK)
		boolean possible =
				list
				.stream()
				.filter(b->b.isBorrow() && b.getNum().equals(num))
				.count() == 0;
		//올바르지 않으면 반납 불가 출력
		if(!possible) {
			System.out.println("반납 불가, 대출 중이 아닙니다.");
		}
		int index = list.indexOf(new Book(num, null, null, null));
		Date returnDate = new Date();
		
		borrowBrowsing bb 
		= new borrowBrowsing(list.get(index), returnDate, 14);
		
		borrowList.remove(bb); //대출 리스트에서 제거
		
		//반납 완료 메세지 출력
		System.out.println("반납 완료되었습니다.");
		}
	
}
