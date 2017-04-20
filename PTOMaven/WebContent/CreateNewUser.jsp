<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://unpkg.com/purecss@0.6.2/build/pure-min.css" integrity="sha384-UQiGfs9ICog+LwheBSRCt1o5cbyKIHbwjWscjemyBMT9YCUMZffs6UqUTd0hObXD" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css" rel="stylesheet">
<title>Create user page</title>
</head>
<body>
	<div id="container">

		<header id="header">
			<h2>Create new user</h2>
			<nav>
				<ul>
					<li><form method="get"
							action="${pageContext.request.contextPath}/index.jsp">
							<button type="submit" class="pure-button pure-button-primary">Home</button>
						</form></li>
				</ul>
			</nav>

		</header>
		<br/>
		<main>
		<br/>
		<h4>New user information</h4>
		<form action="${pageContext.request.contextPath}/CreateNewUser" method="post"class="pure-form">
		
			<br /> <input type="text" placeholder="username" name="username"/> 
			<br /> <input type="text" placeholder="password" name="passone" />
			<br /> <input type="text" placeholder="password again" name="passtwo" /> 
			<br /> 
			<select name="role">
				<option value="c">client</option>
				<option value="a">administrator</option>
			</select>
			 <br />
			<button type="submit" class="pure-button pure-button-primary">Create new user</button>
		</form>

		</main>
		<br />
		<hr/>

		<footer id="footer"> </footer>


	</div>
</body>
</html>