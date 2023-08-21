package db.day3.board.service;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import db.day3.board.dao.MemberDAO;
import db.day3.board.vo.MemberVO;

public class MemberServiceImp implements MemberService{
	
	private MemberDAO memberDao;
	private final String MYBAITS_CONFIG_PATH = "db/day3/board/config/mybatis-config.xml";
	
	//런타임 인셉션이 아닌 경우엔 반드시 try-catch문으로 예외처리 해야함
	public MemberServiceImp() {
		try {
			InputStream is = Resources.getResourceAsStream(MYBAITS_CONFIG_PATH);
			//XML에서 SqlSessionFactory 빌드하기 + SqlSesson만들기는 마이바티스 홈페이지에 있음
			SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(is);
			SqlSession session = sf.openSession(true); // true의 역할: 쿼리(insert,update,delete) 실행 후 자동 commit해줌
			memberDao = session.getMapper(MemberDAO.class);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

	@Override
	public boolean signup(MemberVO member) {
		if(member == null || member.getMe_id() == null) {
			return false;
		}
		//아이디 중복체크 => 아이디와 일치하는 회원정보 조회,가져옴
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		
		//아이디가 중복없으면 가입 진행 => 일치하는 회원정보 없으면
		if(dbMember == null) {
			memberDao.insertMember2(member);
			return true;
		}
		return false;
	}

	@Override
	public boolean withdraw(MemberVO member) {
		//()안 순서 바뀌면 동작 안될 수 있음
		if(member == null || member.getMe_id() == null) {
			return false;
		}
		//아이디 이용하여 회원정보 가져오기
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		
		//가져운 회원정보의 비번과 입력받은 비번이 같으면 삭제, 다르면 삭제안함
		if(dbMember != null && dbMember.getMe_pw().equals(member.getMe_pw())) {
			memberDao.deleteMember(member.getMe_id());
			return true;
		}
		return false;
	}

}
