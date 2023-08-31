package kr.kh.spring.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.vo.MemberVO;

@Service //@Service가 없으면 @Atuowired 인식 불가(세트)
public class MemberServiceImp implements MemberService{

	//@Atuowired로 dy와 다르게 생성자(try-catch문) 생략가능해짐
	@Autowired 
	private MemberDAO memberDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean signup(MemberVO member) {
		if(member == null) {
			return false;
		}
		
		//아이디 중복확인 -> Dao에게 회원정보(id) 요청
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		//가입하려는 아이디가 이미 가입된 경우
		if(dbMember != null) {
			return false;
		}
		//아이디, 비번 null체크 + 유효성 검사
		String idRegex = "^[a-zA-Z][a-zA-Z0-9]{5,14}$"; //영문으로 시작, 5~14자
		String pwRegex = "^[a-zA-Z0-9!@#$%]{6,15}$"; //영문,숫자,!@#$%에 6~15자
		//아이디가 유효성과 맞지 않으면
		if(!Pattern.matches(idRegex, member.getMe_id())) {
			return false;
		}
		//비번이 유효성과 맞지 않으면
		if(!Pattern.matches(pwRegex, member.getMe_pw())) {
			return false;
		}
		//비번 암호화
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw); //암호화된 비번을 다시 지정
		//회원가입 진행
		return memberDao.insertMember(member);
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null) {
			return null;
		}
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		
		//아이디와 일치하는 계정이 없으면
		if(dbMember == null) {
			return null;
		}
		//비번 확인(암호화 안된 문자열, 암호화된 문자열)
		if(passwordEncoder.matches(member.getMe_pw(), dbMember.getMe_pw())){
			return dbMember;
		}
		return null;
	}


}