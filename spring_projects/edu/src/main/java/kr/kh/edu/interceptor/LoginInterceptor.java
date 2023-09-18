package kr.kh.edu.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.edu.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	//컨트롤 누른 채로 핸들러인터셉터어댑터에 호버하고 들어가서 원하는 타입 복붙해옴
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			@Nullable ModelAndView modelAndView) throws Exception {
		
		//회원정보가 있는지 확인
		MemberVO user = (MemberVO)modelAndView.getModel().get("user");
		if(user == null) {
			return;
		}
		//있으면 세션에 저장
		request.getSession().setAttribute("user", user);
		
	}
	
	
}
