package kr.kh.study.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import kr.kh.study.pagination.Criteria;
import kr.kh.study.pagination.PageMaker;
import kr.kh.study.service.BoardService;
import kr.kh.study.vo.BoardVO;
import kr.kh.study.vo.FileVO;
import kr.kh.study.vo.MemberVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/list")
	public String boardList(Model model, Criteria cri) {
		//한 페이지에 컨텐츠 2개로 설정
		cri.setPerPageNum(2);
		//보드서비스에게 게시글 리스트 가져오라고 시킴+현재 페이지 정보까지
		List<BoardVO> list = boardService.getBoardList(cri);
		
		int totalCount = boardService.getBoardTotalCount();
		PageMaker pm = new PageMaker(3, cri, totalCount);
		
		//그 내용을 화면에 전송
		model.addAttribute("list",list);
		model.addAttribute("pm", pm);
		return "/board/list";
	}
	
	//게시글 상세페이지 메서드 + 첨부파일 추가
	@GetMapping("/board/detail")
	public String boardDetail(Model model, Integer bo_num) { //int<Integer 안전
		//게시글 가져오기 전, 조회수 1씩 증가하도록 요청
		boardService.updateViews(bo_num);
		//서비스에게 게시글번호 주며 가져오라 요청
		BoardVO board = boardService.getBoard(bo_num); //게시글을
		List<FileVO> fileList = boardService.getFileList(bo_num); //첨부파일 리스트를
		
		//가져온 글들을 화면에 전송
		model.addAttribute("board", board);
		model.addAttribute("fileList", fileList);
		return "/board/detail";
	}
	
	@GetMapping("/board/insert")
	public String boardInsert() {
		return "/board/insert";
	}
	
	//게시글 등록 + 첨부파일 업로드 메서드
	@PostMapping("/board/insert")
	public String boardInsertPost(Model model, BoardVO board, HttpSession session, MultipartFile[] files) {
//		System.out.println(board); //정상적으로 넘어오는지 확인용
		MemberVO user = (MemberVO)session.getAttribute("user");
//		System.out.println(user);
		boolean res = boardService.insertBoard(board, user, files);
		if(res) {
			model.addAttribute("msg", "게시글 등록완료");
			model.addAttribute("url","/board/list");
		}else {
			model.addAttribute("msg", "게시글 등록실패");
			model.addAttribute("url","/board/list");
		}
		return "/util/message";
	}
	
	//수정페이지에 + 첨부파일 수정
	@GetMapping("/board/update")
	public String boardUpdate(Model model, Integer bo_num) {
		//System.out.println(bo_num);		//게시글 번호를 확인
		//서비스에게 게시글 번호를 주고 게시글 가져오라고 요청
		BoardVO board = boardService.getBoard(bo_num);
		List<FileVO> fileList = boardService.getFileList(bo_num);
		
		model.addAttribute("board", board);
		model.addAttribute("fileList", fileList);
		
		//가져오면 화면에 게시글 전송
		return "/board/update";
	}
	
	@PostMapping("/board/update")
	public String boardUpdatePost(Model model, HttpSession session, BoardVO board,
			MultipartFile[] files, int [] delNums) {
		//화면에서 보내준 게시글 정보 확인
		System.out.println(board);
		//세션에 저장된 로그인 회원정보 확인
		MemberVO user = (MemberVO)session.getAttribute("user");
		System.out.println(user);
		//서비스에게 게시글정보와 로그인 회원정보 주며 수정하라고 요청
		boolean res = boardService.update(board, user, files, delNums);
		//수정여부에 따라 msg와 url 선정해 화면에 전달
		if(res) {
			model.addAttribute("msg", "게시글 수정 완료");
		}else {
			model.addAttribute("msg", "게시글 수정 실패");
		}
		model.addAttribute("url", "/board/detail?bo_num="+board.getBo_num());
		return "/util/message";
	}
	
	@GetMapping("/board/delete")
	public String boardDelete(Model model, HttpSession session, Integer bo_num) {
		MemberVO user = (MemberVO)session.getAttribute("user");
		boolean res = boardService.deleteBoard(bo_num, user);
		if(res) {
			model.addAttribute("msg", "게시글을 삭제했습니다.");
		}else {
			model.addAttribute("msg", "게시글을 삭제하지 못했습니다.");
		}
		model.addAttribute("url", "/board/list");
		return "/util/message";
	}
	
}
