<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/Day05_MySite/assets/css/user.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/views/include/header.jsp"/>
		</div>
		<div id="content">
			<h1 class="pageTitle">UPDATE INFO</h1>
			<div id="user">

				<form id="join-form" method="post"
					action="/Day05_MySite/user?a=update">
					<label class="block-label" for="name">NAME</label> <input id="name"
						name="name" type="text" value=""> <label
						class="block-label">PASSWORD</label> 
						<input name="password" type="password" value=""> 
						<input type="submit" value="UPDATE">
				</form>
			</div>
		</div>
		<div id="navigation">
			<c:import url="/views/include/navigation.jsp">
				<c:param name="type" value="main"></c:param>
			</c:import>
		</div>
		<div id="footer">
			<c:import url="/views/include/footer.jsp" />
		</div>
	</div>
</body>
</html>