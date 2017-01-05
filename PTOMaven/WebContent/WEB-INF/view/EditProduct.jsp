<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*" %>
<%@ page import="modelMag.*" %>

<!DOCTYPE html>
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
						<form action="${pageContext.request.contextPath}/ViewAllProductTypeServlet" method="post">
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
			<% 
				Product productLocal = (Product)request.getAttribute("productlocal"); 
				Map<Integer,ProductType> productTypeMap= (Map)request.getAttribute("mapproducttype");
			%>
			
			<form action="${pageContext.request.contextPath}/SaveEditServlet" method="post">
				
				<h4>Edit Product</h4>
				
				<input type="number" name="indexproduct" value="<%=productLocal.getId() %>" readonly>
				<br/>
				<label>Product name: </label>
				<input type="text"  name="productname" value="<%=productLocal.getName() %>" >
				<br/>
				<label>Number of items: </label>
				<input type="number"  min="1"  name="numberofitems" value="<%=productLocal.getNumberOfItems() %>" >
				<br/>
				<label>Price: </label>
				<input type="number"  min="1"  step="0.01" name="priceofproduct" value="<%=productLocal.getPrice() %>">
				<br/>
				<label>Product type: </label>
				<select name="producttype" required>
                    <% 	
  						if( productTypeMap!=null)
  						{
  							
  							Set<Integer> keySet = productTypeMap.keySet();
  							for(Integer key: keySet){
  					%>
  						<option>
  						<%=productTypeMap.get(key).getProductTypeName() %>
  						</option>
  					<%} }%>
                    </select>
				<br/>
				<label>Image link</label>
				<input type="text" name="linkimage" value="<%=productLocal.getLinkImg() %>">
				<br/>
				<button type="submit">Save edit </button>
				<button type="reset">Rest fields</button>
			</form>
			
			<hr>
			
			
			
		</main>
		<br/>
		<footer id="footer">
		</footer>
	
	</div>
</body>
</html>