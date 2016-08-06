<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html  charset=utf-8">
<title>首页</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>

<body>
	<div id="toppage">首页</div>

	<div id="tomain">
		<a href="<%=request.getContextPath()%>/showFilmServlet">电影</a>
	</div>
	<%
		String flag = "";
		Object obj = session.getAttribute("flag");
		if (obj != null) {
			flag = obj.toString();
		}
		if (flag.equals("login_success")) {
	%>
	<div id="logout">
		<a href="<%=request.getContextPath()%>/logoutServlet">退出</a>
	</div>
	<%
		} else {
	%>
	<div id="login">
		<a href="login.jsp">登录</a>
	</div>
	<%
		}
	%>

</body>
</html>
