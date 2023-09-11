package kr.kh.spring.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

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
	public String insert(Model model, Integer bo_ori_num, HttpSession session) {
		//로그인한 회원이 작성가능한 게시판 타입을 가져오기 필요
		//로그인한 회원 정보 가져오기
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		List<BoardTypeVO> typeList = boardService.getBoardTypeList(user);
		
		
		return "/board/insert";
	}
	
	@PostMapping("/insert")
	public String insertPost(BoardVO board, HttpSession session, Model model, MultipartFile[] files) {
//		System.out.println(board); //정상 출력확인
		MemberVO user = (MemberVO)session.getAttribute("user");
		Message msg;
		if(boardService.insertBoard(board, user, files)) {
			msg = new Message("/board/list", "게시글을 등록했습니다.");
		}else {
			msg = new Message("/board/list", "게시글을 등록하지 못했습니다.");
		}
//		System.out.println(board);
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
	
	//게시글 수정
	@GetMapping("/update")
	public String update(Model model, Integer bo_num, HttpSession session) {
		BoardVO board = boardService.getBoard(bo_num);
		MemberVO user = (MemberVO)session.getAttribute("user");
		//로그인 안했거나, 게시글이 없거나, 작성자가 아니면 수정페이지 접근 막기
		if(user == null || board == null || !user.getMe_id().equals(board.getBo_me_id())) {
			Message msg = new Message("/board/list", "잘못된 접근입니다.");
			model.addAttribute("msg", msg);
			return "message";
		}
		model.addAttribute("board", board);
		return "/board/update";
	}
	
	@PostMapping("/update")
	public String updatePost(Model model, BoardVO board, 
			MultipartFile[] files, Integer[] delFiles, HttpSession session) {
		Message msg;
		MemberVO user = (MemberVO)session.getAttribute("user");
		if(boardService.updateBoard(board, files, delFiles,user)) {
			msg = new Message("/board/detail?bo_num="+board.getBo_num(), "게시글을 수정했습니다.");
		}else {
			msg = new Message("/board/update?bo_num="+board.getBo_num(), "게시글을 수정하지 못했습니다."); 
		}
		model.addAttribute("msg", msg);
		return "message";
	}
	
	//게시글 삭제
	@GetMapping("/delete")
	public String delete(Model model, HttpSession session, Integer bo_num) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		Message msg;
		if(boardService.deleteBoard(bo_num, user)) {
			msg = new Message("/board/list","게시글을 삭제했습니다.");
		}else {
			msg = new Message("/board/list", "잘못된 접근입니다.");
		}
		model.addAttribute("msg", msg);
		return "message";
	}
}
