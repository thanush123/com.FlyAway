<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ddiv style="text-align:center">
	<form action="<%= request.getContextPath()%>/Changed_Password" method="post">
		New password:<input type="text" name="c_pass">
		<input type="submit" value="Change">
	</form>
	</div>
</body>
</html>