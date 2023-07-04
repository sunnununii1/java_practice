package day25.student.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Student {
	String name;
	String classNumber;
	String major;
	
	
	@Override
	public String toString() {
		return "학번 : " + classNumber + "\n이름 : " + name + "\n전공 : " + major;
	}
}
