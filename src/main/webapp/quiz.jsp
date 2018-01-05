<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="ua.company.web.controller.*" %>
<%@page import="java.util.HashMap,java.util.Iterator,java.util.Set,java.util.Map"%> 

<jsp:include page="header.jsp"/>

	<div id="page">
		<div id="content">
			<div id="main">

		<tr>
			<c:if test="${not empty errorPassMessage}">
				<c:out value="${errorPassMessage}"/>
			</c:if>
		</tr>

		
		<c:choose>
		<c:when test="${not empty score}" >
			<h2>The result is ${score} %</h2>
		</c:when>
		</c:choose>
		
		<c:choose>
		<c:when test="${not empty wrongAnswers}" >
			<p></p>
			<b>Wrong answers were received for following questions:</b>
			<p></p>
			<c:forEach items="${wrongAnswers}" var="wrongAnswer" >
				${wrongAnswer.questionText}
			<p></p>
			</c:forEach>	
			<br/>
			<br/>
		</c:when>
		</c:choose>
			
		<c:choose>
		<c:when test="${test eq null}" >
				
				<form action="Testing" method="post">
					<button type="submit" name="command" value="quiz">Start Quiz</button>
				</form>
		</c:when>
		<c:otherwise>
				<form action="Testing" method="post">					
				<c:forEach items="${quiz}" var="test" >
				<table border='0'>
					<tr>
					<td>
						<b><p class="question">${test.key.questionText}</p></b>
					</td>
					</tr>
						<!--<table border='0'>!-->
						<c:forEach items="${test.value}" var="answ" >
								<tr>
								<td>
									<input type="checkbox" name="userAnswer" value="${answ.answerId}"  ${(param.userAnswer eq "null")?'checked':'_'}/> ${answ.answerText}
								</td>
								</tr>
						</c:forEach>
						<!--</table>!-->
				</table>
				<br/>
				<br/>
				</c:forEach>					
					
					<button type="submit" name="command" value="answer">Finish Quiz</button>
				</form>
				<br/>
		</c:otherwise>
		</c:choose>
		
		<br/>
		
		
		
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