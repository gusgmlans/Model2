package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.dao.UserDao;
import kr.or.ksmart.dto.UserDto;
import kr.or.ksmart.forward.UserActionForward;
import kr.or.ksmart.inter.UserActionInterFace;

public class UserUpdateFormAction implements UserActionInterFace {

	@Override
	public UserActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("05_03 execute UserUpdateFormAction.java");
		
		//01단계 : user_list.jsp에서 받아온 아이디 값을 받는다.
		request.setCharacterEncoding("UTF-8");
		
		String u_id = request.getParameter("send_id");
		System.out.println(u_id);
		
		//02단계 : UserDao 객체 내에 업데이트 처리를 위한 조회 메서드 호출
		UserDao userDao = new UserDao();
		UserDto userDto = userDao.userUpdatForm(u_id);
		
		//03단계 : request 객체내 리턴값(UserDto 객체 주소값)을 셋팅
		request.setAttribute("userDto", userDto);
		
		//04단계 : UserActionForward 통해 생성된 객체내 포워드 설정 및 경로 설정
		UserActionForward userActionForward = new UserActionForward();
		userActionForward.setRedirect(false);
		userActionForward.setPath("/user_update/user_update_form.jsp");
		
		//05단계 : UserActionForward 통해 생성된 객체 주소값 리턴
		return userActionForward;
	}
}