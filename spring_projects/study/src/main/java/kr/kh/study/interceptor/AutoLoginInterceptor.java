package kr.kh.study.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import kr.kh.study.service.MemberService;
import kr.kh.study.vo.MemberVO;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object)
		throws Exception {
		
		//이미 로그인 되어있으면 건너뛰기
		HttpSession session = request.getSession();
		//부모클래스 객체(Object)를 자식클래스(MemberVO) 객체로 형변환
		MemberVO user = (MemberVO)session.getAttribute("user");
		
		if(user != null) {
			return true;
		}
		//리퀘스트 요청에 있는 lc라는 쿠키를 가져옴
		Cookie cookie = WebUtils.getCookie(request, "lc");
		//쿠키가 없으면 작업x(건너뜀)
		if(cookie == null) {
			return true;
		}
		//쿠키가 있으면 (멤.서 @auto..해주고) 가져옴
		user = memberService.getMemberBySession(cookie.getValue());
		if(user != null) {
			session.setAttribute("user", user);
		}
		return true;
		
	}
}
