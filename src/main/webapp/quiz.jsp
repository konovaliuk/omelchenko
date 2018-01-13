<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="ua.company.web.controller.*" %>
<%@page import="java.util.HashMap,java.util.Iterator,java.util.Set,java.util.Map"%> 


<jsp:include page="header.jsp"/>

	<div id="page">
	
		<c:if test="${language eq null}">
		<fmt:setLocale value="en"/>
		</c:if>
		<c:if test="${language!=null}">
		<fmt:setLocale value="${language}"/>
		</c:if>
	
		<fmt:setBundle basename="locale" var="lang"/>
	
	
		<div id="content">
			<div id="main">

		<tr>
			<c:if test="${not empty errorPassMessage}">
				<c:out value="${errorPassMessage}"/>
			</c:if>
		</tr>

		<br/>
		<br/>
		
		<c:choose>
		<c:when test="${not empty score}" >
			<h2>
				<fmt:message key="quiz.result" bundle="${lang}"/> ${score} %
			</h2>
		</c:when>
		</c:choose>
		
		<c:choose>
		<c:when test="${not empty wrongAnswers}" >
			<p></p>
			<b>
				<fmt:message key="quiz.wronganswer" bundle="${lang}"/>
			</b>
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
		<c:when test="${start eq null}" >	
				<form action="Testing" method="post">
					<button type="submit" name="command" value="quiz">
						<fmt:message key="quiz.start" bundle="${lang}"/>
					</button>
				</form>
		</c:when>
		
		<c:otherwise>
				<form action="Testing" method="post">					
				<c:forEach items="${showQuiz}" var="test" >
				<table border='0'>
					<tr>
					<td>
						<b><p class="question">${test.key.questionText}</p></b>
					</td>
					</tr>
						<c:forEach items="${test.value}" var="answ" >
								<tr>
								<td>
									<input type="checkbox" name="userAnswer" value="${answ.answerId}"  ${(param.userAnswer eq "null")?'checked':'_'}/> ${answ.answerText}
								</td>
								</tr>
						</c:forEach>
				</table>
				<br/>
				<br/>
				</c:forEach>					
					
					<button type="submit" name="command" value="answer">
						<fmt:message key="quiz.finish" bundle="${lang}"/>
					</button>
				</form>
				<br/>
		</c:otherwise>
		</c:choose>
		
		<br/>
		
		</div>
		</div>
		
		<jsp:include page="sidebar.jsp"/>
		
	</div>
	
<jsp:include page="footer.jsp"/>