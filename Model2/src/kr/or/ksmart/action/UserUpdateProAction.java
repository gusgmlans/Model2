package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.dao.UserDao;
import kr.or.ksmart.dto.UserDto;
import kr.or.ksmart.forward.UserActionForward;
import kr.or.ksmart.inter.UserActionInterFace;

public class UserUpdateProAction implements UserActionInterFace {

	@Override
	public UserActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("05_04 execute UserUpdateFormAction.java");
		
		//01단계 : 화면에서 입력한 값들을 받아 콘솔창에 출력한다
		request.setCharacterEncoding("UTF-8");
		
		String u_id = request.getParameter("u_id");
		String u_pw = request.getParameter("u_pw");
		String u_level = request.getParameter("u_level");
		String u_name = request.getParameter("u_name");
		String u_email = request.getParameter("u_email");
		String u_phone = request.getParameter("u_phone");
		String u_addr = request.getParameter("u_addr");
		
		System.out.println(u_id + "<-- u_id");
		System.out.println(u_pw + "<-- u_pw");
		System.out.println(u_level + "<-- u_level");
		System.out.println(u_name + "<-- u_name");
		System.out.println(u_email + "<-- u_email");
		System.out.println(u_phone + "<-- u_phone");
		System.out.println(u_addr + "<-- u_addr");
		
		//02단계 : UserDto 클래스 통해 생성된 객체 내에 값들 셋팅
		UserDto userDto = new UserDto();
		userDto.setU_id(u_id);
		userDto.setU_pw(u_pw);
		userDto.setU_level(u_level);
		userDto.setU_name(u_name);
		userDto.setU_email(u_email);
		userDto.setU_phone(u_phone);
		userDto.setU_addr(u_addr);
		
		//03단계 : UserDao 객체 내에 수정 처리 메서드 호출
		UserDao userDao = new UserDao();
		userDao.userUpdatePro(userDto);
		
		//04단계 : UserActionForward 통해 생성된 객체내 리다이렉트 설정 및 경로 설정
		UserActionForward userActionForward = new UserActionForward();
		userActionForward.setRedirect(true);
		userActionForward.setPath(request.getContextPath()+"/UserSearch/userSearchList.hhm");
		
		//05단계 : UserActionForward 통해 생성된 객체 주소값 리턴
		return userActionForward;
	}
}