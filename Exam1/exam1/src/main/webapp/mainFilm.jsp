<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html  charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/mainFilm.css">
<title>电影</title>
</head>

<body>
	<div id="title">
		<a id="movie">电影列表</a>
		&nbsp;
		<a id="addFilmButton" href="<%=request.getContextPath()%>/GetLanguageServlet">新增电影</a>
	</div>
	<%
		List<Map<?, ?>> lists = (List<Map<?, ?>>) session.getAttribute("lists");
	%>
	<div>
		<table width=100% height="100" border="2" cellpadding="0" cellspacing="0" class="tb">

			<tr>
				<td>film_id</td>
				<td>title</td>
				<td>description</td>
				<td>language</td>
			</tr>

			<%
				for (int i = 0; i < lists.size(); i++) {
			%>
			<tr>
				<td><%=lists.get(i).get("film_id")%></td>
				<td><%=lists.get(i).get("title")%></td>
				<td><%=lists.get(i).get("description")%></td>
				<td><%=lists.get(i).get("name")%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>


</body>
</html>
