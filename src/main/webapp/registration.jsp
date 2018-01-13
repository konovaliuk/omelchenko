<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			<div id="main">

	
	<table border='0'>
	<form id="registrationForm" action="Testing" method="post">
		<tr>
		</tr>
		<tr>
			<td> 
				<fmt:message key="reg.login" bundle="${lang}"/>
			</td> 
			<td> 
				<div class="input"><input type="text" name="login" value="${param.login eq 'null'?'':param.login}" ></div>
			</td> 
			<td> 
				<c:if test="${!(validator.loginMessage eq 'null')}">
				<c:forEach var="errorMessage" items="${validator.loginMessage}">	
					<c:out value="${errorMessage}"/>
				</c:forEach>
				</c:if>		
			</td> 
		</tr>
		
		
		<tr>
			<td> 
				<fmt:message key="reg.password" bundle="${lang}"/>
			</td>
			<td> 
				<c:choose>
					<c:when test="${not empty password}">
						<input type='password' name='password' value="${password}"/>
					</c:when>
					<c:otherwise>
						<input type='password' name='password' value=''/>
					</c:otherwise>
				</c:choose>
			</td>
			<td> 
				<c:if test="${not empty validator.passwordMessage}">
				<c:forEach var="errorMessage" items="${validator.passwordMessage}">	
					<c:out value="${errorMessage}"/>
				</c:forEach>
				</c:if>		
			</td>
		</tr>
		
		<tr>
			<td> 
				<fmt:message key="reg.retypepassword" bundle="${lang}"/>
			</td>
			<td>
				<input type='password' name='retypepsw'/>
			</td>
			<td> 
				<c:if test="${not empty validator.retypepswMessage}">
				<c:forEach var="errorMessage" items="${validator.retypepswMessage}">	
					<c:out value="${errorMessage}"/>
				</c:forEach>
				</c:if>		
			</td>
		</tr>
		<tr>
			<td width='200' height='30'> 
				<fmt:message key="reg.email" bundle="${lang}"/>
			</td> 
			<td> 
				<div class="email"><input type="text" name="email" value="${param.email eq 'null'?'':param.email}" ></div>
			</td>	
			<td> 
				<c:if test="${not empty validator.emailMessage}">
				<c:forEach var="errorMessage" items="${validator.emailMessage}">	
					<c:out value="${errorMessage}"/>
				</c:forEach>
				</c:if>		
			</td>
		</tr>
		<tr>
			<td width='200' height='30'> 
				<fmt:message key="reg.country" bundle="${lang}"/>
			</td>
			<td> 			
				<select name='country'>
					<option selected value="Ukraine"><fmt:message key="reg.ukraine" bundle="${lang}"/></option>
					<option value="France"><fmt:message key="reg.france" bundle="${lang}"/></option>
					<option value="Germany"><fmt:message key="reg.germany" bundle="${lang}"/></option>
					<option value="Great Britain"><fmt:message key="reg.greatbritain" bundle="${lang}"/></option>
					<option value="Poland"><fmt:message key="reg.poland" bundle="${lang}"/></option>
					<option value="USA"><fmt:message key="reg.usa" bundle="${lang}"/></option>
					<option value="Other"><fmt:message key="reg.othercountry" bundle="${lang}"/></option>
					<value=${(user.country eq null)?'':user.country}/>
				</select>
			</td>
		</tr>
				
		<tr>
			<td width='200' height='30'> 
				<fmt:message key="reg.gender" bundle="${lang}"/>
			</td>
			<td>
				<c:choose>
					<c:when test="${!(gender eq 'null')}">
								<input type='radio' name='gender' value='mail' ${(param.gender eq 'mail')?'checked':'_'}/> <fmt:message key="reg.male" bundle="${lang}"/>
								<input type='radio' name='gender' value='femail' ${(param.gender eq 'femail')?'checked':'_'}/> <fmt:message key="reg.female" bundle="${lang}"/>				
					</c:when>
					<c:otherwise>
						<input type='radio' name='gender' value='mail' 'checked'/> <fmt:message key="reg.male" bundle="${lang}"/>
						<input type='radio' name='gender' value='femail' /> <fmt:message key="reg.female" bundle="${lang}"/>								
				
					</c:otherwise>
				</c:choose>
			</td>
			<td> 
				<c:if test="${!(validator.genderMessage eq 'null')}">
				<c:forEach var="errorMessage" items="${validator.genderMessage}">	
					<c:out value="${errorMessage}"/>
				</c:forEach>
				</c:if>		
			</td>
		</tr>
		
		<tr>
			<td width='200' height='30' align="center">
			<!--<input type='submit' name="command" value="registration"/>!-->
			
			<button type="submit" name="command" value="registration">
				<fmt:message key="reg.registration" bundle="${lang}"/>
			</button>
						
			
			</td>
		</tr>
		
		<tr>
			<c:if test="${not empty errorPassMessage}">
				<c:out value="${errorPassMessage}"/>
			</c:if>
		</tr>
		
	</form>
	</table>
	
	</div>
		</div>
		
		<jsp:include page="sidebar.jsp"/>
		
		
	</div>
	
<jsp:include page="footer.jsp"/>