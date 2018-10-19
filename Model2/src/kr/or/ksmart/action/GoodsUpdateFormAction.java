package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.dao.GoodsDao;
import kr.or.ksmart.dto.GoodsDto;
import kr.or.ksmart.forward.GoodsActionForward;
import kr.or.ksmart.inter.GoodsActionInterFace;

public class GoodsUpdateFormAction implements GoodsActionInterFace {

	@Override
	public GoodsActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("05_03 GoodsUpdateFormAction.java");
		
		request.setCharacterEncoding("UTF-8");
		
		String g_code = request.getParameter("send_g_code");
		
		GoodsDao goodsDao = new GoodsDao();
		GoodsDto goodsDto = goodsDao.goodsUpdateForm(g_code);
		
		request.setAttribute("goodsDto", goodsDto);
		
		GoodsActionForward goodsActionForward = new GoodsActionForward();
		goodsActionForward.setRedirect(false);
		goodsActionForward.setPath("/goods/goods_update_form.jsp");
		
		return goodsActionForward;
	}
}