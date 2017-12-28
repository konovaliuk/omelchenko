<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="ua.company.web.controller.*" %>
<jsp:include page="header.jsp"/>

	<div id="page">
		<div id="content">
			<div id="main">

	
	<table border='0'>
	<form id="registrationForm" action="Testing" method="post">
		<tr>
		</tr>
		<tr>
			<td> 
				Login
			</td> 
			<td> 
				<div class="input"><input type="text" name="login" value="${param.login eq 'null'?'':param.login}" ></div>
				<!--<c:choose>
					<c:when test="${!(user.login eq null)}">
						<input type='text' name='login' value="${user.login}"/>
					</c:when>
					<c:otherwise>
						<input type='text' name='login' value=''/>
					</c:otherwise>
				</c:choose>!-->
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
				Password
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
				Retype password
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
				E-mail
			</td> 
			<td> 
				<div class="email"><input type="text" name="email" value="${param.email eq 'null'?'':param.email}" ></div>
				
				<!--<c:choose>
					<c:when test="${!(user.email eq null)}">
						<input type='text' name='email' value="${user.email}"/>
					</c:when>
					<c:otherwise>
						<input type='text' name='email' value=''/>
					</c:otherwise>
				</c:choose>!-->
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
				Country
			</td>
			<td> 			
				<select name='country'>
					<option selected value="Ukraine">Ukraine</option>
					<option value="France">France</option>
					<option value="Germany">Germany</option>
					<option value="Great Britain">Great Britain</option>
					<option value="Poland">Poland</option>
					<option value="USA">USA</option>
					<option value="Other">Other country</option>
					<value=${(user.country eq null)?'':user.country}/>
				</select>
			</td>
		</tr>
				
		<tr>
			<td width='200' height='30'> 
				Gender
			</td>
			<td>
				<c:choose>
					<c:when test="${!(gender eq 'null')}">
								<input type='radio' name='gender' value='mail' ${(param.gender eq 'mail')?'checked':'_'}/> mail
								<input type='radio' name='gender' value='femail' ${(param.gender eq 'femail')?'checked':'_'}/> femail				
					</c:when>
					<c:otherwise>
						<input type='radio' name='gender' value='mail' 'checked'/> mail
						<input type='radio' name='gender' value='femail' /> femail				
				
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
			<!--<td width='200' height='30' align="center">
			<input type='submit' value='Reset' />		
			</td>!-->
			<td width='200' height='30' align="center">
			<input type='submit' name="command" value="registration"/>		
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