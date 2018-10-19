<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList"%>
<%@ page import = "kr.or.ksmart.dto.GoodsDto"%>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>상품검색</title>
		<link rel = "stylesheet" type = "text/css" href = "<%=request.getContextPath()%>/css/main.css">
	</head>
	<body>
		<!-- Begin Wrapper -->
		<div id="wrapper">
		
			<!-- Begin top -->
			<%@include file = "/module/top.jsp"%>
			<!-- End top -->
			
			<!-- Begin left -->
			<%@include file = "/module/left.jsp"%>
			<!-- End left -->
			
			<!-- Begin Right Column -->
			<div id="rightcolumn">
			
			<h1>상품검색</h1>
				<form action = "<%=request.getContextPath()%>/GoodsSearchList/goodsSearchList.hhm2" method = "post">
					<select name = "searchKey">
						<option value = "g_code">상품코드</option>
						<option value = "u_id">아이디</option>
						<option value = "g_name">상품명</option>
						<option value = "g_cate">카테고리</option>
						<option value = "g_price">가격</option>
						<option value = "g_color">색상</option>
						<option value = "g_size">사이즈</option>
						<option value = "g_date">날짜</option>
						<option value = "g_desc">상세설명</option>
					</select>
					<input type = "text" name = "searchValue">
					<input type = "submit" value = "상품검색">
				</form>
				
				<h1>상품리스트</h1>
				<table border = "1">
					<tr>
						<td>상품코드</td>
						<td>아이디</td>
						<td>상품명</td>
						<td>카테고리</td>
						<td>가격</td>
						<td>색상</td>
						<td>사이즈</td>
						<td>날짜</td>
						<td>상세설명</td>
						<td>수정</td>
						<td>삭제</td>
					</tr>
	<%
		ArrayList<GoodsDto> arrayListGoodsDto = (ArrayList<GoodsDto>)request.getAttribute("arrayListGoodsDto");
		
		for(int i = 0; i < arrayListGoodsDto.size(); i++){
			GoodsDto goodsDto = arrayListGoodsDto.get(i);
	%>
					<tr>
						<td><a href = "<%=request.getContextPath()%>/GoodsDetail/goodsDetailPro.hhm2?send_g_code=<%=goodsDto.getG_code()%>"><%=goodsDto.getG_code()%></a></td>
						<td><%=goodsDto.getU_id()%></td>
						<td><%=goodsDto.getG_name()%></td>
						<td><%=goodsDto.getG_cate()%></td>
						<td><%=goodsDto.getG_price()%></td>
						<td><%=goodsDto.getG_color()%></td>
						<td><%=goodsDto.getG_size()%></td>
						<td><%=goodsDto.getG_date()%></td>
						<td><%=goodsDto.getG_desc()%></td>
						<td><a href = "<%= request.getContextPath()%>/GoodsUpdate/goodsUpdateForm.hhm2?send_g_code=<%=goodsDto.getG_code()%>">수정</a></td>
						<td><a href = "<%= request.getContextPath()%>/GoodsDelete/goodsDeletePro.hhm2?send_g_code=<%=goodsDto.getG_code()%>">삭제</a></td>
					</tr>
	<%	
		}
	%>
				</table>
			</div>
			<!-- End Right Column -->
			
			<!-- Begin hadan -->
			<%@include file = "/module/hadan.jsp"%>
			<!-- End hadan -->
			
		</div>
		<!-- End Wrapper -->
	</body>
</html>