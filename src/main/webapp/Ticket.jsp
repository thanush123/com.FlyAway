<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="text-align:center">
<h2>Payment Successful </h2>
<h3>Your Ticket Details</h3>
</div>
	<center>
		<table>
			<tr align="left">
				<td>Email:</td>
				<td><%=request.getAttribute("Email")%></td>
			</tr>
			<tr align="left">
				<td>First Name:</td>
				<td><%=request.getAttribute("Fname")%></td>
			</tr>
			<tr align="left">
				<td>Last Name:</td>
				<td><%=request.getAttribute("Lname")%></td>
			</tr>
			<tr align="left">
				<td>Gender:</td>
				<td><%=request.getAttribute("Gender")%></td>
			</tr>
			<tr align="left">
				<td>Age:</td>
				<td><%=request.getAttribute("Age")%></td>
			</tr>
			<tr align="left">
				<td>Phone no:</td>
				<td><%=request.getAttribute("Ph_no")%></td>
			</tr>
			<tr align="left">
				<td>From:</td>
				<td><%=request.getAttribute("Sname")%></td>
			</tr>
			<tr align="left">
				<td>To:</td>
				<td><%=request.getAttribute("Dname")%></td>
			</tr>
			<tr align="left">
				<td>Departure Date:</td>
				<td><%=request.getAttribute("Date")%></td>
			</tr>
			<tr align="left">
				<td>Flight Name,Time and price: </td>
				<td><%=request.getAttribute("Flight")%></td>
			</tr>
			</tr>
			<tr align="left">
				<td>Total Number of People </td>
				<td><%=request.getAttribute("npersons")%></td>
			</tr>
			</tr>
			<tr align="left">
				<td>Total Amount</td>
				<td><%=request.getAttribute("t_amount")%></td>
			</tr>
		</table>
	</center>
	<br>
	<div style="text-align:center">
	<form action="<%= request.getContextPath()%>/index.jsp" method="post">
	<input type="submit" value="Home">
	</form>
	</div>
</body>
</html>