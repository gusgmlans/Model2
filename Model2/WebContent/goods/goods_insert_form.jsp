<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>상품정보등록</title>
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
			<div id = "rightcolumn">
				<h1>상품등록</h1>
				<form action = "<%=request.getContextPath()%>/GoodsInsert/goodsInsertPro.hhm2" method = "post">
					<table border = "1">
						<input type = "hidden" name = "u_id" value = "<%=S_ID%>">
						<tr>
							<td>상품명</td>
							<td><input type = "text" name = "g_name" size = "20"></td>
						</tr>
						<tr>
							<td>카테고리</td>
							<td><input type = "text" name = "g_cate" size = "20"></td>
						</tr>
						<tr>
							<td>가격</td>
							<td><input type = "text" name = "g_price" size = "20"></td>
						</tr>
						<tr>
							<td>색상</td>
							<td><input type = "text" name = "g_color" size = "20"></td>
						</tr>
						<tr>
							<td>사이즈</td>
							<td><input type = "text" name = "g_size" size = "20"></td>
						</tr>
						<tr>
							<td>상세설명</td>
							<td><input type = "text" name = "g_desc" size = "20"></td>
						</tr>
						<tr>
							<td colspan = "4"><input type = "submit" value = "상품등록"></td>
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
