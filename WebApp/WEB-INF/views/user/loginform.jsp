<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/Day12_MySite/assets/css/user.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/header.jsp"/>
		</div>
		<div id="content">
			<div id="user">
				<form id="login-form" name="loginform" method="post" action="/Day12_MySite/user/login">
					<label class="block-label" for="email">EMAIL</label>
					<input id="email" name="email" type="text" value="">
					<label class="block-label" >PASSWORD</label>
					<input name="password" type="password" value="">
					<c:if test="${param.result=='fail' }">
					<p>
						로그인 실패ㅋ
					</p>
					</c:if>
					<input type="submit" value="LOGIN">
				</form>
			</div>
		</div>
		<div id="navigation">
			<c:import url="/WEB-INF/views/include/navigation.jsp">
				<c:param name="type" value="main"></c:param>
			</c:import>
		</div>
		<div id="footer">
			<c:import url="/WEB-INF/views/include/footer.jsp"/>
		</div>
	</div>
</body>
</html>