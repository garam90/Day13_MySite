<%@page import="com.sds.icto.mysite.vo.GuestBookVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<title>MySite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/Day12_MySite/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/WEB-INF/views/include/header.jsp" />
		</div>
		<div id="content">
			<h1 class="pageTitle">GUESTBOOK</h1>
			<div id="guestbook">
				<form action="/Day12_MySite/guestbook/insert" method="post">
					<table border=1 width=500 class="form">
						<tr>
							<td class="label">이름</td>
							<td><input type="text" name="name" value="${sessionScope.name }"></td>
							<td  class="label">비밀번호</td>
							<td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="content" cols=60 rows=5 wrap="hard"></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit" VALUE=" OK "></td>
						</tr>
					</table>
				</form>
				<ul>
					<li>
	<c:forEach items="${requestScope.list }" var="guest" varStatus="status">
		<table width=510 border=1 class="list">
			<tr>
				<td id="list_count">[${status.count}]</td>
				<td id="list_name">${guest.name }</td>
				<td id="list_date">${guest.reg_date }</td>
				<td id="list_delete"><a href="/Day12_MySite/guestbook/deleteform?no=${guest.no }">DELETE</a></td>
			</tr>
			<tr>
				<td colspan=4 id="guestbook_msg"><pre>${guest.message }</pre></td>
			</tr>
		</table>
	<br>
	</c:forEach>
					</li>
				</ul>
			</div>
		</div>
		<div id="navigation">
			<c:import url="/WEB-INF/views/include/navigation.jsp">
				<c:param name="type" value="guestbook"></c:param>
			</c:import>
		</div>
		<div id="footer">
			<p>(c)opyright 2014</p>
		</div>
	</div>
</body>
</html>