<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
    <%@ taglib uri="http://java.sun.com/jsf/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HOME</title>
</head>
<body>
<h1>STUDENT DETAILS</h1><hr>
<c:view>
<h:form>

ID        :<h:inputText value="#{std.sid}"></h:inputText>&nbsp;&nbsp;
NAME	  :<h:inputText value="#{std.name}"></h:inputText><br><hr>
MATHS     :<h:inputText value="#{std.marks_1}"></h:inputText>&nbsp;&nbsp;&nbsp;
PHYSICS   :<h:inputText value="#{std.marks_2}"></h:inputText>&nbsp;&nbsp;&nbsp;
CHEMISTRY :<h:inputText value="#{std.marks_3}"></h:inputText><br>
<br>
<h:commandButton value="TOTAL MARKS" action="#{std.next}"></h:commandButton>
</h:form>
</c:view>

</body>
</html>