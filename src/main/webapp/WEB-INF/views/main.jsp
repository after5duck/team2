<%@page import="com.kh.main.MainDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kh.main.MainDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	request.setCharacterEncoding("utf-8");

	MainDAO m = new MainDAO();
	ArrayList<MainDTO> mdtoList = m.getImgList();

	m.getConnection();
	%>

	<%
	for (MainDTO mdto : mdtoList) {
	%>
	<div class="mini_con">

		<div id="photo">
			<img src="../resources/images/photo_1.webp" alt="photo_1">
		</div>
		<div id="photo_text"></div>


	</div>
	<%
	}
	%>


</body>
</html>