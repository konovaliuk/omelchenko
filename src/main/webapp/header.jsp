<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Rapid quiz system JavaQuiz</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<link rel="icon" type="image/png/ico" href="images/brain.ico" />
</head>
<body>

	
	<c:if test="${language eq null}">
		<fmt:setLocale value="en"/>
	</c:if>
	<c:if test="${language!=null}">
		<fmt:setLocale value="${language}"/>
		
	</c:if>
	
	<fmt:setBundle basename="locale" var="lang"/>
	
	<div id="logo">
		<h1><a href="#">JavaQuiz</a></h1>
		
		<p><fmt:message key="menu.title" bundle="${lang}"></fmt:message> </p>
		
	</div>
	<hr />
	
	<div id="header">
		<div id="menu">
			<ul>
				<li><a href="index.jsp" class="first">
					<fmt:message key="menu.main" bundle="${lang}"/> 
				</a></li>
				<li><a href="login.jsp">
					<fmt:message key="menu.login" bundle="${lang}"/> 	
				</a></li>
				<li><a href="registration.jsp">
					<fmt:message key="menu.registration" bundle="${lang}"/>
				</a></li>
				<li class="quiz"><a href="quiz.jsp">
					<fmt:message key="menu.quiz" bundle="${lang}"/>
				</a></li>

				<c:if test="${user.usertypeId eq "1"}">
					<li><a href="admin.jsp">
						<fmt:message key="menu.administration" bundle="${lang}"/>
					</a></li>
				</c:if>

			</ul>
		</div>
		
		<div id="search">
			<form method="post" action="Testing">
				<fieldset>
					<input type="submit" id="search-submit" value="ENG" />
					<input type="hidden" name="command" value="changeLocale" />
					<input type="hidden" name="localelang" value="en"/>
				</fieldset>
			</form>
		
			<form method="post" action="Testing">
				<fieldset>
					<input type="submit" id="search-submit" value="UKR" />
					<input type="hidden" name="command" value="changeLocale" />
					<input type="hidden" name="localelang" value="uk"/>
				</fieldset>
			</form>
		
		</div>
	</div>
	
	
<!-- end #header -->
	
