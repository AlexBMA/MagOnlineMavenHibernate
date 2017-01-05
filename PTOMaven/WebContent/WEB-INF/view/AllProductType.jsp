<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.*" %>
<%@ page import="modelMag.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
</head>
<body>
	<div id="container">
	
		<header id="header">
			
			<h3>Welcome admin <%=session.getAttribute("userName")%></h3>
			
			<nav>
				<ul>
					<li>
						Home
					</li>
				
					<li>
						<form action="${pageContext.request.contextPath}/ViewAllProductsServlet" method="get">
							<button type="submit">Product options</button>
						</form>
						
					</li>
					<li>
						<form action="${pageContext.request.contextPath}/ViewAllProductTypeServlet" method="get">
							<button type="submit">ProductType options</button>
						</form>
					</li>
					<li>
						<form action="${pageContext.request.contextPath}/LogoutServlet" method="get">
							<button type="submit">Log out</button>	
						</form>
						
					</li>
				</ul>
			</nav>
		</header>
		<br/>
		<main>
			
			<p>here in product type operations</p>
			
			
			<hr>
			
			
			
		</main>
		<br/>
		<footer id="footer">
		</footer>
	
	</div>
</body>
</html>