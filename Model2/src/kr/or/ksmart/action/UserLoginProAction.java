package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ksmart.dao.UserDao;
import kr.or.ksmart.dto.UserDto;
import kr.or.ksmart.forward.UserActionForward;
import kr.or.ksmart.inter.UserActionInterFace;

public class UserLoginProAction implements UserActionInterFace {
	
	private UserActionForward userActionForward = null;

	@Override
	public UserActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("05_08_execute_UserLoginProAction.java");
		
		//01단계 : 화면에서 입력한 값들을 받아 콘솔창에 출력한다
		request.setCharacterEncoding("UTF-8");
		
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");
		System.out.println(u_id + "<-- u_id");
		System.out.println(u_pw + "<-- u_pw");
		
		//02단계 : UserDao 객체 내에 로그인 체크를 위한 조회 메서드 호출
		UserDao userDao = new UserDao();
		int loginCheck = userDao.userLoginCheck(u_id, u_pw);
		
		//03단계 : 로그인 체크를 위한 조회 메서드 결과를 통해 로그인 처리
		if(loginCheck == 1) {
			System.out.println("로그인 성공");
			
			//세션 세팅을 위한 UserDao 객체 내에 세션 세팅을 위한 조회 메서드 호출
			UserDto userDto = userDao.userSession(u_id);
			
			System.out.println(userDto.getU_id());
			System.out.println(userDto.getU_level());
			System.out.println(userDto.getU_name());
			
			//request 객체 내의 getSession 메서드를 호출하여 session의 객체참조변수를 리턴받아 HttpSession class data type으로 선언한 객체참조변수 session에 할당한다.
			HttpSession session = request.getSession();
			
			//session의 객체 내에 세션 값을 세팅한다.
			session.setAttribute("S_ID", userDto.getU_id());
			session.setAttribute("S_LEVEL", userDto.getU_level());
			session.setAttribute("S_NAME", userDto.getU_name());
			
			//04단계 : UserActionForward 통해 생성된 객체내 리다이렉트 설정 및 경로 설정
			userActionForward = new UserActionForward();
			userActionForward.setRedirect(true);
			userActionForward.setPath(request.getContextPath()+"/Main/main.hhm");
			
		}else if(loginCheck == 2) {
			System.out.println("아이디 불일치");
			
			//04단계 : UserActionForward 통해 생성된 객체내 리다이렉트 설정 및 경로 설정
			userActionForward = new UserActionForward();
			userActionForward.setRedirect(true);
			userActionForward.setPath(request.getContextPath()+"/Main/main.hhm");
		}else if(loginCheck == 3) {
			System.out.println("비밀번호 불일치");
			
			//04단계 : UserActionForward 통해 생성된 객체내 리다이렉트 설정 및 경로 설정
			userActionForward = new UserActionForward();
			userActionForward.setRedirect(true);
			userActionForward.setPath(request.getContextPath()+"/Main/main.hhm");
		}
		
		//05단계 : UserActionForward 통해 생성된 객체 주소값 리턴
		return userActionForward;
	}
}