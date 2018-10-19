package kr.or.ksmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.ksmart.dto.UserDto;

public class UserDao {
	
	DataSource dataSource = null;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	ArrayList<UserDto> arrayListUserDto = null;
	
	//default 생성자 메서드 선언
	public UserDao() {
		try{
			Context initialContext = new InitialContext();
			System.out.println(initialContext + " <-- initialContext UserDao()");
			dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/db14hhm");
	  		
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	//06_01 입력처리 메서드 선언
	public void userInsert(UserDto userDto) throws SQLException, ClassNotFoundException{
		System.out.println("06_01 userInsert UserDao.java");
		
		connection = dataSource.getConnection();
		
		preparedStatement = connection.prepareStatement("INSERT INTO tb_user VALUES (?, ?, ?, ?, ?, ?, ?)");
		preparedStatement.setString(1, userDto.getU_id());
		preparedStatement.setString(2, userDto.getU_pw());
		preparedStatement.setString(3, userDto.getU_level());
		preparedStatement.setString(4, userDto.getU_name());
		preparedStatement.setString(5, userDto.getU_email());
		preparedStatement.setString(6, userDto.getU_phone());
		preparedStatement.setString(7, userDto.getU_addr());
		
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		connection.close();
	}
	
	//06_02 전체회원조회 메서드 선언
	public ArrayList<UserDto> userSelect() throws SQLException{
		System.out.println("06_02 userList UserDao.java");
		
		arrayListUserDto = new ArrayList<UserDto>();
		
		connection = dataSource.getConnection();
		
		preparedStatement = connection.prepareStatement("SELECT u_id, u_pw, u_level, u_name, u_email, u_phone, u_addr  FROM tb_user");
		
		resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			UserDto userDto = new UserDto();
			userDto.setU_id(resultSet.getString("u_id"));
			userDto.setU_pw(resultSet.getString("u_pw"));
			userDto.setU_level(resultSet.getString("u_level"));
			userDto.setU_name(resultSet.getString("u_name"));
			userDto.setU_email(resultSet.getString("u_email"));
			userDto.setU_phone(resultSet.getString("u_phone"));
			userDto.setU_addr(resultSet.getString("u_addr"));
			arrayListUserDto.add(userDto);
		}
		
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
		return arrayListUserDto;
	}
	
	//06_03 업데이트회원조회 메서드 선언
	public UserDto userUpdatForm(String u_id) throws SQLException{
		System.out.println("06_03 userUpdatForm UserDao.java");
		
		UserDto userDto = null;
		
		connection = dataSource.getConnection();
		
		preparedStatement = connection.prepareStatement("SELECT u_id, u_pw, u_level, u_name, u_email, u_phone, u_addr  FROM tb_user WHERE u_id = ?");
		preparedStatement.setString(1, u_id);
		
		resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			userDto = new UserDto();
			userDto.setU_id(resultSet.getString("u_id"));
			userDto.setU_pw(resultSet.getString("u_pw"));
			userDto.setU_level(resultSet.getString("u_level"));
			userDto.setU_name(resultSet.getString("u_name"));
			userDto.setU_email(resultSet.getString("u_email"));
			userDto.setU_phone(resultSet.getString("u_phone"));
			userDto.setU_addr(resultSet.getString("u_addr"));
		}
		
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
		return userDto;
	}
	
	//06_04 회원수정 메서드 선언
	public void userUpdatePro(UserDto userDto) throws SQLException{
		System.out.println("06_04 userUpdatePro UserDao.java");
		
		connection = dataSource.getConnection();
		
		preparedStatement = connection.prepareStatement("UPDATE tb_user SET u_pw = ?, u_level = ?, u_name = ?, u_email = ?, u_phone = ?, u_addr = ? WHERE u_id = ?");
		preparedStatement.setString(1, userDto.getU_pw());
		preparedStatement.setString(2, userDto.getU_level());
		preparedStatement.setString(3, userDto.getU_name());
		preparedStatement.setString(4, userDto.getU_email());
		preparedStatement.setString(5, userDto.getU_phone());
		preparedStatement.setString(6, userDto.getU_addr());
		preparedStatement.setString(7, userDto.getU_id());
		
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		connection.close();
	}
	
	//06_05 회원삭제 메서드 선언
	public void userDelete(String u_id) throws SQLException{
		System.out.println("06_05 userDelete UserDao.java");
		
		connection = dataSource.getConnection();
		
		preparedStatement = connection.prepareStatement("DELETE FROM tb_user WHERE u_id = ?");
		preparedStatement.setString(1, u_id);
		
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		connection.close();
	}
	
