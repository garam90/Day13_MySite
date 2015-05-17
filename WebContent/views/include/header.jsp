<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<h1 onclick="location.href=/Day05_MySite/">GARAM</h1>
	<ul>
		<c:choose>
			<c:when test="${not empty sessionScope.name }">
				<li><a href="/Day05_MySite/user?a=uinfo">MYPAGE</a><li>
				<li><a href="/Day05_MySite/user?a=logout">LOGOUT</a><li>
				<li class="msg">HELLO ${sessionScope.name} :)</li>
			</c:when>
			<c:otherwise>
				<li><a href="/Day05_MySite/user?a=loginform">LOGIN</a><li>
				<li><a href="/Day05_MySite/user?a=joinform">JOIN</a><li>
			</c:otherwise>
		</c:choose>
	</ul>