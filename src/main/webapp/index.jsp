<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:include page="header.jsp"/>


	<c:if test="${language eq null}">
		<fmt:setLocale value="en"/>
	</c:if>
	<c:if test="${language!=null}">
		<fmt:setLocale value="${language}"/>
	</c:if>
	
	<fmt:setBundle basename="locale" var="lang"/>
	
	
	<div id="page">
		<div id="content">
		  <div class="post">
				<h2 class="title">
					<fmt:message key="main.title" bundle="${lang}"/>
					${user.login}!
				</h2>
				
				<div class="entry">
					<p>
						<strong>
							<fmt:message key="main.javaquiz" bundle="${lang}"/> 
						</strong> 
							<fmt:message key="main.quizdescription" bundle="${lang}"/> 
					</p>
					<p>
						<fmt:message key="main.service" bundle="${lang}"/> 
					<br/><fmt:message key="main.adv1" bundle="${lang}"/> 
					<br/><fmt:message key="main.adv2" bundle="${lang}"/> 
					<br/><fmt:message key="main.adv3" bundle="${lang}"/> 
					<br/><fmt:message key="main.adv4" bundle="${lang}"/> 
					</p> 
					<p><fmt:message key="main.hope" bundle="${lang}"/> </p>
					<p><strong><fmt:message key="main.whish" bundle="${lang}"/></strong> 
					<br/><strong><fmt:message key="main.team" bundle="${lang}"/></strong> </p>
			</div>
		</div>
		</div>
		
<jsp:include page="sidebar.jsp"/>
		
	</div>
	
<jsp:include page="footer.jsp"/>