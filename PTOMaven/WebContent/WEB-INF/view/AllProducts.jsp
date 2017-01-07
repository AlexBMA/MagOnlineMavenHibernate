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
			<br/>
		</header>
		<hr/>
		<br/>
		<main>
			<% 
				List<Product> productList= (List)request.getAttribute("listproduct"); 
				Map<Integer,ProductType> productTypeMap= (Map)request.getAttribute("mapproducttype");
			%>
			
			<table>
				<tr>
					<th>Nume Produs</th>
                		<th>Id Produs</th>
                		<th>Nume Categorie</th>
                		<th>Id Categorie</th>
                		<th>Pret produs</th>
                		<th>Stoc </th>
                		<th>LinkImg</th>
                		<th>Options</th>
				</tr>
				<tbody>
					<%
						for(Product p:productList)
						{
					%>
							<tr>
							<td><%=p.getName() %></td>
							<td><%=p.getId() %></td>
							<td><%=productTypeMap.get(p.getProductTypeId()).getProductTypeName() %></td>
							<td><%=p.getProductTypeId()%></td>
							<td><%=p.getPrice() %></td>
							<td><%=p.getNumberOfItems() %></td>
							<td><%=p.getLinkImg() %></td>
							<td> <form action="${pageContext.request.contextPath}/EditProductServlet" method="post">
								
								<input type="text" value="<%=p.getId() %>" readonly name="idproduct" hidden>
								<button type="submit">Edit</button> 
								 </form> 
								 
								 <form action="${pageContext.request.contextPath}/DeleteProductServlet" method="post">
								 	<input type="text" value="<%=p.getId() %>" readonly name="idproduct" hidden>
								 	<button type="submit">Delete</button>
								 </form>
							
							</td>
							</tr>
					<%	
						}	
					%>
					
				</tbody>
			</table>
			
			<hr>
			
			<form action="${pageContext.request.contextPath}/AddProductServlet" method="post">
				
				<h4>New Product</h4>
				
				<input type="text" placeholder="name of product" name="productname">
				<input type="number"  min="1" placeholder="number of items" name="numberofitems">
				<input type="number"  min="1" step="0.01" placeholder="price" name="priceofproduct">
				
				<select name="productType">
                    <% 	
  						if( productTypeMap!=null)
  						{
  							Set<Integer> keySet = productTypeMap.keySet();
  							for(Integer key: keySet){
  					%>
  						<option >
  						<%=productTypeMap.get(key).getProductTypeName() %>
  						</option>
  					<%} }%>
                    </select>
				
				<input type="text" placeholder="link image" name="linkimage">
				
				<button type="submit">Add product</button>
				<button type="reset">Rest fields</button>
			</form>
			
		</main>
		<br/>
		<hr/>
		<footer id="footer">
		</footer>
	
	</div>
</body>
</html>