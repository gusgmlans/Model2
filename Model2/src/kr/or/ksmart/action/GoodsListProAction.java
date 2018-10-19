package kr.or.ksmart.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.dao.GoodsDao;
import kr.or.ksmart.dto.GoodsDto;
import kr.or.ksmart.forward.GoodsActionForward;
import kr.or.ksmart.inter.GoodsActionInterFace;

public class GoodsListProAction implements GoodsActionInterFace {

	@Override
	public GoodsActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("05_02 GoodsListProAction.java");
		
		GoodsDao goodsDao = new GoodsDao();
		ArrayList<GoodsDto> arrayListGoodsDto = goodsDao.goodsSelect();
		
		request.setAttribute("arrayListGoodsDto", arrayListGoodsDto);
		
		GoodsActionForward goodsActionForward = new GoodsActionForward();
		goodsActionForward.setRedirect(false);
		goodsActionForward.setPath("/goods/goods_list.jsp");
		
		return goodsActionForward;
	}
}