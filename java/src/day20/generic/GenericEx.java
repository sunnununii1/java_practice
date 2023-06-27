package day20.generic;

import java.util.ArrayList;
import java.util.Scanner;

public class GenericEx {

	public static void main(String[] args) {
		Student<Integer> std = new Student<Integer>();
		std.kor = 10; //이때 kor은 정수만 가능(10.0은 오류)
		Student<Double> std2 = new Student<Double>();
		std2.kor = 10.0; //kor 실수 가능
		/*Student<Scanner> std3 = new Student<>();
		 std3.kor = 10;*/ //위 두개와 달리 상속과 전혀 관련 없어서 오류
		
		print(std2);
		GenericEx.<Double>print(std2);
		GenericEx.print(std2); //더블 생략가능. std2가 더블로 되어있어서 print T 추정 가능한 경우
	}
	
	//학생 정보를 출력하는 메서드(제너릭 메서드로)
	public static <T extends Number> void print(Student<T> std) {
		System.out.println(std.grade);
		System.out.println(std.classNum);
		System.out.println(std.num);
		System.out.println(std.name);
		System.out.println(std.kor);
	}

}
