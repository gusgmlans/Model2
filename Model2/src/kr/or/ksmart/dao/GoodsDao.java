package kr.or.ksmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import kr.or.ksmart.dto.GoodsDto;

public class GoodsDao {
	DataSource dataSource = null;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;
	ArrayList<GoodsDto> arrayListGoodsDto = null;
	
	//default 생성자 메서드 선언
	public GoodsDao() {
		try{
			Context initialContext = new InitialContext();
			System.out.println(initialContext + " <-- initialContext UserDao()");
			dataSource = (DataSource) initialContext.lookup("java:comp/env/jdbc/db14hhm");
	  		
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}
	
	//06_01 상품등록을 위한 g_code의 최대값 조회 메서드 선언
	public String goodsCodeSelect() throws ClassNotFoundException, SQLException {
		System.out.println("06_01 goodsCodeSelect GoodsDAO.java");
		
		connection = dataSource.getConnection();
		
		preparedStatement = connection.prepareStatement("SELECT MAX(CAST(SUBSTRING(g_code, 7) AS DECIMAL)) AS maxCode FROM tb_goods");
		
		resultSet = preparedStatement.executeQuery();
		
		int max1 = 0;
		
		String tempCode = "goods_";
		
		String g_code = "goods_1";
		
		if (resultSet.next()) {
			max1 = resultSet.getInt("maxCode");
			System.out.println(max1 + "<-- max1");
			
			int max2 = max1 + 1;
			System.out.println(max2 + "<-- max2");
			
			g_code = tempCode + max2;
		}
		
		System.out.println(g_code);
		
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
		return g_code;
	}
	
	//06_02 입력처리 메서드 선언
	public void goodsInsert(GoodsDto goodsDto) throws SQLException, ClassNotFoundException{
		System.out.println("06_02 goodsInsert GoodsDao.java");
		
		connection = dataSource.getConnection();
		
		preparedStatement = connection.prepareStatement("INSERT INTO tb_goods VALUES (?, ?, ?, ?, ?, ?, ?, now(), ?)");
		preparedStatement.setString(1, goodsDto.getG_code());
		preparedStatement.setString(2, goodsDto.getU_id());
		preparedStatement.setString(3, goodsDto.getG_name());
		preparedStatement.setString(4, goodsDto.getG_cate());
		preparedStatement.setString(5, goodsDto.getG_price());
		preparedStatement.setString(6, goodsDto.getG_color());
		preparedStatement.setString(7, goodsDto.getG_size());
		preparedStatement.setString(8, goodsDto.getG_desc());
		
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		connection.close();
	}
	
	//06_03 상품조회 메서드 선언
	public ArrayList<GoodsDto> goodsSelect() throws SQLException, ClassNotFoundException{
		System.out.println("06_03 goodsSelect GoodsDao.java");
		
		arrayListGoodsDto = new ArrayList<GoodsDto>();
		
		connection = dataSource.getConnection();
		
		preparedStatement = connection.prepareStatement("SELECT g_code, u_id, g_name, g_cate, g_price, g_color, g_size, g_date, g_desc FROM tb_goods");
		
		resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			GoodsDto goodsDto = new GoodsDto();
			goodsDto.setG_code(resultSet.getString("g_code"));
			goodsDto.setU_id(resultSet.getString("u_id"));
			goodsDto.setG_name(resultSet.getString("g_name"));
			goodsDto.setG_cate(resultSet.getString("g_cate"));
			goodsDto.setG_price(resultSet.getString("g_price"));
			goodsDto.setG_color(resultSet.getString("g_color"));
			goodsDto.setG_size(resultSet.getString("g_size"));
			goodsDto.setG_date(resultSet.getString("g_date"));
			goodsDto.setG_desc(resultSet.getString("g_desc"));
			arrayListGoodsDto.add(goodsDto);
		}
		
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
		return arrayListGoodsDto;
	}
	
