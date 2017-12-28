<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="ua.company.web.controller.*" %>
<jsp:include page="header.jsp"/>

	<div id="page">
		
		<div id="content">
			
			<c:set var="name" value="Гость." />
			<c:choose>
				<c:when test="${user.access}" >
					<c:set var="name" value="${user.login}" />
					<c:set var="form" value="false" />
					<br/>
					<form action="Testing" method='post'>
					<input type='hidden' name='logout'>
					<input type='submit' name='command' value='logout'>
					</form>
				</c:when>
				<c:otherwise>
					<c:set var="form" value="true" />
				</c:otherwise>	
			</c:choose>
	
	hi ${user.login}
	access is ${user.access}
	<c:out value="Form eq ${form}" />
		
			<c:choose>
				<c:when test="${form eq 'true'}">
	
					<form id="loginForm" action="Testing" method="post">
						<div class="field">
						<label>Enter your login:</label>
						<div class="input"><input type="text" name="login" value="${param.login eq 'null'?'':param.login}" ></div>
						</div>

						<div class="field">
						<br/>
						<br/>
						<label>Enter your password:</label>
						<div class="input"><input type="password" name="password"></div>
						</div>

						<div class="submit">
						<br/>
						<br/>
						<!--<button type="submit" name="submit" value="Sign In">Enter</button>!-->
						<!--<input type="hidden" name="command" value="login">Enter!-->
						<button type="submit" name="command" value="login">Enter</button>
						
						</div>
						<br/>
						<br/>	
					</form>

					<form>
						<td> 
			
						<c:if test="${!(validator.loginMessage eq 'null')}">
							<c:forEach var="errorMessage" items="${validator.loginMessage}">	
								<c:out value="${errorMessage}"/>
							<br/>
							</c:forEach>
						</c:if>				

						<c:if test="${not empty validator.passwordMessage}">
							<c:forEach var="errorMessage" items="${validator.passwordMessage}">	
								<c:out value="${errorMessage}"/>
							<br/>
							</c:forEach>
						</c:if>	
			
						<c:if test="${not empty errorPassMessage}">
						<c:out value="${errorPassMessage}"/>
						</c:if>	
			
						</td> 
					</form>

				</c:when>
			</c:choose>
		</div>
		
		<div id="sidebar">
			<ul>
				<li>
					<h2>Subject </h2>
					<ul>
						<li><a href="test.jsp?subject_id=1">Classes, methods, types </a></li>
						<li><a href="test.jsp?subject_id=2">Collections </a></li>
						<li><a href="test.jsp?subject_id=3">Nested/Inner classes </a></li>
						<li><a href="test.jsp?subject_id=4">Exceptions </a></li>
					</ul>
				</li>
			</ul>
		</div>
		<div style="clear: both;">&nbsp;</div>
	</div>
	
<jsp:include page="footer.jsp"/>