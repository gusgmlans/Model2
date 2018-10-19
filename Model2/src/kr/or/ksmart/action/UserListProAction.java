package kr.or.ksmart.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.dao.UserDao;
import kr.or.ksmart.dto.UserDto;
import kr.or.ksmart.forward.UserActionForward;
import kr.or.ksmart.inter.UserActionInterFace;

public class UserListProAction implements UserActionInterFace {

	@Override
	public UserActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("05_02 execute UserListProAction.java");
		
		//01단계 : 메서드 호출 후 리턴값을 받는다.
		UserDao userDao = new UserDao();
		ArrayList<UserDto> arrayListUserDto = userDao.userSelect();
		
		//02단계 : request 객체내 리턴값(ArrayList 객체 주소값)을 셋팅
		request.setAttribute("arrayListUserDto", arrayListUserDto);
	
		//03단계 : UserActionForward 통해 생성된 객체내 포워드 설정 및 경로 설정
		UserActionForward userActionForward = new UserActionForward();
		userActionForward.setRedirect(false);
		userActionForward.setPath("/user_list/user_list.jsp");
		
		//04단계 : UserActionForward 통해 생성된 객체 주소값 리턴
		return userActionForward;
	}
}