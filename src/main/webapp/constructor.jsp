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
	<form id="constructorForm" action="Testing" method="post">
		<tr>
			<td>
			</td>
				<td> 
			</td> 
			<td> 
				<strong><big>English language</big></strong>
			</td> 
			<td> 
				<strong><big>Ukrainian language</big></strong>
			</td> 
		<br>
		</tr>
		
		
		<tr>
			<td> 
				Question
			</td> 
			
			<td> 
			</td> 
			
			<td> 
				<textarea cols='25' rows='5' name='question'></textarea>
				<br>
				</br>

			</td> 

			<td> 
				<textarea cols='25' rows='5' name='questionUkr'></textarea>
				<br>
				</br>

			</td> 


			</tr>
		
		
		<tr>
			<td> 
				Subject
			</td>
			<td> 
			</td> 
			<td> 
				<select name='subject'>
					<option selected value="1"><fmt:message key="sidebar.s1" bundle="${lang}"/></option>
					<option value="2"><fmt:message key="sidebar.s2" bundle="${lang}"/></option>
					<option value="3"><fmt:message key="sidebar.s3" bundle="${lang}"/></option>
					<option value="4"><fmt:message key="sidebar.s4" bundle="${lang}"/></option>
					<option value="5"><fmt:message key="sidebar.s5" bundle="${lang}"/></option>
					<!--<value=${(param.subject eq null)?'':param.subject}/>!-->
				</select>			
			<br>
			</br>
			</td>
		</tr>
		
		<tr>
			<td> 
				Answer #1
				(mark the right answers)
			</td>
			<td> 
				<input type='checkbox' name='isRight1' ${param.isRight1 eq 'on'?'checked':'_'} />
			</td>
			<td>
				<textarea cols='25' rows='5' name='answer1'></textarea>
				
				<!--<input type='text' name='answer1'/>!-->
			<br>
			</br>
			</td>
			
			<td>
				<textarea cols='25' rows='5' name='answer1Ukr'></textarea>
				
				
			<br>
			</br>
			</td>
			
		</tr>
		
		<tr>
			<td> 
				Answer #2
			</td>
			<td> 
				<input type='checkbox' name='isRight2' ${param.isRight2 eq 'on'?'checked':'_'} />
			</td>
			<td>
				<textarea cols='25' rows='5' name='answer2'></textarea>
				
				<!--<input type='text' name='answer1'/>!-->
			<br>
			</br>
			</td>
				
			<td>
				<textarea cols='25' rows='5' name='answer2Ukr'></textarea>
				
				<!--<input type='text' name='answer1'/>!-->
			<br>
			</br>
			</td>
				
				
		</tr>
		
		<tr>
			<td> 
				Answer #3
			</td>
			<td> 
				<input type='checkbox' name='isRight3' ${param.isRight3 eq 'on'?'checked':'_'} />
			</td>
			
			<td>
				<textarea cols='25' rows='5' name='answer3'></textarea>
				
				<!--<input type='text' name='answer1'/>!-->
			<br>
			</br>
			</td>

			<td>
				<textarea cols='25' rows='5' name='answer3Ukr'></textarea>
				
				<!--<input type='text' name='answer1'/>!-->
			<br>
			</br>
			</td>


		</tr>
		
		<tr>
			<td> 
				Answer #4
			</td>
			<td> 
				<input type='checkbox' name='isRight4' ${param.isRight4 eq 'on'?'checked':'_'} />
			</td>
			
			
			<td>
				<textarea cols='25' rows='5' name='answer4'></textarea>
				
				<!--<input type='text' name='answer1'/>!-->
			<br>
			</br>

			</td>
			
			<td>
				<textarea cols='25' rows='5' name='answer4Ukr'></textarea>
				
				<!--<input type='text' name='answer1'/>!-->
			<br>
			</br>

			</td>
			
		</tr>
		
		<tr>
			<td> 
				Answer #5
			</td>
			<td> 
				<input type='checkbox' name='isRight5' ${param.isRight5 eq 'on'?'checked':'_'} />
			</td>

			<td>
				<textarea cols='25' rows='5' name='answer5'></textarea>
				
				<!--<input type='text' name='answer1'/>!-->
			<br>
			</br>

			</td>

			<td>
				<textarea cols='25' rows='5' name='answer5Ukr'></textarea>
				
				<!--<input type='text' name='answer1'/>!-->
			<br>
			</br>

			</td>

			
		</tr>
		
		<tr>
			<td width='200' height='30' align="center">
			
			<button type="submit" name="command" value="constructor">
				Add next question
			</button>
						
			
			</td>
		</tr>
		
		<tr>
			<c:if test="${not empty errorPassMessage}">
				<c:out value="${errorPassMessage}"/>
			</c:if>
			<br>
			</br>

		</tr>
		
	</form>
	</table>
	
	</div>
		</div>
		
		<jsp:include page="sidebar.jsp"/>
		
		
	</div>
	
<jsp:include page="footer.jsp"/>