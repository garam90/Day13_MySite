<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<title>Garam's Site</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/Day05_MySite/assets/css/main.css" rel="stylesheet" type="text/css">
<link href="/Day05_MySite/assets/css/mysite.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/views/include/header.jsp"/>
		</div>
		<div id="wrapper">
			<div id="content">
				<div id="site-introduction">
					<img id="profile" src="/Day05_MySite/assets/images/Koala.jpg" width="400px">
					<h2>Garam's MySite : ) </h2>
					<p>
						2015년 5월 28일까지 역량강화교육기간 입니다.<br>
						<br>
						회원가입을 할 수 있고,<br>
						로그인을 하면 게시글을 작성할 수 있습니다.<br>
						비회원도 게시글을 보고, 방명록을 작성할 수 있습니다 :)<br>
						점차 기능적으로 업데이트 될 예정입니다.<br>
						<br><br>
						<a href="/Day05_MySite/guest">방명록</a>에 글 남기기<br>
					</p>
				</div>
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