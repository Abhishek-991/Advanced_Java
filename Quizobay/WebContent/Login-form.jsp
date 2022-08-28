<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Quizobay | Home</title>

<style type="text/css">

form{
margin: 20px auto;
padding:16px auto;

}


</style>

</head>
<body>

<%

Cookie c[]=request.getCookies();

if(c!=null)
{
	for(int i=0;i<c.length;i++)
	{
		if(c[i].getName().equals("loginmail"))
		{
			out.println("<br>Login mail: "+c[i].getValue());
		}
		else if(c[i].getName().equals("loginpass"))
		{
			out.println("<br>Login Password : "+c[i].getValue());
		}
	}
	
}


%>

	<form action="login-form" name="login">

  <div class="form-group">
    <label for="loginemail">Email : </label>
    <input type="email" class="form-control" id="loginmail" placeholder="Email">
  </div>

  <div class="form-group">
    <label for="loginPassword">Password : </label>
    <input type="password" class="form-control" id="loginpassword" placeholder="Password">
  </div>


  <div class="checkbox">
    <label>
      <input type="checkbox"> Keep Logged in..
    </label>
  </div>

  <button type="submit" class="btn btn-success">Submit</button>

</form>

</body>
</html>