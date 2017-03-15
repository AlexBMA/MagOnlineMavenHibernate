<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.*" %>
<%@ page import="modelMag.*" %>
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
						<a href="${pageContext.request.contextPath}/ChangePass.jsp">
							<button>Change pass</button> 
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
		<hr/>
		<br/>
		<main>
			
			<%
				List<ProductType> listProductType = (List)request.getAttribute("listproducttype");
			%>
			<table>
			
				<tr>
					<th>Id product type </th>
					<th>Product type name </th>
					<th>Options</th>
				</tr>
				<tbody>
					<%
						for(ProductType temp:listProductType)
						{
					%>
					<tr>
						<td><%=temp.getId() %> </td>
						<td><%=temp.getProductTypeName() %> </td>
						<td>
							<form action="${pageContext.request.contextPath}/EditProductTypeServlet" method="post">
								<input type="number" value="<%=temp.getId() %>" name="idproduct" hidden>
								<button type="submit">Edit</button>
							</form>
							<!-- 
							<form action="${pageContext.request.contextPath}/DeleteProductTypeServlet" method="post">
								<input type="number" value="<%=temp.getId() %>" name="idproduct">
								<button type="submit">Delete</button>
							</form>
							 -->
						</td>
					</tr>
					<%} %>
				</tbody>
				
			</table>
			
			
			<hr>
			
			<form action="${pageContext.request.contextPath}/AddProductTypeServlet" method="post" >
				<h4>Add new product type</h4>
				<input type="text" placeholder="name of product type" name="nameofproducttype">
				
				<button type="submit">Add product type</button>
				<button type="reset">Reset field</button>
			</form>
			
			
			
		</main>
		<br/>
		<hr/>
		<footer id="footer">
		</footer>
	
	</div>
</body>
</html>