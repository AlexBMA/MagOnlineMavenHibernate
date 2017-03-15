<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
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
							<button type="submit">Home</button>
						</form></li>
				</ul>
			</nav>

		</header>
		<br/>
		<main>
		<br/>
		<h4>New user information</h4>
		<form action="" method="post">
		
			<br /> <input type="text" placeholder="username" /> <br /> <input
				type="text" placeholder="password" /> <br /> <input type="text"
				placeholder="password again" /> <br /> <select name="role">

				<option value="c">client</option>
				<option value="a">administrator</option>

			</select> <br />
			<button type="submit">Create new user</button>
		</form>

		</main>
		<br />
		<hr/>

		<footer id="footer"> </footer>


	</div>
</body>
</html>