<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "kr.or.ksmart.dto.GoodsDto"%>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>상품정보수정</title>
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
			
	<%
		GoodsDto goodsDto = (GoodsDto)request.getAttribute("goodsDto");
	%>
	
			<!-- Begin Right Column -->
			<div id="rightcolumn">
				<h1>상품정보수정</h1>
				<form action = "<%=request.getContextPath()%>/GoodsUpdate/goodsUpdatePro.hhm2" method = "post">
					<table border = "1">
						<tr>
							<td>상품코드</td>
							<td><input type = "text" name = "g_code" size = "20" value = "<%=goodsDto.getG_code()%>" readonly></td>
						<tr>
						<tr>
							<td>아이디</td>
							<td><input type = "text" name = "u_id" size = "20" value = "<%=goodsDto.getU_id()%>" readonly></td>
						<tr>
						<tr>
							<td>상품명</td>
							<td><input type = "text" name = "g_name" size = "20" value = "<%=goodsDto.getG_name()%>"></td>
						<tr>
						<tr>
							<td>카테고리</td>
							<td><input type = "text" name="g_cate" size = "20" value = "<%=goodsDto.getG_cate()%>"></td>
						<tr>
						<tr>
							<td>가격</td>
							<td><input type = "text" name = "g_price" size = "20" value= "<%=goodsDto.getG_price()%>"></td>
						<tr>
						<tr>
							<td>색상</td>
							<td><input type = "text" name = "g_color" size = "20" value = "<%=goodsDto.getG_color()%>"></td>
						<tr>
						<tr>
							<td>사이즈</td>
							<td><input type = "text" name = "g_size" size = "20" value = "<%=goodsDto.getG_size()%>"></td>
						<tr>
						<tr>
							<td>날짜</td>
							<td><input type = "text" name = "g_date" size = "20" value = "<%=goodsDto.getG_date()%>" readonly></td>
						<tr>
						<tr>
							<td>상세설명</td>
							<td><input type = "text" name = "g_desc" size = "20" value = "<%=goodsDto.getG_desc()%>"></td>
						<tr>
						<tr>
							<td colspan = "4"><input type = "submit" value = "상품정보수정"></td>
						</tr>
					</table>
				</form>
			</div>
			<!-- End Right Column -->
			
			<!-- Begin hadan -->
			<%@include file = "/module/hadan.jsp"%>
			<!-- End hadan -->
			
		</div>
		<!-- End Wrapper -->
	</body>
</html>