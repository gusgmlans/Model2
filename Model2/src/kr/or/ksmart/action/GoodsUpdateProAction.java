package kr.or.ksmart.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.dao.GoodsDao;
import kr.or.ksmart.dto.GoodsDto;
import kr.or.ksmart.forward.GoodsActionForward;
import kr.or.ksmart.inter.GoodsActionInterFace;

public class GoodsUpdateProAction implements GoodsActionInterFace {

	@Override
	public GoodsActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("05_04 GoodsUpdateProAction.java");
		
		request.setCharacterEncoding("UTF-8");
		
		String g_code = request.getParameter("g_code");
		String u_id = request.getParameter("u_id");
		String g_name = request.getParameter("g_name");
		String g_cate = request.getParameter("g_cate");
		String g_price = request.getParameter("g_price");
		String g_color = request.getParameter("g_color");
		String g_size = request.getParameter("g_size");
		String g_date = request.getParameter("g_date");
		String g_desc = request.getParameter("g_desc");
		
		System.out.println(g_code + "<-- g_code");
		System.out.println(u_id + "<-- u_id");
		System.out.println(g_name + "<-- g_name");
		System.out.println(g_cate + "<-- g_cate");
		System.out.println(g_price + "<-- g_price");
		System.out.println(g_color + "<-- g_color");
		System.out.println(g_size + "<-- g_size");
		System.out.println(g_date + "<-- g_date");
		System.out.println(g_desc + "<-- g_desc");
		
		GoodsDto goodsDto = new GoodsDto();
		goodsDto.setG_code(g_code);
		goodsDto.setU_id(u_id);
		goodsDto.setG_name(g_name);
		goodsDto.setG_cate(g_cate);
		goodsDto.setG_price(g_price);
		goodsDto.setG_color(g_color);
		goodsDto.setG_size(g_size);
		goodsDto.setG_date(g_date);
		goodsDto.setG_desc(g_desc);
		
		GoodsDao goodsDao = new GoodsDao();
		goodsDao.goodsUpdatePro(goodsDto);
		
		GoodsActionForward goodsActionForward = new GoodsActionForward();
		goodsActionForward.setRedirect(true);
		goodsActionForward.setPath(request.getContextPath() + "/GoodsSearchList/goodsSearchList.hhm2");
		
		return goodsActionForward;
	}
}