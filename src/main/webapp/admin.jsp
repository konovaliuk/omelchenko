<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="ua.company.web.controller.*" %>
<jsp:include page="header.jsp"/>

	<div id="page">
		<div id="content">
			<div id="main">

				<form action="Testing" method="post">
					<button type="submit" name="command" value="result">Start Quiz</button>
				</form>
				
			<c:choose>
				<c:when test="${result eq null}">
				</c:when>
			<c:otherwise>
			<!--<form action="Testing" method="post">!-->
				<c:forEach items="${result}" var="test" >
				<table border='1'>
					<tr>
					<td>
						<b><p>${result.login}</p></b>
					</td>
					<td>
						<b>${result.testName}</b>
					</td>
					<td>
						<b>${result.subjectName}</b>
					</td>
					<td>
						<b>${result.score}</b>
					</td>
					</tr>
				</table>
				</c:forEach>		
				<tr>
					<c:if test="${not empty errorPassMessage}">
						<c:out value="${errorPassMessage}"/>
					</c:if>
				</tr>
			<!--</form>!-->
			</c:otherwise>
		
	</div>
		</div>
		<div id="sidebar">
			<ul>
				<li>
					<h2>Subject </h2>
					<ul>
						<li><a href="quiz.jsp?subject_id=1">Classes, methods, types </a></li>
						<li><a href="quiz.jsp?subject_id=2">Collections </a></li>
						<li><a href="quiz.jsp?subject_id=3">Nested/Inner classes </a></li>
						<li><a href="quiz.jsp?subject_id=4">Exceptions </a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div style="clear: both;">&nbsp;</div>
	</div>
	
<jsp:include page="footer.jsp"/>