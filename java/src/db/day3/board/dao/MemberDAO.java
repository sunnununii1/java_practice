package db.day3.board.dao;

import org.apache.ibatis.annotations.Param;

import db.day3.board.vo.MemberVO;

public interface MemberDAO {
	//Param은 객체가 1개든 2개든 익숙해지기 위해 그냥 써놓기 습관 들이기
	MemberVO selectMember(@Param("me_id")String me_id);
	
	void insertMember(@Param("member")MemberVO member);
	
	//매개변수에 @Param을 붙이고 안 붙이고의 차이. insertMember와 같은 기능의 메서드 만듦
	void insertMember2(MemberVO member);

	void deleteMember(@Param("me_id") String me_id);

	void updateBoardCount(@Param("me_id")String bo_me_id);
}
