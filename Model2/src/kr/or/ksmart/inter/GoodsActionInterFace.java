package kr.or.ksmart.inter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.forward.GoodsActionForward;

public interface GoodsActionInterFace {
	public GoodsActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}