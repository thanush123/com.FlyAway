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
		<center>
		<table >
			<tr>
				<td align="left">Source Name:</td>
				<td align="left"><%=request.getAttribute("sname")%></td>
			</tr>
			<tr>
				<td align="left">Destination Name:</td>
				<td align="left"><%=request.getAttribute("dname")%></td>
			</tr>
			<tr>
				<td align="left">Date of Departure:</td>
				<td align="left"> <%=request.getAttribute("date")%></td>
			</tr>
			<tr>
				<td align="left">Flight Name and Time:</td>
				<td align="left"><%=request.getAttribute("flight")%></td>
			</tr>
			</tr>
			<tr>
				<td align="left">Number of People:</td>
				<td align="left"><%=request.getAttribute("npersons")%></td>
			</tr>
		</table>
		</center>
	<h4>Please fill the below details</h4>

	<form action="<%= request.getContextPath()%>/total_details" method="post">
	<center>
	<table >
			<tr>
				<td align="left">Email:</td>
				<td align="left"><input type="email" name="email" required><br></td>
			</tr>
			<tr>
				<td align="left">First Name:</td>
				<td align="left"><input type="text" name="fname" required></td>
			</tr>
			<tr>
				<td align="left">Last Name:</td>
				<td align="left"><input type="text" name="lname" required></td>
			</tr>
			<tr>
				<td align="left">Phone no:</td>
				<td align="left"><input type="text" name="ph_no" required></td>
			</tr>
			<tr>
				<td align="left"><label for="gender">Gender:</label></td>
				<td >
				<select name="gender">
				<option value="select">select</option>
				<option value="Male">Male</option>
				<option value="Female">Female</option>
				</select>
				</td>
			</tr>
			<tr>
				<td align="left">Age:</td>
				<td align="left"><input type="text" name="age"></td>
			</tr>
		</table>
		</center>
		<input type="checkbox" name="terms" required>
		<label for="terms">Agree to the terms and conditions</label><br>
		
		<input type="hidden" name="sname" value="<%=request.getAttribute("sname")%>">
		<input type="hidden" name="dname" value="<%=request.getAttribute("dname")%>">
		<input type="hidden" name="date" value="<%=request.getAttribute("date")%>">
		<input type="hidden" name="flight" value="<%=request.getAttribute("flight")%>">
		<input type="hidden" name="npersons" value="<%=request.getAttribute("npersons")%>">
		<input type="submit" value="Submit">
	</form>
	</div>
</body>
</html>