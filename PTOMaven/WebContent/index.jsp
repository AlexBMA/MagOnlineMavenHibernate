<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://unpkg.com/purecss@0.6.2/build/pure-min.css" integrity="sha384-UQiGfs9ICog+LwheBSRCt1o5cbyKIHbwjWscjemyBMT9YCUMZffs6UqUTd0hObXD" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css" rel="stylesheet">
<title>Index</title>
</head>
<body>
	<div id="container">

		<header id="header"> </header>
		
		<br />
		<main>

		<h2>Enter username and password</h2>
		<form action="${pageContext.request.contextPath}/LoginServlet"
			method="post" class="pure-form">

			<input type="text" placeholder="username" name="user" /> <input
				type="password" placeholder="pass" name="pass" />
			<button type="submit" class="pure-button pure-button-primary" >Log in</button>
			<button type="reset" class="pure-button pure-button-primary">Reset</button>
		</form>

		<a href="${pageContext.request.contextPath}/CreateNewUser.jsp">
			<button class="pure-button pure-button-primary">Create user</button>
		</a> </main>
		<br />
		

		<footer id="footer"> </footer>

	</div>
</body>
</html>