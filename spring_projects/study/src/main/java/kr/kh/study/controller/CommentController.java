package kr.kh.study.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.kh.study.pagination.Criteria;
import kr.kh.study.pagination.PageMaker;
import kr.kh.study.service.CommentService;
import kr.kh.study.vo.CommentVO;

@RestController
public class CommentController {

	@Autowired
	CommentService commentService;
	
	@PostMapping("/comment/insert")
	public Map<String, Object> insert(@RequestBody CommentVO comment){
		Map<String, Object> map = new HashMap<String, Object>();
//		System.out.println(comment);
		boolean res = commentService.insertComment(comment);
		map.put("res", res);
		return map;
	}
	
	@PostMapping("/comment/list/{bo_num}")
	public Map<String, Object> list(@RequestBody Criteria cri, @PathVariable("bo_num")int bo_num){
		Map<String, Object> map = new HashMap<String, Object>();
		//댓글은 최대 3개까지만 보이게
		cri.setPerPageNum(3);
		List<CommentVO> list = commentService.getCommentList(bo_num, cri);
		
		//총 게시글 수 알려달라고 서비스에게 요청
		int totalCount = commentService.getTotalCount(bo_num);
		//페이지메이커 만들기
		PageMaker pm = new PageMaker(3, cri, bo_num);
		map.put("list", list);
		map.put("pm", pm);
		return map;
	}
}