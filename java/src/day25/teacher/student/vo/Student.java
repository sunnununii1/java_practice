package day25.teacher.student.vo;

import java.io.Serializable;

public class Student implements Serializable {
	private String name,classNumber,major;
	
	public Student(String name, String classNumber, String major) {
		this.name = name;
		this.classNumber = classNumber;
		this.major = major;
	}
	
	@Override
	public String toString() {
		return "학번 : " + classNumber + "\n이름 : " + name + "\n전공 : " + major;
	}

}