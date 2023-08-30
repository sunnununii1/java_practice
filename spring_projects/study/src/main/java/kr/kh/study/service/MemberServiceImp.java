package kr.kh.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.study.dao.MemberDAO;
import kr.kh.study.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {
	
	
	@Autowired
	private MemberDAO memberDao;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean signup(MemberVO member) {
		if(member == null || 
			member.getMe_id() == null ||
			member.getMe_pw() == null ||
			member.getMe_email() == null) {
			return false;
		}
		//유효성 검사(선택)
		if(checkRegexMember(member)) {
			return false;
		}
		//아이디 중복체크
		
		//아이디로 회원정보 가져옴
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		if(dbMember != null) {
			return false;
		}
		
		//회원가입 진행
		String encPw = passwordEncoder.encode(member.getMe_pw()); //암호화
		member.setMe_pw(encPw); //member에 비번이 암호화되어 mysql에 넘어감
		memberDao.insertMember(member);
		return true;
	}

	private boolean checkRegexMember(MemberVO member) {
		//필요하면 구현
		return false;
	}
}
