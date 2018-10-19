package kr.or.ksmart.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.forward.UserActionForward;

public interface UserActionInterFace {
	public UserActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}