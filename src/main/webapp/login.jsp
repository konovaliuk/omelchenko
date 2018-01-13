<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="a" uri="/WEB-INF/access.tld" %>
<%@page import="ua.company.web.controller.*" %>
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
			
			<c:choose>
				<c:when test="${user.access}" >
					<c:set var="name" value="${user.login}" />
					<c:set var="form" value="false" />
					<br/>
					<form action="Testing" method='post'>
						<button type="submit" name="command" value="logout">
							<fmt:message key="login.logout" bundle="${lang}"/>
						</button>
					</form>
				</c:when>
			</c:choose>	
				
				<a:acc>
					<c:set var="form" value="true" />
				</a:acc>
			
	
	<!--hi ${user.login}
	access is ${user.access}
	<c:out value="Form eq ${form}" />!-->
		
			<c:choose>
				<c:when test="${form eq 'true'}">
	
					
					<form id="loginForm" action="Testing" method="post">
					<table border='0'>
					<tr>
					<td>
						<div class="field">
						<label>
							<fmt:message key="login.login" bundle="${lang}"/>
						</label>
						<div class="input"><input type="text" name="login" value="${param.login eq 'null'?'':param.login}" ></div>
						</div>
					</td>
					<td>
						<c:if test="${!(validator.loginMessage eq 'null')}">
							<c:forEach var="errorMessage" items="${validator.loginMessage}">	
								<c:out value="${errorMessage}"/>
							<br/>
							</c:forEach>
						</c:if>				
					</td>
					</tr>
					</table>
					
					<table border='0'>
					<tr>
					<td>
						<div class="field">
						<br/>
						<br/>
						<label>
							<fmt:message key="login.password" bundle="${lang}"/>
						</label>
						<div class="input"><input type="password" name="password"></div>
						</div>
					</td>
					<td>
						<c:if test="${not empty validator.passwordMessage}">
							<c:forEach var="errorMessage" items="${validator.passwordMessage}">	
								<c:out value="${errorMessage}"/>
							<br/>
							</c:forEach>
						</c:if>	
					
					</td>
					</tr>
					</table>

						<div class="submit">
						<br/>
						<br/>
						<button type="submit" name="command" value="login">
							<fmt:message key="login.enter" bundle="${lang}"/>
						</button>
						
						</div>
					
						<br/>
						<br/>	
					</form>

					<form>
						<td> 
						<c:if test="${not empty errorPassMessage}">
						<c:out value="${errorPassMessage}"/>
						</c:if>	
			
						</td> 
					</form>

				</c:when>
			</c:choose>
		</div>
		
		<jsp:include page="sidebar.jsp"/>
		
	</div>
	
<jsp:include page="footer.jsp"/>