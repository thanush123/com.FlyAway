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
	<h3>Payment GateWay</h3>
	<form action="<%= request.getContextPath()%>/Final_Ticket" method="post">
		Card Number:<input type="text" required> 
		CVV:<input type="text" required>
		expiration date: <input type="date" required><br> 
		<input type="hidden" name="email" value="<%=request.getAttribute("email")%>">
		<input type="hidden" name="fname" value="<%=request.getAttribute("fname")%>">
		<input type="hidden" name="lname" value="<%=request.getAttribute("lname")%>">
		<input type="hidden" name="gender" value="<%=request.getAttribute("gender")%>">
		<input type="hidden" name="age" value="<%=request.getAttribute("age")%>">
		<input type="hidden" name="ph_no" value="<%=request.getAttribute("ph_no")%>">
		<input type="hidden" name="sname" value="<%=request.getAttribute("sname")%>">
		<input type="hidden" name="dname" value="<%=request.getAttribute("dname")%>">
		<input type="hidden" name="date" value="<%=request.getAttribute("date")%>">
		<input type="hidden" name="flight" value="<%=request.getAttribute("flight")%>">
		<input type="hidden" name="npersons" value="<%=request.getAttribute("npersons")%>">
		<input type="submit" value="pay">
	</form>
	</div>
</body>
</html>