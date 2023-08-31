package kr.kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kh.spring.pagenation.Criteria;
import kr.kh.spring.pagenation.PageMaker;
import kr.kh.spring.service.BoardService;
import kr.kh.spring.util.Message;
import kr.kh.spring.vo.BoardVO;
import kr.kh.spring.vo.MemberVO;

@RequestMapping("/board")
@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	@GetMapping("/list")
	public String list(Model model, Criteria cri) {
		cri.setPerPageNum(2); //한 페이지에 2개씩 보여줌
//		System.out.println(cri);
		
		//현재 페이지에 맞는 게시글 가져오기
		List<BoardVO> list = boardService.getBoardList(cri);
		int totalCount = boardService.getTotalCount(cri);
		PageMaker pm = new PageMaker(3, cri, totalCount);
		
		model.addAttribute("pm", pm);
		model.addAttribute("list", list);
		return "/board/list";
	}
	
	@GetMapping("/insert")
	public String insert() {
		return "/board/insert";
	}
	
	@PostMapping("/insert")
	public String insertPost(BoardVO board, HttpSession session, Model model) {
//		System.out.println(board); //정상 출력확인
		MemberVO user = (MemberVO)session.getAttribute("user");
		Message msg;
		if(boardService.insertBoard(board, user)) {
			msg = new Message("/board/list", "게시글을 등록했습니다.");
		}else {
			msg = new Message("/board/list", "게시글을 등록하지 못했습니다.");
		}
		System.out.println(board);
		model.addAttribute("msg",msg);
		return "message";
	}
	
	@GetMapping("/detail")
	public String detail(Model model, Integer bo_num, Criteria cri) {
		boardService.updateViews(bo_num);//서비스에게 조회수 늘려달라고 요청
		
		BoardVO board = boardService.getBoard(bo_num);
		model.addAttribute("board",board);
		model.addAttribute("cri",cri);
		return "/board/detail";
	}
}
