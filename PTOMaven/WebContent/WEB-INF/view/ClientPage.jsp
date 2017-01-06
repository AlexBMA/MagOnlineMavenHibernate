<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="modelMag.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  href="${pageContext.request.contextPath}/resources/css/style.css" 
	   type="text/css"
	   rel="stylesheet" >
<title>Admin Page</title>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="container">
	
		<header id="header">
		
			<nav>
				<ul>
					<li>
						Home
					</li>
					
					<li>
						<form action="${pageContext.request.contextPath}/ViewProductsClient" method="get">
							<button type="submit">View products</button>
						</form>
						
					</li>
					<li>
						<form action="${pageContext.request.contextPath}/" method="post">
							<button type="submit">View cart</button>
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
			
			
			
		</main>
		<br/>
		<footer id="footer">
		
		
		</footer>
	
	</div>
</body>
</html>