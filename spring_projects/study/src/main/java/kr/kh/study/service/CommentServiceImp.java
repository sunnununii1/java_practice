package kr.kh.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.study.dao.BoardDAO;
import kr.kh.study.dao.CommentDAO;
import kr.kh.study.pagination.Criteria;
import kr.kh.study.vo.CommentVO;
import kr.kh.study.vo.MemberVO;

@Service
public class CommentServiceImp implements CommentService {

	@Autowired
	CommentDAO commentDao;
	
	@Autowired
	BoardDAO boardDao;
	
	@Override
	public boolean insertComment(CommentVO comment) {
		if(comment == null || comment.getCo_me_id() == null || comment.getCo_contents() == null) {
			return false;
		}
		
		boolean res = commentDao.insertComment(comment);
		
		if(!res) {
			return false;
		}
		//게시글 번호 주면서 해당 게시글의 댓글을 업데이트 해달라 요청
		boardDao.updateBoardComment(comment.getCo_bo_num());
		return res;
	}

	@Override
	public List<CommentVO> getCommentList(int bo_num, Criteria cri) {
		if(cri == null) {
			cri = new Criteria();
		}
		return commentDao.selectCommentList(bo_num, cri);
	}

	@Override
	public int getTotalCount(int bo_num) {
		return commentDao.selectCommentCount(bo_num);
	}

	//댓글 삭제
	@Override
	public boolean deleteComment(CommentVO comment, MemberVO user) {
		if(user == null || user.getMe_id() == null) {
			return false;
		}
		if(comment == null || comment.getCo_num() == 0) {
			return false;
		}
		CommentVO dbComment = commentDao.selectComment(comment.getCo_num());
		if(dbComment == null || !dbComment.getCo_me_id().equals(user.getMe_id())) {
			return false;
		}
		boolean res = commentDao.deleteComment(comment.getCo_num());
		boardDao.updateBoardComment(dbComment.getCo_bo_num());
		return true;
	}

	@Override
	public boolean updateComment(CommentVO comment, MemberVO user) {
		if(user == null || user.getMe_id() == null) {
			return false;
		}
		if(comment == null || 
				comment.getCo_num() == 0 ||
				comment.getCo_contents() == null ||
				comment.getCo_contents().trim().length() == 0) {
			return false;
		}
		//댓글존재 확인 후 작성자 확인
		CommentVO dbComment = commentDao.selectComment(comment.getCo_num());
		if(dbComment == null || !dbComment.getCo_me_id().equals(user.getMe_id())) {
			return false;
		}
		return commentDao.updateComment(comment);
	}

}
