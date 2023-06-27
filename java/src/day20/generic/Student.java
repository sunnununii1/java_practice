package day20.generic;

			//<T> 안의 T는 여러가지가 올 수 있음(== <T,A,B,C..> )
public class Student<T> {

	int grade, classNum, num;
	String name;
	public T kor, math, eng;
}
