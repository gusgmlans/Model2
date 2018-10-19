package kr.or.ksmart.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.dao.GoodsDao;
import kr.or.ksmart.dto.GoodsDto;
import kr.or.ksmart.forward.GoodsActionForward;
import kr.or.ksmart.inter.GoodsActionInterFace;

public class GoodsSearchListProAction implements GoodsActionInterFace {

	@Override
	public GoodsActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("05_07 execute GoodsSearchListProAction.java");
		
		request.setCharacterEncoding("UTF-8");
		
		String searchKey = request.getParameter("searchKey");
		String searchValue = request.getParameter("searchValue");
		
		System.out.println(searchKey + "<-- searchKey");
		System.out.println(searchValue + "<-- searchValue");
		
		GoodsDao goodsDao = new GoodsDao();
		ArrayList<GoodsDto> arrayListGoodsDto = goodsDao.goodsSearchList(searchKey, searchValue);
		
		request.setAttribute("arrayListGoodsDto", arrayListGoodsDto);
		
		GoodsActionForward goodsActionForward = new GoodsActionForward();
		goodsActionForward.setRedirect(false);
		goodsActionForward.setPath("/goods/goods_search_list.jsp");
		
		return goodsActionForward;
	}
}