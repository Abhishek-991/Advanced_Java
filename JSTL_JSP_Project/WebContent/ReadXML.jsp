<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EMPLOYEE DATA</title>
</head>
<body>

<h1>DATA FROM XML FILE</h1><br>

<c:import url="emp.xml" var="e"></c:import>

<x:parse doc="${e}" var="data"></x:parse>

<table border="5" style="margin-left:20px;width=70%">
<tr><th> &nbsp;ID&nbsp; </th> <th> &nbsp;NAME&nbsp; </th> <th>&nbsp;SALARY&nbsp; </th></tr>

<x:forEach select="$data/company/employee">

<tr>

<td><x:out select="id"/></td>
<td><x:out select="name"/></td>
<td><x:out select="salary"/></td>

</tr>

</x:forEach>

</table>
</body>
</html>