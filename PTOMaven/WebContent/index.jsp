<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css" rel="stylesheet">
<title>Index</title>
</head>
<body>
	<div id="container">

		<header id="header"> </header>
		<hr />
		<br />
		<main>

		<h2>Enter username and password</h2>
		<form action="${pageContext.request.contextPath}/LoginServlet"
			method="post">

			<input type="text" placeholder="username" name="user" /> <input
				type="password" placeholder="pass" name="pass" />
			<button type="submit">Log in</button>
			<button type="reset">Reset</button>
		</form>

		</main>
		<br />
		<hr />

		<footer id="footer"> </footer>

	</div>
</body>
</html>