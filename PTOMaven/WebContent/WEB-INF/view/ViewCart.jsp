<%@page import="servicies.ProductService"%>
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
	   rel="stylesheet" />
      
<title>Client Page</title>

</head>
<body>
	<div id="container">
	
		<header id="header">
			<h2>Welcome <%=session.getAttribute("userName")%></h2>
		
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
			<br/>
		</header>
		<br/>
		<main>
			<%
				Cart theCart = (Cart)session.getAttribute("cart");
				String msg = (String)request.getAttribute("msg");
			%>
			<% if(msg!=null){    %>
				<h4><%=msg %></h4>
			
			<%}
			%>
			
			<h4><%=theCart.getTotalPriceForProductFormCart() %></h4>
			
			<%
				List<ProductFromCart> list = theCart.getProductsFromCart();
			
				for(ProductFromCart temp:list)
				{%>
				
				
				<p><%=temp.getProdus().getName() %>    <%=temp.getCantitateComandata() %>  </p>
					
			<%	}
			%>
			
			<form action="${pageContext.request.contextPath}/SaveCartServlet" method="post">
			
				<button type="submit">Save cart</button>
			</form>
		</main>
		<br/>
		<footer id="footer">
		
		
		</footer>
	
	</div>
</body>
</html>