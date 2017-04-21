<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="modelMag.*" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://unpkg.com/purecss@0.6.2/build/pure-min.css" integrity="sha384-UQiGfs9ICog+LwheBSRCt1o5cbyKIHbwjWscjemyBMT9YCUMZffs6UqUTd0hObXD" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link  href="${pageContext.request.contextPath}/resources/css/style.css" 
	   type="text/css"
	   rel="stylesheet" />
      
<title>Client Page</title>

</head>
<body>
	<div id="container">
	
		<header id="header">
			<h2>Welcome <%=session.getAttribute("userName")%></h2>
		
			<nav>
				<ul class="pure-menu-list">
										
					<li class="pure-menu-item">
						<form action="${pageContext.request.contextPath}/ViewProductsClient" method="get" class="pure-form">
							<button type="submit" class="pure-button pure-button-primary">View products</button>
						</form>
						
					</li>
					<li class="pure-menu-item">
						<form action="${pageContext.request.contextPath}/ViewCartClientServlet" method="get" class="pure-form">
							<button type="submit" class="pure-button pure-button-primary">View cart</button>
						</form>
					</li>
					<li class="pure-menu-item">
						<a href="${pageContext.request.contextPath}/ChangePass.jsp">
							<button class="pure-button pure-button-primary">Change pass</button> 
						</a>
					</li>
					
					<li class="pure-menu-item">
						<form action="${pageContext.request.contextPath}/LogoutServlet" method="get" class="pure-form">
							<button type="submit" class="pure-button pure-button-primary">Log out</button>	
						</form>
						
					</li >
				</ul>
			</nav>
			<br/>
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