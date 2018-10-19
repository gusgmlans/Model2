package kr.or.ksmart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ksmart.action.UserDeleteProAction;
import kr.or.ksmart.action.UserDetailProAction;
import kr.or.ksmart.action.UserInsertProAction;
import kr.or.ksmart.action.UserListProAction;
import kr.or.ksmart.action.UserLoginProAction;
import kr.or.ksmart.action.UserLogoutProAction;
import kr.or.ksmart.action.UserSearchListProAction;
import kr.or.ksmart.action.UserUpdateFormAction;
import kr.or.ksmart.action.UserUpdateProAction;
import kr.or.ksmart.forward.UserActionForward;
import kr.or.ksmart.inter.UserActionInterFace;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public UserController() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("01 doGet UserController.java");
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("02 doPost UserController.java");
		doProcess(request, response);
	}
	
    protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("03 doProcess UserController.java");
    	String RequestURI = request.getRequestURI();
    	String contextPath = request.getContextPath();
    	String command = RequestURI.substring(contextPath.length());
    	
    	System.out.println(RequestURI + "<-- RequestURI");	
    	System.out.println(contextPath + "<-- contextPath UserController.java");
		System.out.println(contextPath.length() + "<-- contextPath.length() UserController.java");
		System.out.println(command + "<-- command UserController.java");
    
		UserActionForward userActionForward = null;
		UserActionInterFace userActionInterFace = null;
		
		if(command.equals("/Main/main.hhm")) {
			System.out.println("04_01_/Main/main.hhm");	
			userActionForward = new UserActionForward();
			userActionForward.setRedirect(false);
			userActionForward.setPath("/main/main.jsp");
    	}else if(command.equals("/UserInsert/userInsertForm.hhm")) {
			System.out.println("04_02_/UserInsert/userInsertForm.hhm");	
			userActionForward = new UserActionForward();
			userActionForward.setRedirect(false);
			userActionForward.setPath("/user_insert/user_insert_form.jsp");
		}else if(command.equals("/UserInsert/userInsertPro.hhm")) {
			System.out.println("04_03_/UserInsert/userInsertPro.hhm");
			userActionInterFace = new UserInsertProAction();
			try {
				userActionForward = userActionInterFace.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/UserList/userList.hhm")) {
			System.out.println("04_04_/UserList/userList.hhm");
			userActionInterFace = new UserListProAction();
			try {
				userActionForward = userActionInterFace.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/UserUpdate/userUpdateForm.hhm")) {
			System.out.println("04_05_/UserUpdate/userUpdateForm.hhm");
			userActionInterFace = new UserUpdateFormAction();
			try {
				userActionForward = userActionInterFace.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/UserUpdate/userUpdatePro.hhm")) {
			System.out.println("04_06_/UserUpdate/userUpdatePro.hhm");
			userActionInterFace = new UserUpdateProAction();
			try {
				userActionForward = userActionInterFace.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/UserDelete/userDeletePro.hhm")) {
			System.out.println("04_07_/UserDelete/userDeletePro.hhm");
			userActionInterFace = new UserDeleteProAction();
			try {
				userActionForward = userActionInterFace.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/UserDetail/userDetailPro.hhm")) {
			System.out.println("04_08_/UserDetail/userDetailPro.hhm");
			userActionInterFace = new UserDetailProAction();
			try {
				userActionForward = userActionInterFace.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/UserSearch/userSearchList.hhm")) {
			System.out.println("04_09_/UserSearch/userSearchList.hhm");
			userActionInterFace = new UserSearchListProAction();
			try {
				userActionForward = userActionInterFace.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/User/userLogin.hhm")) {
			System.out.println("04_10_/User/userLogin.hhm");
			userActionInterFace = new UserLoginProAction();
			try {
				userActionForward = userActionInterFace.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/User/userLogout.hhm")) {
			System.out.println("04_11_/User/userLogout.hhm");
			userActionInterFace = new UserLogoutProAction();
			try {
				userActionForward = userActionInterFace.execute(request, response);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(userActionForward != null){
			if(userActionForward.isRedirect()){
				response.sendRedirect(userActionForward.getPath());
			}else{
				RequestDispatcher dispatcher = request.getRequestDispatcher(userActionForward.getPath());
				System.out.println(userActionForward.getPath() + "<-- userActionForward.getPath()[jsp 이동경로] UserController.java");
				System.out.println();
				dispatcher.forward(request, response);
			}
		}
    }
}