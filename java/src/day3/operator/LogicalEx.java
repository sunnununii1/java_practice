package day3.operator;

public class LogicalEx {

	public static void main(String[] args) {
		int score = 95;
		// 성적(score)이 80점 이상, 성적이 90점 미만인가?
		// =score가 80보다 크거나 같고, score가 90보다 작다
		// =score가 80보다 크거나 같다 && score가 90보다 작다
		// score >= 80 && score < 90
		System.out.println(score + "점은 B학점인가?" + (score >= 80 && score < 90));

		int age = 21;
		// 20세 이상이면 성인
		boolean isAdult = age >= 20;
		// age살은 미성년자인가?
		System.out.println(age + "살은 미성년자인가?" + !isAdult); // !은 아니다의 뜻
		
		// 민증은 있고, 면허증은 없음
		boolean hasidCard = true;
		boolean hasDriverCard = false;
		// 민증이나 면허증이 있으면 볼 수 있다
		System.out.println("토익시험을 볼 수 있는가?" + (hasidCard || hasDriverCard));
		
	
	}

}
