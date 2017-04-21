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
						<form action="${pageContext.request.contextPath}/LogoutServlet" method="get" class="pure-form">
							<button type="submit" class="pure-button pure-button-primary">Log out</button>	
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
			<div id="productdetails">
			<form action="${pageContext.request.contextPath}/AddProductInCartServlet" method="post" class="pure-form">
				<input type="number" value="<%=temp.getId() %>" readonly hidden name="indexofproduct"/>
			
				<img src="<%=temp.getLinkImg() %>"/>
				<br/>
				<label id="priceinrealtime">Price per unit: <%=temp.getPrice() %></label>
				<br/>
				<input type="number" min="1" max="<%=temp.getNumberOfItems() %>" name="numberofitems" value="1">
				
				<button type="submit" class="pure-button pure-button-primary">Add to cart</button>
			</form>
			</div>
			<br/>
			<div id="productreco">
			<ul>
				<%
					for(Product temp2:listReco)
					{ if(temp2.getId()!=temp.getId()){			
				%>
				<li>
					<img src="<%=temp2.getLinkImg() %>"/>
					<form action="${pageContext.request.contextPath}/ViewDetailsProductClient"  method="post" class="pure-form">
						<input type="number" value="<%=temp2.getId() %>" readonly  name="idproduct" hidden/>
						<button type="submit" class="pure-button pure-button-primary">View Details</button>
						
					</form>
				
				</li>
				<%} }%>
			</ul>
			<br/>
			</div>	
		
		</main>
		<br/>
		<footer id="footer">
		<br/>
		
		
		
		</footer>
		<br/>
	</div>
</body>
</html>