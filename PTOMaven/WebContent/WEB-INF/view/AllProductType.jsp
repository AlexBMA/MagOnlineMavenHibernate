<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.*" %>
<%@ page import="modelMag.*" %>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://unpkg.com/purecss@0.6.2/build/pure-min.css" integrity="sha384-UQiGfs9ICog+LwheBSRCt1o5cbyKIHbwjWscjemyBMT9YCUMZffs6UqUTd0hObXD" crossorigin="anonymous">
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
				<ul class="pure-menu-list">


					<li class="pure-menu-item">
						<form class="pure-form"
							action="${pageContext.request.contextPath}/ViewAllProductsServlet"
							method="get">
							<button type="submit" class="pure-button pure-button-primary">Product options</button>
						</form>

					</li>
					<li class="pure-menu-item">
						<form class="pure-form"
							action="${pageContext.request.contextPath}/ViewAllProductTypeServlet"
							method="post">
							<button type="submit" class="pure-button pure-button-primary">ProductType options</button>
						</form>
					</li>
					<li class="pure-menu-item">
						<a href="${pageContext.request.contextPath}/ChangePass.jsp">
							<button class="pure-button pure-button-primary">Change pass</button> 
						</a>
					</li>

					<li class="pure-menu-item">
						<form action="${pageContext.request.contextPath}/LogoutServlet" class="pure-form"
							method="get">
							<button type="submit" class="pure-button pure-button-primary">Log out</button>
						</form>

					</li>


				</ul>
			</nav>
			<br/>
		</header>
		
		<br/>
		<main>
			
			<%
				List<ProductType> listProductType = (List)request.getAttribute("listproducttype");
			%>
			<table  class="pure-table pure-table-horizontal">
			
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
							<form action="${pageContext.request.contextPath}/EditProductTypeServlet" method="post" class="pure-form">
								<input type="number" value="<%=temp.getId() %>" name="idproduct" hidden>
								<button type="submit" class="pure-button pure-button-primary">Edit</button>
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
			
			
			
			
			<form action="${pageContext.request.contextPath}/AddProductTypeServlet" method="post" class="pure-form">
				<h4>Add new product type</h4>
				<input type="text" placeholder="name of product type" name="nameofproducttype">
				
				<button type="submit" class="pure-button pure-button-primary">Add product type</button>
				<button type="reset" class="pure-button pure-button-primary">Reset field</button>
			</form>
			
			
			
		</main>
		<br/>
		
		<footer id="footer">
		</footer>
	
	</div>
</body>
</html>