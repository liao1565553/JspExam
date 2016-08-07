<%@ page language="java" pageEncoding="UTF-8"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html  charset=utf-8">
<title>新增电影</title>
<link rel="stylesheet" type="text/css" href="css/addFilm.css">
</head>

<body>
	<div id="add">
		<h1>新增电影</h1>
	</div>
	<%
		List<Map<?, ?>> languageList = (List<Map<?, ?>>) session.getAttribute("languageList");
	%>

	<div class="addFilmForm">
		<form action="">
			<a>title</a>
			<input type="text" name="title">
			<a>description</a>
			<input type="text" name="description">
			<a>language</a>
			<select id="language" name="language">
				<%
					for (int i = 0; i < languageList.size(); i++) {
				%>
				<option value="<%=languageList.get(i).get("name")%>"><%=languageList.get(i).get("name")%></option>
				<%
					}
				%>
			</select>
			<br>
			<button class="addButton">添加</button>
		</form>
	</div>



</body>
</html>
