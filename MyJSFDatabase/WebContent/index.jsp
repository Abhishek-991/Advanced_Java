<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
    <%@ taglib uri="http://java.sun.com/jsf/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:view>
<h:form>

E-MAIL   : <h:inputText value="#{us.email}"></h:inputText><br>
PASSWORD : <h:inputText value="#{us.pass}"></h:inputText><br>

<h:commandButton value="LOGIN" action="#{us.login}"></h:commandButton>
<h:commandButton value="SIGN UP" action="#{us.signUp}"></h:commandButton>

</h:form>
</c:view>
</body>
</html>