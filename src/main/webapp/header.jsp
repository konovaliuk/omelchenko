<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
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
	<div id="logo">
		<h1><a href="#">JavaQuiz</a></h1>
		<p>Fast quiz</p>
	</div>
	<hr />
	
	<div id="header">
		<div id="menu">
			<ul>
				<li><a href="index.jsp" class="first">Main</a></li>
				<li><a href="login.jsp">Login</a></li>
				<li><a href="registration.jsp">Registration</a></li>
				<li class="quiz"><a href="quiz.jsp">Quiz</a></li>
			</ul>
		</div>
		
		<div id="search">
			<form method="get" action="">
				<fieldset>
				<input type="text" name="s" id="search-text" size="15" />
				<input type="submit" id="search-submit" value="GO" />
				</fieldset>
			</form>
		</div>
		
	</div>
<!-- end #header -->
	
