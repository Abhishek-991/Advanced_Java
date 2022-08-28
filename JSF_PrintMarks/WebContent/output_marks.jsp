<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
    <%@ taglib uri="http://java.sun.com/jsf/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Statement of marks</title>
</head>
<body>

<h1><center>STATEMENT OF MARKS<center></center></h1>
<c:view> <center>
STUDENT ID   : <h:outputText value="#{std.sid}"></h:outputText>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;STUDENT NAME : <h:outputText value="#{std.name}"></h:outputText>
<hr><hr>
MATHS     : <h:outputText value="#{std.marks_1}"></h:outputText>&nbsp;&nbsp;&nbsp;&nbsp;
PHYSICS   : <h:outputText value="#{std.marks_2}"></h:outputText>&nbsp;&nbsp;&nbsp;&nbsp;
CHEMISTRY : <h:outputText value="#{std.marks_3}"></h:outputText><br>
<hr>
TOTAL MARKS : <h:outputText value="#{std.sum}"></h:outputText>
<hr><hr>
</center>
</c:view>

</body>
</html>