<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul>
	<c:choose>
		<c:when test="${param.type=='main' }">
			<li class="selected"><a href="/Day12_MySite/index">나가람</a></li>
			<li><a href="/Day12_MySite/guestbook">방명록</a></li>
			<li><a href="/Day12_MySite/board/list">게시판</a></li>
		</c:when>
		<c:when test="${param.type=='guestbook' }">
			<li><a href="/Day12_MySite/index">나가람</a></li>
			<li class="selected"><a href="/Day12_MySite/guestbook">방명록</a></li>
			<li><a href="/Day12_MySite/board/list">게시판</a></li>
		</c:when>
		<c:when test="${param.type=='board' }">
			<li><a href="/Day12_MySite/index">나가람</a></li>
			<li><a href="/Day12_MySite/guestbook">방명록</a></li>
			<li class="selected"><a href="/Day12_MySite/board/list">게시판</a></li>
		</c:when>
		<c:otherwise>
			<li><a href="/Day12_MySite/index">나가람</a></li>
			<li><a href="/Day12_MySite/guestbook">방명록</a></li>
			<li><a href="/Day12_MySite/board/list">게시판</a></li>
		</c:otherwise>
	</c:choose>
</ul>