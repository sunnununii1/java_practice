package kr.kh.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.kh.spring.service.MemberService;
import kr.kh.spring.util.Message;
import kr.kh.spring.vo.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	//url 찾아주는 역할
	//=> 클라이언트가 url에 signup을 요청하면 실행해준다.
	@RequestMapping(value="/member/signup", method=RequestMethod.GET)
	public String signup() {
		
		return "/member/signup";
	}
	
	//signup의 method가 post이므로 입력 후 전송코드는 이걸로
	@RequestMapping(value="/member/signup", method=RequestMethod.POST)
	public String signupPost(MemberVO member, Model model) {
		
		Message msg = new Message("/member/signup", "회원가입에 실패했습니다.");
		
		if(memberService.signup(member)) {
			msg = new Message("/", "회원가입에 성공했습니다.");
		}
		
		model.addAttribute("msg", msg);
		return "message";
	}
	
	//url과 jsp 경로가 같은 경우엔 void + return 경로입력 생략 가능
	@GetMapping(value="/member/login")
	public String memberLogin() {
		return "/member/login";
	}
	
	@PostMapping(value="/member/login")
	public String memberLoginPost(MemberVO member, Model model) {
		Message msg = new Message("/member/login", "로그인에 실패했습니다.");
		
		MemberVO user = memberService.login(member);
				
		if(user != null) {
			msg = new Message("/", "로그인에 성공했습니다.");
		}
		model.addAttribute("user",user);
		model.addAttribute("msg",msg);
		return "message";
	}
	
	@GetMapping("/member/logout")
	// HttpServletRequest request는 클라이언트가 요청한 리퀘스트를 뜻함
	public String memberLogout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		MemberVO user = (MemberVO)session.getAttribute("user");
		Message msg = new Message("/", null);
		
		if(user != null) {
			session.removeAttribute("user");
			msg.setMsg("로그아웃에 성공했습니다.");
		}
		model.addAttribute("msg",msg);
		return "message";
	}
}
