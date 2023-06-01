package day3.operator;

public class ComparisonEx {

	public static void main(String[] args) {

		
		System.out.println("1 > 2 : " + (1 > 2));
		System.out.println("1 < 2 : " + (1 < 2));
		System.out.println("1 >= 2 : " + (1 >= 2));
		System.out.println("1 <= 2 : " + (1 <= 2));
		System.out.println("1 == 2 : " + (1 == 2));
		System.out.println("1 != 2 : " + (1 != 2));
		
		String str1 = "abc";
		String str2 = "abc";
		String str3 = new String("abc");
		System.out.println("str1 == str2 : " + (str1 == str2));
		System.out.println("str1 == str3 : " + (str1 == str3));
		System.out.println("str2 == str3 : " + (str2 == str3));
		/* 리터럴 문자열 str1,str2은 abc를 저장하고 있다. ( == 비교 가능)
		 * 리터럴이 아닌 값 str3은 문자열이 아니다. ( == 비교 불가능)
		 * 다만, 일반적으로 문자열 변수가 있을시 그 변수에 리터럴이 들어있는지 여부는 알 수 없음
		 * >> 그래서 문자열을 ==, != 비교하지 않는다. 로 기억하기
		 * */
		
		System.out.println("str1.equals(str2) : " + str1.equals(str2));
		System.out.println("str1.equals(str3) : " + str1.equals(str3));
		System.out.println("str2.equals(str3) : " + str2.equals(str3));
		
		/* 문자열을 포함한 참조변수는 주로 equals를 이용하여 같다 다르다 판별
		 * 참조변수가 ==, != 를 쓰는 경우는 아래 null 과의 비교 하나 뿐이다.
		 * */
		System.out.println(str1 == null);
		
	}

}
