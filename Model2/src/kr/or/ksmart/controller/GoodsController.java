package kr.or.ksmart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.action.GoodsDeleteProAction;
import kr.or.ksmart.action.GoodsDetailProAction;
import kr.or.ksmart.action.GoodsInsertProAction;
import kr.or.ksmart.action.GoodsListProAction;
import kr.or.ksmart.action.GoodsSearchListProAction;
import kr.or.ksmart.action.GoodsUpdateFormAction;
import kr.or.ksmart.action.GoodsUpdateProAction;
import kr.or.ksmart.forward.GoodsActionForward;
import kr.or.ksmart.inter.GoodsActionInterFace;

@WebServlet("/GoodsController")
public class GoodsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public GoodsController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("01 doGet GoodsController.java");
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("02 doPost GoodsController.java");
		doProcess(request, response);
	}
	
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("03 doProcess GoodsController.java");
    	String RequestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String command = RequestURI.substring(contextPath.length());
    	
    	System.out.println(RequestURI + "<-- RequestURI");	
    	System.out.println(contextPath + "<-- contextPath GoodsController.java");
		System.out.println(contextPath.length() + "<-- contextPath.length() GoodsController.java");
		System.out.println(command + "<-- command GoodsController.java");
    
		GoodsActionForward goodsActionForward = null;
		GoodsActionInterFace goodsActionInterFace = null;
		
		if(command.equals("/GoodsInsert/goodsInsertForm.hhm2")) {
			System.out.println("04_01_/GoodsInsert/goodsInsertForm.hhm2");	
			goodsActionForward = new GoodsActionForward();
			goodsActionForward.setRedirect(false);
			goodsActionForward.setPath("/goods/goods_insert_form.jsp");
    	}else if(command.equals("/GoodsInsert/goodsInsertPro.hhm2")) {
			System.out.println("04_02_/GoodsInsert/goodsInsertPro.hhm2");
			goodsActionInterFace = new GoodsInsertProAction();
			try {
				goodsActionForward = goodsActionInterFace.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/GoodsList/goodsList.hhm2")) {
			System.out.println("04_03_/GoodsList/goodsList.hhm2");
			goodsActionInterFace = new GoodsListProAction();
			try {
				goodsActionForward = goodsActionInterFace.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/GoodsUpdate/goodsUpdateForm.hhm2")) {
			System.out.println("04_04_/GoodsUpdate/goodsUpdateForm.hhm2");
			goodsActionInterFace = new GoodsUpdateFormAction();
			try {
				goodsActionForward = goodsActionInterFace.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/GoodsUpdate/goodsUpdatePro.hhm2")) {
			System.out.println("04_05_/GoodsUpdate/goodsUpdatePro.hhm2");
			goodsActionInterFace = new GoodsUpdateProAction();
			try {
				goodsActionForward = goodsActionInterFace.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/GoodsDelete/goodsDeletePro.hhm2")) {
			System.out.println("04_06_/GoodsDelete/goodsDeletePro.hhm2");
			goodsActionInterFace = new GoodsDeleteProAction();
			try {
				goodsActionForward = goodsActionInterFace.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/GoodsDetail/goodsDetailPro.hhm2")) {
			System.out.println("04_07_/GoodsDetail/goodsDetail.hhm2");
			goodsActionInterFace = new GoodsDetailProAction();
			try {
				goodsActionForward = goodsActionInterFace.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/GoodsSearchList/goodsSearchList.hhm2")) {
			System.out.println("04_08_/GoodsSearchList/goodsSearchList.hhm2");
			goodsActionInterFace = new GoodsSearchListProAction();
			try {
				goodsActionForward = goodsActionInterFace.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(goodsActionForward != null){
			if(goodsActionForward.isRedirect()){
				response.sendRedirect(goodsActionForward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(goodsActionForward.getPath());
				System.out.println(goodsActionForward.getPath() + "<-- goodsActionForward.getPath()[jsp 이동경로] GoodsController.java");
				System.out.println();
				dispatcher.forward(request, response);
			}
		}
    }
}