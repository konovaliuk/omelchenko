<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<jsp:include page="header.jsp"/>

	<div id="page">
		<div id="content">
		  <div class="post">
				<h2 class="title"><a href="#">Welcome to JavaQuiz </a></h2>
				
				<div class="entry">
					<p><strong>JavaQuiz </strong> is a free quiz for Java developers. The aim of site is to provide service which not only checks the level of urrecnt  knowledge, but also helps to receive new knowledge.</p>
					<p>Service of JavaQuiz is dedicated to Java developers, who want with help of quiz to:<br />check hisself in Java<br />to prepare for to interview or exams<br />systematize their knowledge and identify "gaps" in a particular topic<br />get new knowledge on the topic of interest</p> 
					<p>We hope that this resource will help you to succeed both in professional and career growth.</p>
					<p><strong>Best regards,</strong> <br /><strong>JavaQuiz Team</strong> </p>
			</div>
		</div>
		</div>
		<div id="sidebar">
			<ul>
				<li>
					<h2>Subject </h2>
					<ul>
						<li><a href="quiz.jsp?subject_id=1">Classes, methods, types </a></li>
						<li><a href="quiz.jsp?subject_id=2">Collections </a></li>
						<li><a href="quiz.jsp?subject_id=3">Nested/Inner classes </a></li>
						<li><a href="quiz.jsp?subject_id=4">Exceptions </a></li>
					</ul>
				</li>
			</ul>
	  </div>
		<div style="clear: both;">&nbsp;</div>
	</div>
	
<jsp:include page="footer.jsp"/>