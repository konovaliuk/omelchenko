<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="ua.company.web.controller.*" %>
<jsp:include page="header.jsp"/>

	<div id="page">
		<div id="content">
			<div id="main">

			<table border='0' >
				<tr>
					<td width="60%">
				
				<form action="Testing" method="post">
					<button type="submit" name="command" value="admin">Report "Students Score"</button>
				</form>
			
				<br/>
				<br/>
					</td>
					<td width="60%">
				<form action="Testing" method="post">
					<button type="submit" name="command" value="startCreateTest">Create new test</button>
				</form>
				
			<br/>
			<br/>
					</td>
				</tr>
			</table>
			
			<c:choose>
				<c:when test="${resultByLogin eq null}">
				</c:when>
			<c:otherwise>
				
				Report "Students Score"
			<br/>
			<br/>
				
				<table border='1' >
				<tr>
					<td width="80%">
						<h2>Student</h2>
					</td>
					<td width="20%">
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
				
				<table>
				 <tr>
					<td>
						<form method="get" action="Testing">
						<table>
							<tr>
							<c:forEach items="${pages}" var="pageNumber" >
								<td><a href="Testing?command=admin&pageNumber=${pageNumber}">${pageNumber}</a></td>
							</c:forEach>		
							</tr>
						</table>
						</form>
					</td>
				</tr>
				</table>
				
				
				
				<tr>
					<c:if test="${not empty errorPassMessage}">
						<c:out value="${errorPassMessage}"/>
					</c:if>
				</tr>
			
			</c:otherwise>
			</c:choose>
	</div>
		</div>
		
		<jsp:include page="sidebar.jsp"/>
		
	</div>
	
<jsp:include page="footer.jsp"/>