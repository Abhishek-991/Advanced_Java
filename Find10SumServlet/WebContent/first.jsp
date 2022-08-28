<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form name="f2" action="findsum">

<%
	for(int i=1;i<=10;i++)
	{
		out.print("<br>ENTER NO: <input type='number' name='t1'>");
	}
out.print("<br><br><input type='submit' name='sub' value='ADD THEM'>");
%>

</form>

</body>
</html>