	//06_04 상품정보수정을 위한 조회 메서드 선언
	public GoodsDto goodsUpdateForm(String g_code) throws SQLException, ClassNotFoundException{
		System.out.println("06_04 goodsUpdateForm GoodsDao.java");
		
		GoodsDto goodsDto = null;
		
		connection = dataSource.getConnection();
		
		preparedStatement = connection.prepareStatement("SELECT g_code, u_id, g_name, g_cate, g_price, g_color, g_size, g_date, g_desc FROM tb_goods WHERE g_code = ?");
		preparedStatement.setString(1, g_code);
		
		resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			goodsDto = new GoodsDto();
			goodsDto.setG_code(resultSet.getString("g_code"));
			goodsDto.setU_id(resultSet.getString("u_id"));
			goodsDto.setG_name(resultSet.getString("g_name"));
			goodsDto.setG_cate(resultSet.getString("g_cate"));
			goodsDto.setG_price(resultSet.getString("g_price"));
			goodsDto.setG_color(resultSet.getString("g_color"));
			goodsDto.setG_size(resultSet.getString("g_size"));
			goodsDto.setG_date(resultSet.getString("g_date"));
			goodsDto.setG_desc(resultSet.getString("g_desc"));
		}
		
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
		return goodsDto;
	}
	
	//06_05 상품정보 수정 메서드 선언
	public void goodsUpdatePro(GoodsDto goodsDto) throws SQLException, ClassNotFoundException{
		System.out.println("06_05 goodsUpdatePro GoodsDao.java");
		
		connection = dataSource.getConnection();
		
		preparedStatement = connection.prepareStatement("UPDATE tb_goods SET g_name = ?, g_cate = ?, g_price = ?, g_color = ?, g_size = ?, g_desc = ? WHERE g_code = ?");
		preparedStatement.setString(1, goodsDto.getG_name());
		preparedStatement.setString(2, goodsDto.getG_cate());
		preparedStatement.setString(3, goodsDto.getG_price());
		preparedStatement.setString(4, goodsDto.getG_color());
		preparedStatement.setString(5, goodsDto.getG_size());
		preparedStatement.setString(6, goodsDto.getG_desc());
		preparedStatement.setString(7, goodsDto.getG_code());
		
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		connection.close();
	}
	
	//06_06 상품삭제 메서드 선언
	public void goodsDelete(String g_code) throws SQLException, ClassNotFoundException{
		System.out.println("06_05 goodsUpdatePro GoodsDao.java");
		
		connection = dataSource.getConnection();
		
		preparedStatement = connection.prepareStatement("DELETE FROM tb_goods WHERE g_code = ?");
		preparedStatement.setString(1, g_code);
		
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		connection.close();
	}
	
	//06_07 상품상세정보 조회 메서드 선언
	public GoodsDto goodsDetail(String g_code) throws SQLException, ClassNotFoundException{
		System.out.println("06_05 goodsUpdatePro GoodsDao.java");
		
		GoodsDto goodsDto = null;
		
		connection = dataSource.getConnection();
		
		preparedStatement = connection.prepareStatement("SELECT g_code, u_id, g_name, g_cate, g_price, g_color, g_size, g_date, g_desc FROM tb_goods WHERE g_code = ?");
		preparedStatement.setString(1, g_code);
		
		resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			goodsDto = new GoodsDto();
			goodsDto.setG_code(resultSet.getString("g_code"));
			goodsDto.setU_id(resultSet.getString("u_id"));
			goodsDto.setG_name(resultSet.getString("g_name"));
			goodsDto.setG_cate(resultSet.getString("g_cate"));
			goodsDto.setG_price(resultSet.getString("g_price"));
			goodsDto.setG_color(resultSet.getString("g_color"));
			goodsDto.setG_size(resultSet.getString("g_size"));
			goodsDto.setG_date(resultSet.getString("g_date"));
			goodsDto.setG_desc(resultSet.getString("g_desc"));
		}
		
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
		return goodsDto;
	}
	
	//06_08 상품검색 조회 메서드 선언
	public ArrayList<GoodsDto> goodsSearchList(String searchKey, String searchValue) throws SQLException {
		System.out.println("06_06 goodsSearchList GoodsDao.java");
		
		ArrayList<GoodsDto> arrayListGoodsDto = new ArrayList<GoodsDto>();
		
		connection = dataSource.getConnection();
		
		if(searchKey == null & searchValue == null){
			System.out.println("01조건_searchKey null searchValue null");
			preparedStatement = connection.prepareStatement("SELECT g_code, u_id, g_name, g_cate, g_price, g_color, g_size, g_date, g_desc FROM tb_goods");
		
		}else if(searchKey != null & searchValue.equals("")){
			System.out.println("02조건_searchKey 있고 searchValue 공백");
			preparedStatement = connection.prepareStatement("SELECT g_code, u_id, g_name, g_cate, g_price, g_color, g_size, g_date, g_desc FROM tb_goods");
		
		}else if(searchKey != null & searchValue != null){
			System.out.println("03조건_둘다 값이 있다");
			preparedStatement = connection.prepareStatement("SELECT g_code, u_id, g_name, g_cate, g_price, g_color, g_size, g_date, g_desc FROM tb_goods WHERE "+searchKey+"= ?");
			preparedStatement.setString(1, searchValue);
		}
		
		resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			GoodsDto goodsDto = new GoodsDto();
			goodsDto.setG_code(resultSet.getString("g_code"));
			goodsDto.setU_id(resultSet.getString("u_id"));
			goodsDto.setG_name(resultSet.getString("g_name"));
			goodsDto.setG_cate(resultSet.getString("g_cate"));
			goodsDto.setG_price(resultSet.getString("g_price"));
			goodsDto.setG_color(resultSet.getString("g_color"));
			goodsDto.setG_size(resultSet.getString("g_size"));
			goodsDto.setG_date(resultSet.getString("g_date"));
			goodsDto.setG_desc(resultSet.getString("g_desc"));
			arrayListGoodsDto.add(goodsDto);
		}
		
		resultSet.close();
		preparedStatement.close();
		connection.close();
		
		return arrayListGoodsDto;
	}
}