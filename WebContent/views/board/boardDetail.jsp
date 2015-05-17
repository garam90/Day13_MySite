<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="/Day05_MySite/assets/css/guestbook.css" rel="stylesheet" type="text/css">
<link href="/Day05_MySite/assets/css/board.css" rel="stylesheet" type="text/css">
<title>게시판</title>
</head>
<body>
	<div id="container">
		<div id="header">
			<c:import url="/views/include/header.jsp"/>
		</div>
		<div id="content">
		<h1 class="pageTitle">BOARD</h1>
			<div id="board">
				<table class="boardTable">
					<tr>
						<td colspan="4" class="aTag">
							<a href="/Day05_MySite/board" class="left">LIST</a>
							<%-- <a href="/Day05_MySite/board?action=detail&no=${requestScope.board.no+1 }" class="right">NEXT</a>
							<span class="right">&nbsp;&nbsp;|&nbsp;&nbsp; </span>
							<a href="/Day05_MySite/board?action=detail&no=${requestScope.board.no-1 }" class="right">PREV</a> --%>
						</td>
					</tr>
					<tr class="tableHead">
						<td colspan="4">${requestScope.board.title }</td>
					</tr>				
					<tr>
						<th>작성자</th>
						<td>${requestScope.board.userId }</td>
						<th>작성날짜</th>
						<td>${requestScope.board.reg_date }</td>
					</tr>
					<tr>
						<td colspan="4" class="detail_content"><pre>${requestScope.board.content }</pre></td>
					</tr>
					<c:if test="${sessionScope.email == requestScope.board.userId }">
					<tr>
						<td colspan="4" class="btn">
							<input type="button" onclick="location.href='/Day05_MySite/board?action=delete&no=${requestScope.board.no }'" value="DELETE">
							&nbsp;&nbsp;&nbsp;
							<input type="button" onclick="location.href='/Day05_MySite/board?action=updateform&no=${requestScope.board.no }'" value="UPDATE">
						</td>
					</tr>
					</c:if>
				</table>
			</div>
		</div>
		<div id="navigation">
			<c:import url="/views/include/navigation.jsp">
				<c:param name="type" value="board"></c:param>
			</c:import>
		</div>
		<div id="footer">
			<c:import url="/views/include/footer.jsp"/>
		</div>
	</div>
</body>
</html>