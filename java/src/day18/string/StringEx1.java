package day18.string;

public class StringEx1 {

	public static void main(String[] args) {
	/* 문자열 관련 메서드 */
	//indexOf : 기준 문자열에서 검색 문자/문자열을 왼쪽부터 검색, 처음으로 만나는 위치
	String str = "Hello World";
	
	//str에서 7번지부터 wo가 있는지 확인(orld에서 wo 확인하기)=>없음=>-1
	int index = str.indexOf("wo",7);
	System.out.println(str + "에서 7번지부터 " + "wo" + "가 있나요? " + index);
	
	index = str.indexOf("wo");
	System.out.println(str + "에서 0번지부터 " + "wo" + "가 있나요? " + index);

	index = str.indexOf("o");
	System.out.println(str + "에서 0번지부터 " + "o" + "가 있나요? " + index);
	
	//lastindexOf : 기준 문자열에서 검색 문자/문자열을 오른쪽부터 검색, 처음으로 만나는 위치
	index = str.lastIndexOf("o");
	System.out.println(str + "에서 0번지부터 " + "o" + "가 오른쪽으로 있나요? " + index);
	
	
	//indexOf와 contains의 차이 : 기존 문자열에서 검색문자/문자열이 있나 없나 알려줌
	boolean result = str.contains("o");
	System.out.println(str + "에서 0번지부터 " + "o" + "가 있나요? " + result);
	System.out.println(str + "의 길이는? " + str.length());
	
	
	/* replace : 특정 문자/문자열을 바꿀 때 사용. 모두의 문자/문자열 수정
	   replaceAll : 정규표현식의 유무 차이. 정규표현식에 맞는 모든 문자/문자열을 수정 */
	String str2 = str.replace(" ", " "); //공백을 콤마로
	System.out.println(str2);
	
	
	//substring : 부분 문자열 추출
	String str3 = str.substring(6);
	System.out.println(str + "에서 6번지부터 가져온 부분 문자열 : " + str3);

	
	//toLowerCase : 소문자로
	System.out.println(str + "의 소문자 : " + str.toLowerCase());
	//toUpperCase : 대문자로
	System.out.println(str + "의 대문자 : " + str.toUpperCase());
	
	
	//trim : 모든 공백 지워줌(단, 문자의 시작과 마지막에 한함. 문자 사이 공백은 X)
	String str4 = "\n\t\tabc\t\tdef\t\n";
	System.out.println(str4.trim());
	
	//split : 구분자를 구준으로 문자열 추출 후 순서대로 배열에 저장
	String str5 = "사과,배,포도";
	String fruits[] = str5.split(",");
	for(String fruit : fruits) {
		System.out.println(fruit);
	}
	}
}
