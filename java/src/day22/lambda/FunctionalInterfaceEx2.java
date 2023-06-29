package day22.lambda;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaceEx2 {

	public static void main(String[] args) {
		//supplier 인터페이스
		Supplier<String> supplier = ()-> "Hi";
		System.out.println(supplier.get());
		
		//Function 인터페이스
		//=> 매개변수Student, 리턴타입String이 각각 존재
		Function<Student, String> function = std->std.getName();
		System.out.println(function.apply(new Student(1,1,1,"Hong")));
		
		//Operator 인터페이스
		//=> 매개변수와 리턴타입이 Student로 같음
		UnaryOperator<Student> operator = std->{
			std.setGrade(2);
			return std;
		};
		System.out.println(operator.apply(new Student(1,1,1,"Hong")));
		
		//Predicate 인터페이스
		//=> 리턴타입이 true, false : 시작하는 단어가 Hong이면 true(0)
		Predicate<Student> predicate = s->s.getName().indexOf("Hong") == 0;
		System.out.println(predicate.test(new Student(1,1,1,"Hong")));
	
	}

}
