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
		<h3>Welcome to admin page</h3>
	</div>
	<form action="<%=request.getContextPath()%>/admin_info" method="post">
	<center>
		<table >
			<tr align="left">
				<td>Admin Name:</td>
				<td><input type="text" name="adname"></a></td>
			</tr>
			<tr align="left">
				<td>Password:</td>
				<td><input type="password" name="passw"></a></td>
		</table>
		</center>
		<div style="text-align:center">
		<input type="submit" value="Login">
		</div>
	</form>
	<br>
	<div style="text-align:center">
	<a href="pass_change.jsp">Click here to change password</a>
	</div>
</body>
</html>