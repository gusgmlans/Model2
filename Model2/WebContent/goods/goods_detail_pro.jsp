<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "kr.or.ksmart.dto.GoodsDto"%>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>상품상세정보</title>
		<link rel = "stylesheet" type = "text/css" href="<%=request.getContextPath()%>/css/main.css">
	</head>
	<body>
	<%
		GoodsDto goodsDto = (GoodsDto)request.getAttribute("goodsDto");
	%>
		<!-- Begin Wrapper -->
		<div id="wrapper">
		
			<!-- Begin top -->
			<%@include file = "/module/top.jsp"%>
			<!-- End top -->
			
			<!-- Begin left -->
			<%@include file = "/module/left.jsp"%>
			<!-- End left -->
			
			<!-- Begin Right Column -->
			<div id = "rightcolumn">
				<h1>상품상세정보</h1>
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
					<tr>
						<td><%=goodsDto.getG_code()%></td>
						<td><%=goodsDto.getU_id()%></td>
						<td><%=goodsDto.getG_name()%></td>
						<td><%=goodsDto.getG_cate()%></td>
						<td><%=goodsDto.getG_price()%></td>
						<td><%=goodsDto.getG_color()%></td>
						<td><%=goodsDto.getG_size()%></td>
						<td><%=goodsDto.getG_date()%></td>
						<td><%=goodsDto.getG_desc()%></td>
						<td><a href="<%= request.getContextPath()%>/GoodsUpdate/goodsUpdateForm.hhm2?send_g_code=<%=goodsDto.getG_code()%>">수정</a></td>
						<td><a href="<%= request.getContextPath()%>/GoodsDelete/goodsDeletePro.hhm2?send_g_code=<%=goodsDto.getG_code()%>">삭제</a></td>
					</tr>
				</table>
				<input type = "button" value = "돌아가기" onClick = "location.href = '<%=request.getContextPath()%>/GoodsSearchList/goodsSearchList.hhm2'">
			</div>
			<!-- End Right Column -->
			
			<!-- Begin hadan -->
			<%@include file = "/module/hadan.jsp"%>
			<!-- End hadan -->
			
		</div>
		<!-- End Wrapper -->
	</body>
</html>