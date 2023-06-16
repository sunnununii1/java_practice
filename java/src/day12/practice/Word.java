package day12.practice;

import lombok.Data;

/* 한 단어를 관리하는 클래스 만들기
 * - 단어
 * - 뜻 여러개
 */

@Data //getter, setter, toSrting, equals를 자동추가 해줌

public class Word {
	//1. 멤버 변수
	private String title;
	private String meaning[];
	private int meaningCount; //뜻이 저장된 개수
	
	//2. 생성자
	// 단어랑 뜻이 같이 주어졌을 때 생성자
	public Word(String title, String meaning) {
		this.title = title;
		this.meaning = new String[5]; // 기본 5개
		this.meaning[0] = meaning;
		meaningCount++;
	}
	//생성자 오버로딩으로 타이틀만 주어질 경우 생성자 생성
	public Word(String title) {
		this.title = title;
		this.meaning = new String[5]; // 뜻을 넣진 않아도 배열은 만들어두는게 좋음
	}
	
	//VocabularyNote 클래스 위한 복사 생성자 생성
	public Word(Word w) {
		this.title = w.title;
		this.meaning = new String[5];
		for(int i=0; i<w.meaningCount; i++) {
			meaning[i] = w.meaning[i];
		}
		meaningCount = w.meaningCount;
	}
	
	//메서드
	/** 단어와 뜻을 출력하는 메서드
	 * 매개변수 : 남 정보가 아니라 내 정보 출력하는 거라 없음
	 * 리턴타입 : 출력이라서 없음 => void
	 * 메서드명 : print
	 */
	public void print() {
		System.out.println("word : " + title);
		System.out.println("meaning : ");
		for(int i = 0; i<meaningCount; i++) {
			System.out.println(i + 1 + ". " + meaning[i]);
		}
	}
	/** 뜻을 추가하는 메서드
	 * 매개변수 : 추가될 뜻 => String meaning
	 * 리턴타입 : void
	 * 메서드명 : addMeaning
	 */
	public void addMeaning(String meaning) {
		//뜻이 다 찼으면 다 찼고 출력 후 종료
		if(meaningCount == this.meaning.length) {
			System.out.println("It's all filled.");
			return;
		}
		this.meaning[meaningCount] = meaning;
		meaningCount++;
	}
	/** 뜻을 제거하는 메서드
	 * 매개변수 : 제거할 뜻의 번호 => int num
	 * 리턴타입 : void
	 * 메서드명 : removeMeaning
	 */
	public void removeMeaning(int num) {
		if(num > meaningCount || num < 1) {
			System.out.println("I can't work.");
			return;
		}
	//num-1번지부터 하나씩 당겨와서 채워줘야(덮어쓰기해야)함
		for(int i = num-1; i < meaningCount-1; i++) {
			meaning[i] = meaning[i+1];
		}
		/*마지막에 쓸모없는 데이터 지움
		meaning[meamingCount-1] = null; */
		//제거됐으면 뜻 개수를 하나 줄임
		meaningCount--;
	}
	
	/** 수정할 뜻의 번호와 수정할 뜻이 주어지면 뜻을 수정하고 수정 여부를 알려주는 메서드
	 * 매개변수 : 수정할 뜻의 번호, 수정할 뜻 => int meaninNum, String meaning 
	 * 리턴타입 : 수정 여부 => boolean
	 * 메서드명 : updateMeaning
	 * @param meaninIndex
	 * @param meaning2
	 * @return
	 */
	public boolean updateMeaning(int meaningNum, String meaning) {
		//수정할 뜻의 번호가 잘못된 경우
		if(meaningNum > meaningCount || meaningNum < 0) {
			return false;
		}
		//meaningNum은 1부터이고 번지는 0부터라서 -1을 한다.
		this.meaning[meaningNum-1] = meaning;
		return false;
	}
	
	//getter
	public String getTitle() {
		return title;
	}
	
	//setter
	public void setTitle(String title) {
		this.title = title;
	}
	
}
