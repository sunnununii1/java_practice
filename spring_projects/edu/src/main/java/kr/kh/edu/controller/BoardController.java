package kr.kh.edu.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.edu.service.BoardService;
import kr.kh.edu.vo.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping("/board/list")
	public String BoardList(HttpSession session, Model model) {
		List<BoardVO> list = boardService.getBoardList();
		return "/board/list";
	}
	
}
