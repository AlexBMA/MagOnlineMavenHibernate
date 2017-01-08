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
      
<title>Admin Page</title>

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
						<form action="${pageContext.request.contextPath}/ViewCartClientServlet" method="get">
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
			<% Product temp = (Product)request.getAttribute("product"); 
				List<Product> listReco = (List)request.getAttribute("listofrecommended");
			%>
			
			<form action="${pageContext.request.contextPath}/AddProductInCartServlet" method="post">
				<input type="number" value="<%=temp.getId() %>" readonly hidden name="indexofproduct"/>
			
				<img src="<%=temp.getLinkImg() %>"/>
				<br/>
				<label id="priceinrealtime">Price per unit: <%=temp.getPrice() %></label>
				<br/>
				<input type="number" min="1" max="<%=temp.getNumberOfItems() %>" name="numberofitems" value="1">
				
				<button type="submit">Add to cart</button>
			</form>
			<br/>
			<div id="productreco">
			
			<ul>
				<%
					for(Product temp2:listReco)
					{ if(temp2.getId()!=temp.getId()){
						
				%>
				<li>
					<img src="<%=temp2.getLinkImg() %>"/>
					<form action="${pageContext.request.contextPath}/ViewDetailsProductClient"  method="post">
						<input type="number" value="<%=temp2.getId() %>" readonly  name="idproduct" hidden/>
						<button type="submit">View Details</button>
						
					</form>
				
					
				</li>
				<%} }%>
			</ul>
			<br/>
			</div>	
		
		</main>
		
		
		<br/>
		<hr/>
		<footer id="footer">
		
		<p>text</p>
		</footer>
		<br/>
	</div>
</body>
</html>