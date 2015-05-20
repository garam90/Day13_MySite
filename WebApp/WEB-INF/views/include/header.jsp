<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<h1 onclick="location.href=/Day12_MySite/index">GARAM</h1>
	<ul>
		<c:choose>
			<c:when test="${not empty sessionScope.name }">
				<li><a href="/Day12_MySite/user/uinfo">MYPAGE</a><li>
				<li><a href="/Day12_MySite/user/logout">LOGOUT</a><li>
				<li class="msg">HELLO ${sessionScope.name} :)</li>
			</c:when>
			<c:otherwise>
				<li><a href="/Day12_MySite/user/login">LOGIN</a><li>
				<li><a href="/Day12_MySite/user/join">JOIN</a><li>
			</c:otherwise>
		</c:choose>
	</ul>	