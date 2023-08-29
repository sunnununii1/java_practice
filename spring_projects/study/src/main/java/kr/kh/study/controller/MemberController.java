package kr.kh.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.kh.study.service.MemberService;

@Controller //컨트롤러 어노테이션 해줘야 컨트롤러로써의 인식 가능
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@GetMapping("/test")
	public String test() {
		int count = memberService.count();
		System.out.println(count);
		//redirect:/ = url을 바꿔줌
		return "redirect:/";
	}
}