	//06_06 회원상세조회 메서드 선언
	public UserDto userDetail(String u_id) throws SQLException{
		System.out.println("06_06 userDetail UserDao.java");
		
		UserDto userDto = null;
		
		connection = dataSource.getConnection();
		
		preparedStatement = connection.prepareStatement("SELECT u_id, u_pw, u_level, u_name, u_email, u_phone, u_addr  FROM tb_user WHERE u_id = ?");
		preparedStatement.setString(1, u_id);
		
		resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			userDto = new UserDto();
			userDto.setU_id(resultSet.getString("u_id"));
			userDto.setU_pw(resultSet.getString("u_pw"));
			userDto.setU_level(resultSet.getString("u_level"));
			userDto.setU_name(resultSet.getString("u_name"));
			userDto.setU_email(resultSet.getString("u_email"));
			userDto.setU_phone(resultSet.getString("u_phone"));
			userDto.setU_addr(resultSet.getString("u_addr"));
		}
		
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
		return userDto;
	}
	
	//06_07 회원검색 메서드 선언
	public ArrayList<UserDto> userSearch(String searchKey, String searchValue) throws SQLException{
		System.out.println("06_07 userSearch UserDao.java");
		
		arrayListUserDto = new ArrayList<UserDto>();
		
		connection = dataSource.getConnection();
		
		if(searchKey == null & searchValue == null){
			System.out.println("01조건_searchKey null searchValue null");
			preparedStatement = connection.prepareStatement("SELECT u_id, u_pw, u_level, u_name, u_email, u_phone, u_addr FROM tb_user");
		}else if(searchKey != null & searchValue.equals("")){
			System.out.println("02조건_searchKey 있고 searchValue 공백");
			preparedStatement = connection.prepareStatement("SELECT u_id, u_pw, u_level, u_name, u_email, u_phone, u_addr FROM tb_user");
		}else if(searchKey != null & searchValue != null){
			System.out.println("03조건_둘다 값이 있다");
			preparedStatement = connection.prepareStatement("SELECT u_id, u_pw, u_level, u_name, u_email, u_phone, u_addr FROM tb_user WHERE "+searchKey+"= ?");
			preparedStatement.setString(1, searchValue);
		}
		
		resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			UserDto userDto = new UserDto();
			userDto.setU_id(resultSet.getString("u_id"));
			userDto.setU_pw(resultSet.getString("u_pw"));
			userDto.setU_level(resultSet.getString("u_level"));
			userDto.setU_name(resultSet.getString("u_name"));
			userDto.setU_email(resultSet.getString("u_email"));
			userDto.setU_phone(resultSet.getString("u_phone"));
			userDto.setU_addr(resultSet.getString("u_addr"));
			arrayListUserDto.add(userDto);
		}
		
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
		return arrayListUserDto;
	}
	
	//06_08 로그인정보 확인 메서드 선언
	public int userLoginCheck(String u_id, String u_pw) throws ClassNotFoundException, SQLException {
		System.out.println("06_08 userLoginCheck UserDao.java");
		
		int loginCheck = 0;
		
		connection = dataSource.getConnection();
		
		preparedStatement = connection.prepareStatement("SELECT u_pw FROM tb_user WHERE u_id = ?");
		preparedStatement.setString(1, u_id);
		
		resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			if(u_pw.equals(resultSet.getString("u_pw"))) {
				loginCheck = 1;
			}else {
				loginCheck = 3;
			}
		}else {
			loginCheck = 2;
		}
		
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
		return loginCheck;
	}
	
	//06_09 로그인 성공시 세션을 세팅을 위한 조회 메서드 선언
	public UserDto userSession(String u_id) throws ClassNotFoundException, SQLException {
		System.out.println("06_09 userSession UserDao.java");
		
		UserDto userDto = null;
		
		connection = dataSource.getConnection();
		
		preparedStatement = connection.prepareStatement("SELECT u_id, u_pw, u_level, u_name, u_email, u_phone, u_addr FROM tb_user WHERE u_id = ?");
		preparedStatement.setString(1, u_id);
		
		resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			userDto = new UserDto();
			userDto.setU_id(resultSet.getString("u_id"));
			userDto.setU_pw(resultSet.getString("u_pw"));
			userDto.setU_level(resultSet.getString("u_level"));
			userDto.setU_name(resultSet.getString("u_name"));
			userDto.setU_email(resultSet.getString("u_email"));
			userDto.setU_phone(resultSet.getString("u_phone"));
			userDto.setU_addr(resultSet.getString("u_addr"));
		}
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
		return userDto;
	}
}