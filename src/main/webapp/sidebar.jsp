<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<c:if test="${language eq null}">
		<fmt:setLocale value="en"/>
	</c:if>
	<c:if test="${language!=null}">
		<fmt:setLocale value="${language}"/>
	</c:if>
	
	<fmt:setBundle basename="locale" var="lang"/>
	
		<div id="sidebar">
			<ul>
				<li>
					<h2><fmt:message key="sidebar.subject" bundle="${lang}"/> </h2>
					<ul>
						<li><a href="Testing?command=subject&subject_id=1"><fmt:message key="sidebar.s1" bundle="${lang}"/> </a></li>
						<li><a href="Testing?command=subject&subject_id=2"><fmt:message key="sidebar.s2" bundle="${lang}"/> </a></li>
						<li><a href="Testing?command=subject&subject_id=3"><fmt:message key="sidebar.s3" bundle="${lang}"/> </a></li>
						<li><a href="Testing?command=subject&subject_id=4"><fmt:message key="sidebar.s4" bundle="${lang}"/> </a></li>
						<li><a href="Testing?command=subject&subject_id=5"><fmt:message key="sidebar.s5" bundle="${lang}"/> </a></li>
					</ul>
				</li>
			</ul>
	  </div>
		<div style="clear: both;">&nbsp;</div>
