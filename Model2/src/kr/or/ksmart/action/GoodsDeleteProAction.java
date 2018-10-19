package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.dao.GoodsDao;
import kr.or.ksmart.forward.GoodsActionForward;
import kr.or.ksmart.inter.GoodsActionInterFace;

public class GoodsDeleteProAction implements GoodsActionInterFace {

	@Override
	public GoodsActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("05_05 execute GoodsDeleteProAction.java");
		
		request.setCharacterEncoding("UTF-8");
		
		String g_code = request.getParameter("send_g_code");
		
		GoodsDao goodsDao = new GoodsDao();
		goodsDao.goodsDelete(g_code);
		
		GoodsActionForward goodsActionForward = new GoodsActionForward();
		goodsActionForward.setRedirect(true);
		goodsActionForward.setPath(request.getContextPath() + "/GoodsSearchList/goodsSearchList.hhm2");
		
		return goodsActionForward;
	}
}