package day20.homework.vo;

import java.util.ArrayList;

/* 여긴 단어장 클래스
 * - 단어들의 모임
 * => Word들의 모임
 */

public class VocabularyNote {
	//멤버변수
	//단어들
	private ArrayList<Word> wordList; // 단어들 의미
	
	//생성자
	public VocabularyNote() {
		wordList = new ArrayList<>(); // 복사장
	}
	
	
	public VocabularyNote(ArrayList<Word> wordList) {
		//기존 단어장의 크기와 10을 비교해서 큰 수로 단어장 크기로 선택
		this.wordList = (ArrayList<Word>) wordList.clone();
	}

	//메서드
	/** 단어들을 출력하는 메서드(단어 전부가 아닌, 저장된 갯수만큼)
	 * 매개변수 : 없음
	 * 리턴타입 : void
	 * 메서드명 : print
	 */
	public void print() {
		System.out.println("===================");
		for(Word tmp : wordList) {
			tmp.print();
			System.out.println("===================");
		}
	}
	/** 단어가 주어지면 단어장에 추가하는 메서드(단어 객체를 넘겨주는 경우)
	 * 매개변수 : 단어(단어 객체) => Word word
	 * 리턴타입 : void 
	 * 메서드명 : insert
	 */
	public void insert(Word word) {
			//단어장에 단어가 다 찼다는 의미(=>추가 못함)
		if(wordCount == wordList.length) {
			System.out.println("Vocabulary Note is full!");
			return;
		}
		//깊은 복사 위해 Word의 복사 생성자를 이용하여 새 단어를 생성 후 추가
		wordList[wordCount++] = new Word(word);
	}
		
	/** 단어와 뜻이 주어지고 없는 단어이면 새로 단어를 추가하고 1을 리턴,
	 *  있는 단어이면 뜻만 새로 추가하는 -1을 리턴하고
	 *  추가가 실패하면 0을 리턴하는 메서드 (단어와 뜻을 넘겨주는 경우)
	 * 매개변수 : 단어와 뜻 => String title
	 * 리턴타입 : -1(뜻 추가), 0(추가 실패), 1(단어 추가) => int 
	 * 메서드명 : insert
	 */	
	public int insert(String title, String meaning) {
		  //단어장에 단어가 다 찼다는 의미(=>추가 못함)
		if(wordCount == wordList.length) {
			//System.out.println("Vocabulary Note is full!");
			return 0;
		}
		int index = indexOf(title);
		//없는 단어이면 새 단어로 추가
		if(index == -1) {
			//단어와 뜻을 이용해 단어 객체를 생성한 후 단어장에 추가
			wordList[wordCount++] = new Word(title, meaning);
			return 1;
		}
		//있는 단어이면 뜻을 추가
		wordList[index].addMeaning(meaning);
		return -1;
	}	
	

	/** 단어가 주어지면 단어장에서 삭제하고 삭제 여부를 알려주는 메서드
	 * 매개변수 : 삭제할 단어 => String title
	 * 리턴타입 : 삭제 여부 => boolean
	 * 메서드명 : delete
	 */
	public boolean delete(String title) {
		//먼저 단어가 어디있는지 찾아야 함
		int index = indexOf(title);
		
		//단어가 단어장에 없으면 메세지 출력 후 종료
		if(index == -1) {
			//System.out.println("No words found");
			return false;
		}
		//찾은 위치부터 한 칸씩 밀어줌
		for(int i=index; i<wordCount-1; i++) {
			wordList[i] = wordList[i+1];
		}
		
		//단어의 개수를 하나 줄여줌
		wordCount--;
		
		//마지막 단어를 비워줌(null)
		wordList[wordCount] = null;
		return true;
	}
	
	/** 단어가 주어지면 단어가 있는 위치를 알려주는 메서드
	 * 만약 단어가 없으면, -1로 함(보통 0번지부터 시작하므로 음수==찾을 수 없는 번지)
	 * 매개변수 : 단어 => String title
	 * 리턴타입 : 위치 => 번지 => 정수 => int
	 * 메서드명 : intdexOf(주소나 번지 찾는 단어)
	 */
	public int indexOf(String title) {
		//단어장에 등록된 단어들을 조회함
		for(int i=0; i<wordCount; i++) {
			//단어가 같으면 i번지를 리턴(단, 문자열은 == 금지 > .equals()로 씀)
			if(wordList[i].getTitle().equals(title)) {
				return i;
			}
		}
		//여기까지 오면 일치하는 단어가 없는 경우라서 -1로 리턴
		return -1;
	}

	/**
	 * 단어가 주어지면 단어장에 해당 단어를 출력하고, 단어가 있는지 없는지를 알려주는 메서드
	 * 매개변수 : 단어 => String title
	 * 리턴타입 : 단어가 있는지 없는지 => boolean
	 * 메서드명 : search
	 */
	public boolean search(String title) {
		int index = indexOf(title);
		
			if(index == -1) {
				System.out.println("No words found");
				return false;
			}
			
			wordList[index].print();
			return true;
		}
	
	/** 단어와 수정할 뜻의 번호와 수정할 뜻이 주어지면 단어의 뜻을 수정하고,
	 * 수정 여부를 알려주는 메서드
	 * 매개변수 : 뜻을 수정할 단어, 수정할 뜻의 번호, 수정할 뜻
	 * 		  =>String title, int meaninIndex, String meaning
	 * 리턴타입 : 수정 여부 => boolean
	 * 메서드명 : updateMeaning
	 */
	public boolean updateMeaning(String title, int meaningIndex, String meaning) {
		//해당 단어 위치 찾기
		int index = indexOf(title);
		
		//단어가 없으면, 없다고 안내 메세지
		if(index == -1) {
			System.out.println("No words found");
			return false;
		}
		if(!wordList[index].updateMeaning(meaningIndex, meaning)) {
			//System.out.println("Wrong number");
			return false;
		}
		return true;
	}
	
	
	/** 단어와 수정할 단어의 뜻이 주어지면 단어를 수정하고, 수정 여부를 알려주는 메서드
	 * 매개변수 : 단어와 수정할 단어 => String title, String updateTitle
	 * 리턴타입 : 수정 여부 => boolean
	 * 메서드명 : updateTitle
	 */
	public boolean updateTitle(String title, String updateTitle) {
		//해당 단어 위치 찾기
		int index = indexOf(title);
		
		if(index == -1) {
			//System.out.println("No words found");
			return false;
		}
		
		wordList[index].setTitle(updateTitle);
		return true;
	}

	/** 단어와 삭제할 뜻의 번호가 주어지면 뜻을 삭제하고, 삭제 여부를 알려주는 메소드
	 * 매개변수 : 단어와 뜻 번호 => String title, int num
	 * 리턴타입 : 삭제 여부 => boolean
	 * 메소드명 : deleteMeaning
	 */
	public boolean deleteMeaning(String title, int num) {
		int index = indexOf(title); //단어의 위치
		//단어가 없으면 삭제 불가
		if(index == -1) {
			return false;
		}
		Word tmp = wordList[index];
		if(tmp.removeMeaning(num)) {
			return true;
		}
		return false;
	}
}

