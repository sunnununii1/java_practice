package day22.practice.phone.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

//전화번호 리스트 관리 클래스
public class PhoneBook {
	
	//전화번호 리스트
	private List<PhoneNumber> list = new ArrayList<>();
	
	//기능들
	//전화번호 추가 (번호 추가 실패할 수 있어서 boolean)
	public boolean insertPhone(String name, String number) { //전화번호 객체 생성
		PhoneNumber pn = new PhoneNumber(name, number);
		//번호가 비어있으면==번호 패턴이 안맞으면 저장 X
		if(pn.getNumber().length() == 0) { 
		return false;
		}
		list.add(pn); //패턴에 맞으면 전화번호부에 추가
		return true;
	}
	
	//전화번호 수정 : 이름
	public boolean updateName(String name, String updateName) {
		//name과 일치하는 전화번호 찾아야함
		//전화번호부에 수정할 이름에 해당하는 전화번호 어디있는지 확인
		int index = list.indexOf(new PhoneNumber(name,""));
		//없으면 수정x => 메서드 종료
		if(index == -1) {
			return false;
		}
		//찾은 전화번호의 이름 수정
		//전화번호부에서 이름과 일치하는 전화번호 가져와서 이름 수정
		/*PhoneNumber pn = list.get(index);
		pn.setName(updateName);*/ //풀어쓰기
		list.get(index).setName(updateName);
		/* 기본 자료형은 =을 이용하면 값을 복사. 한쪽의 값이 바뀌어도 다른쪽은 안바뀌지만
		 * int num1 = 1;	//num1 = 1
		 * int num2 = num1;	//num1 = 1, num2 = 1
		 * num2 = 10;		//num1 = 1, num2 = 10
		 * 참조변수는 =을 이용시 주소값을 복사해서 한쪽 값 바뀔시 다른쪽도 바뀜!
		 * PhoneNumber pn1 = new PhoneNumber("a", "010-1234-4567"); //pn1 = 0x1000
		 * PhoneNumber pn2 = pn1;									//pn1 = 0x1000, pn2 = 0x1000
		 * pn2.setName("Lim");*/									//pn2 = pn1(0x1000번지의 객체 name을 Lim으로 수정)
		return true;
	}
	
	//전화번호 수정 : 번호
	public boolean updateNumber(String name, String number) {
		//name과 일치하는 전화번호부 찾기
		int index = list.indexOf(new PhoneNumber(name, number));
		
		//없으면 수정 실패
		if(index == -1) {
			return false;
		}
		//private checkNumber 일때
		//있으면 name, number 이용해서 전화번호 객체 만듬(number의 전화번호 패턴이 맞는지 확인 위함)
		//=>패턴이 맞으면 전화번호 객체 생성시 전화번호 있고, 맞지 않으면 빈문자열 있음
		//=>하지만 public static checkNumber 이면 : 폰넘버 클래스에서 이용, 객체 생성 따로 안해도 됨! 
		if(!PhoneNumber.checkNumber(number)) {
		return false;
		}
		list.get(index).setNumber(number);
		return true;
	}	
	
	//전화번호 수정 : 이름, 번호
	public boolean update(String name, String updateName, String number) {
		PhoneNumber pn = new PhoneNumber(name, number);
		
		//name 이용해 전화번호부 검색
		int index = list.indexOf(new PhoneNumber(name, number));
		//없으면 수정 실패
		if(index == -1) {
			return false;
		}
		
		//number가 전화번호 패턴에 안맞으면 실패
		if(!PhoneNumber.checkNumber(number)) {
			return false;
		}
		//일치한다면 기존 전화번호 삭제
		list.remove(index);
		//updateName과 number를 이용해 전화번호 객체를 생성 후 추가
		pn.setName(updateName);
		list.add(pn);
		return true;
	}
	
	//전화번호 삭제
	public boolean delete(String name) {
		//name으로 PhoneNumber 객체 생성 후 삭제요청 (list.remove가 알아서 없으면 false 요청해줌)
		return list.remove(new PhoneNumber(name, ""));
	}
	
	//전화번호 출력(람다식 Predicate 응용)
	public void print(Predicate<PhoneNumber> p) {
		for(PhoneNumber pn : list) {
			if(p.test(pn)){
				System.out.println(pn);
			}
		}
	}	
}
