<%@ page language="java" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html  charset=utf-8">
<title>登录</title>
<link rel="stylesheet" type="text/css" href="css/login.css">
</head>

<body>
<body>
	<div id="backtoindex">
		<a href="index.jsp">返回首页</a>
	</div>
	<form action="<%=request.getContextPath()%>/loginServlet" method="post">

		<div class="login_putin">
			<ul>
				<li>
					FristName
					<input type="text" name="fristname">
				</li>
			</ul>
		</div>
		<div class="login_btn">
			<input type="submit" value="登陆">
		</div>
	</form>

</body>
</html>
