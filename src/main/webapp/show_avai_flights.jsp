<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<div style="text-align:center">
	<h1>
		These are the available flights from
		<%=request.getAttribute("SNAME")%>
		to
		<%=request.getAttribute("DNAME")%>
		on
		<%=request.getAttribute("DDATE")%>
		please select one
	</h1>


	<form action="<%=request.getContextPath()%>/flight_name" method="post">

		<label for="flight">Choose a flight:</label> <select id="flight"
			name="flight">
			<option value="select">select</option>
			<option value="<%=request.getAttribute("F1")%>"><%=request.getAttribute("F1")%></option>
			<option value="<%=request.getAttribute("F2")%>"><%=request.getAttribute("F2")%></option>
			<option value="<%=request.getAttribute("F3")%>"><%=request.getAttribute("F3")%></option>
		</select>
		<input type="hidden" name="soname" value="<%=request.getAttribute("SNAME")%>">
		<input type="hidden" name="dename" value="<%=request.getAttribute("DNAME")%>">
		<input type="hidden" name="dedate" value="<%=request.getAttribute("DDATE")%>">
		<input type="hidden" name="npersons" value="<%=request.getAttribute("npersons")%>">
		<input type="submit" value="Select">
	</form>
	</div>
</body>
</html>