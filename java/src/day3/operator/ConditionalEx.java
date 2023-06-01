package day3.operator;

public class ConditionalEx {

	public static void main(String[] args) {
		// 나이가 20살 이상은 adult, 아니면 minor인 출력코드를 작성하라
		int age = 21;
		String str;
		
		str = age >= 20 ? "adult" : "minor";
		System.out.println(age + "years old is a" + str);

	}

}
