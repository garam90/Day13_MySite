<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<c:import url="/views/include/header.jsp" />
		</div>
		<div id="content">
			<div id="boardlist">
				<div id="boardinput">
					<form action="/Day05_MySite/board?action=update" method="post">
					<input type="hidden" name="no" value="${requestScope.board.no }">
					<table class="boardTable">
						<tr>
							<td><a href="/Day05_MySite/board">LIST</a></td>
						</tr>
						<tr>
							<th>TITLE</th>
							<td><input type="text" name="title" value="${requestScope.board.title }" size="68"></td>
						</tr>
						<tr>
							<th>content</th>
							<td>
								<textarea rows="25" cols="70" name="content">
									${requestScope.board.content }
								</textarea>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<div class="btn">
									<input type="submit" value="수정">
								</div>
							</td>
						</tr>
					</table>
					</form>
				</div>
			</div>
		</div>
		<div id="navigation">
			<c:import url="/views/include/navigation.jsp">
				<c:param name="type" value="board"></c:param>
			</c:import>
		</div>
		<div id="footer">
			<c:import url="/views/include/footer.jsp" />
		</div>
	</div>
</body>
</html>