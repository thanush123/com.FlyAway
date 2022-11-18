<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="com.FlyAway.phase2.project.Flight_details" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="text-align:center">
	<h1>Welcome To FlyAway</h1>
	<p>Hello My Name is <b>K.Thanush Kumar Reddy</b> and this is my <b>Phase 2 Project</b></p>
	<br>
	<p>Please select <b>Source, Destination</b> and <b>Date</b></p>
	<form action="<%= request.getContextPath()%>/Flight_details" method="post">
		<label for="source">Choose a Source:</label> 
		<select id="source" name="source">
			<option value="select">select</option>
			<option value="Hyderabad">Hyderabad</option>
			<option value="Bengaluru">Bengaluru</option>
			<option value="Delhi">Delhi</option>
			<option value="chennai">Chennai</option>
		</select> 
		
		<label for="destination">Choose a Destination:</label> <select
			id="destination" name="destination">
			<option value="select">select</option>
			<option value="Hyderabad">Hyderabad</option>
			<option value="Bengaluru">Bengaluru</option>
			<option value="Delhi">Delhi</option>
			<option value="chennai">Chennai</option>
		</select>
		
		Choose Date:<input type="date" name="date">
		No of Persons:<input type="text" name="npersons" size="10">
		<input type="submit" value="Find"><br>
	</form>
	<br>
	<br>
	<br>
	<a href="admin.jsp">Go to admin page</a>
	</div>
</body>
</html>