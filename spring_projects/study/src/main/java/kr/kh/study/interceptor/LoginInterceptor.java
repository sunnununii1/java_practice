package kr.kh.study.interceptor;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.study.service.MemberService;
import kr.kh.study.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{
	
	@Autowired
	MemberService memberService;

	@Override
	public void postHandle(
			HttpServletRequest request,
			HttpServletResponse reponse,
			Object handler,
			ModelAndView modelAndView) throws Exception {
		MemberVO user = (MemberVO)modelAndView.getModel().get("user");
//		System.out.println(user);
		
		//user가 null이 아니면 세션에 저장
		if(user != null) {
			request.getSession().setAttribute("user", user);
			//자동로그인 구현
			if(user.isAutoLogin()) {
				String value = request.getSession().getId();
				//쿠키 생성 > 쿠키에 값(세션아이디)을 넣어 화면에 전달
				Cookie cookie = new Cookie("lc",null);
				//쿠키의 유지시간 추가
				cookie.setPath("/");
				int day = 7;
				int time = day * 24 * 60 * 60; //하루를 초로 변환한 값에 day를 곱함
				cookie.setMaxAge(time);
				//클라이언트에게 쿠키를 보냄
				reponse.addCookie(cookie);
				
				Date date = new Date(System.currentTimeMillis() + time * 1000);
				user.setMe_session_id(value);
				user.setMe_session_limit(date);
				memberService.updateMemberSession(user);
			}
			
		}
		
	}
}
