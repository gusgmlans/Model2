<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList"%>
<%@ page import = "kr.or.ksmart.dto.UserDto" %>

<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>회원검색</title>
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
			
				<h1>회원검색</h1>
				<form action = "<%=request.getContextPath()%>/UserSearch/userSearchList.hhm" method = "post">
					<select name = "searchKey">
						<option value = "u_id">아이디</option>
						<option value = "u_level">권한</option>
						<option value = "u_name">이름</option>
						<option value = "u_email">이메일</option>
						<option value = "u_phone">폰번호</option>
						<option value = "u_addr">주소</option>
					</select>
					<input type = "text" name = "searchValue">
					<input type = "submit" value = "검색">	
				</form>
				
				<h1>회원리스트</h1>
				<table border = "1">
					<tr>
						<td>아이디</td>
						<td>비밀번호</td>
						<td>권한</td>
						<td>이름</td>
						<td>이메일</td>
						<td>휴대전화</td>
						<td>주소</td>
						<td>수정</td>
						<td>삭제</td>
					</tr>
	<%		
		ArrayList<UserDto> arrayListUserDto = (ArrayList<UserDto>)request.getAttribute("arrayListUserDto");
		
		for(int i = 0; i < arrayListUserDto.size(); i++){
			UserDto userDto = arrayListUserDto.get(i);
	%>
					<tr>
						<td><a href = "<%=request.getContextPath()%>/UserDetail/userDetailPro.hhm?send_id=<%=userDto.getU_id()%>"><%=userDto.getU_id()%></a></td>
						<td><%=userDto.getU_pw()%></td>
						<td><%=userDto.getU_level()%></td>
						<td><%=userDto.getU_name()%></td>
						<td><%=userDto.getU_email()%></td>
						<td><%=userDto.getU_phone()%></td>
						<td><%=userDto.getU_addr()%></td>
						<td><a href = "<%=request.getContextPath()%>/UserUpdate/userUpdateForm.hhm?send_id=<%=userDto.getU_id()%>">수정</a></td>
						<td><a href = "<%=request.getContextPath()%>/UserDelete/userDeletePro.hhm?send_id=<%=userDto.getU_id()%>">삭제</a></td>
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