<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css" rel="stylesheet">
</head>
<body>
	<div id="container">
		<header id="header">
		<h3>Welcome admin <%=session.getAttribute("userName")%></h3>
			
		
			<nav>
				<ul>
					
					
					<li>
						<form action="${pageContext.request.contextPath}/ViewAllProductsServlet" method="get">
							<button type="submit">Product options</button>
						</form>
						
					</li>
					<li>
						<form action="${pageContext.request.contextPath}/ViewAllProductTypeServlet" method="post">
							<button type="submit">ProductType options</button>
						</form>
					</li>
				
					
					
					
					<li>
						<a href="${pageContext.request.contextPath}/ChangePass.jsp"><button
								type="submit">Change pass</button> 
						</a>
					</li>
					
						<li>
						<form action="${pageContext.request.contextPath}/LogoutServlet" method="get">
							<button type="submit">Log out</button>	
						</form>
						
					</li>
				</ul>
			</nav>
			<br/>
		</header>
		<br/>
		<main>
			<br/>
		
			<form action="${pageContext.request.contextPath}/ChangePass" method="post">
				<input type ="password" placeholder="new pass" name="newpass">
				<input type="password" placeholder="new pass again" name="newpass2">
				<button type="submit">Submit </button>
				<button type="reset">Reset</button>
			</form>
		
		</main>
		<br/>
		<footer id="footer">
		</footer>
	</div>
</body>
</html>