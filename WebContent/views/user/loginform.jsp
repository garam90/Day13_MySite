<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/Day05_MySite/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/views/include/header.jsp"/>
		</div>
		<div id="content">
			<div id="user">
				<form id="login-form" name="loginform" method="post" action="/Day05_MySite/user?a=login">
					<label class="block-label" for="email">EMAIL</label>
					<input id="email" name="email" type="text" value="">
					<label class="block-label" >PASSWORD</label>
					<input name="password" type="password" value="">
					<p>
						${requestScope.msg }
					</p>
					<input type="submit" value="LOGIN">
				</form>
			</div>
		</div>
		<div id="navigation">
			<c:import url="/views/include/navigation.jsp">
				<c:param name="type" value="main"></c:param>
			</c:import>
		</div>
		<div id="footer">
			<c:import url="/views/include/footer.jsp"/>
		</div>
	</div>
</body>
</html>