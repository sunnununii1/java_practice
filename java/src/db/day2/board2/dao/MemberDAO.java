package db.day2.board2.dao;

import db.day2.board.vo.MemberVO;

public interface MemberDAO {

	MemberVO getMember(String id);

	void insertMember(String id, String pw);

	void deleteMember(String id);

}
