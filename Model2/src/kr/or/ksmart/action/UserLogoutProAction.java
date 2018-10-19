package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ksmart.forward.UserActionForward;
import kr.or.ksmart.inter.UserActionInterFace;

public class UserLogoutProAction implements UserActionInterFace {

	@Override
	public UserActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("05_09_execute_UserLogoutProAction.java");
		
		//request 객체 내의 getSession 메서드를 호출하여 session의 객체참조변수를 리턴받아 HttpSession class data type으로 선언한 객체참조변수 session에 할당한다.
		HttpSession session = request.getSession();
		
		//session 객체 내의 invalidate 메서드를 호출하여 세션을 종료한다.
		session.invalidate();
		
		//01단계 : UserActionForward 통해 생성된 객체내 포워드 설정 및 경로 설정
		UserActionForward userActionForward = new UserActionForward();
		userActionForward.setRedirect(true);
		userActionForward.setPath(request.getContextPath()+"/Main/main.hhm");
		
		//02단계 : UserActionForward 통해 생성된 객체 주소값 리턴
		return userActionForward;
	}
}