<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="ua.company.web.controller.*" %>
<jsp:include page="header.jsp"/>

	<div id="page">
		<div id="content">
			<div id="main">

				<form action="Testing" method="post">
					<button type="submit" name="command" value="admin">Get report</button>
				</form>
			<br/>
			<br/>
			<c:choose>
				<c:when test="${resultByLogin eq null}">
				</c:when>
			<c:otherwise>
			<!--<form action="Testing" method="post">!-->
				
				<style>
				table {
				table-layout: fixed;
				width: 100%;
				}</style>
				<table border='1' >
				<tr>
					<td>
						<h2>Student</h2>
					</td>
					<td>
						<h2>Score</h2>
					</td>
				</tr>
				
				<c:forEach items="${resultByLogin}" var="test" >
				<tr>
					<td>
						<p>${test.key}</p>
					</td>
					<td>
						${test.value}
					</td>
				</tr>
				</c:forEach>		
				</table>
				
				<tr>
					<c:if test="${not empty errorPassMessage}">
						<c:out value="${errorPassMessage}"/>
					</c:if>
				</tr>
			<!--</form>!-->
			</c:otherwise>
			</c:choose>
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