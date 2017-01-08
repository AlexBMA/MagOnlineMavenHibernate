<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="modelMag.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css" rel="stylesheet">
</head>
<body>
	<div id="container">

		<header id="header">
			<h2>Welcome <%=session.getAttribute("userName")%></h2>
			<nav>
				<ul>
					<li>Home</li>

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
						<form action="${pageContext.request.contextPath}/LogoutServlet"
							method="get">
							<button type="submit">Log out</button>
						</form>

					</li>
				</ul>
			</nav>
			<br/>
		</header>
		<hr />
		<br />
		<main> 
		<%
 			List<Product> productList = (List) request.getAttribute("listproduct");
 			Map<Integer, ProductType> productTypeMap = (Map) request.getAttribute("mapproducttype");
 		%>

		<section>
			<nav>
				<ul>
					<li>
						<form action="" method="get">
							<input type="text" placeholder="search box" name="searchitem">
							<button type="submit">Search</button>
						</form>
					</li>
					<li>
						<form action="" method="get">
							<select name="orderofitems">
								<option value="empty">...</option>
								<option value="priceup">Price up</option>
								<option value="pricedown">Price down</option>
								<option value="abcaup">ABC up</option>
								<option value="abcdown">ABC down</option>
							</select>
						</form>
					</li>
				</ul>
			</nav>
		</section>

		<br />

		<table>
			<thead>
				<th>Product name</th>
				<th>Product price</th>
				<th>Product image</th>
				<th>Product type</th>
				<th>Product options</th>
			</thead>
			<tbody>
				<%
					for (Product temp : productList) {
				%>
				<tr>
					<td><%=temp.getName()%></td>
					<td><%=temp.getPrice()%></td>
					<td><img src="<%=temp.getLinkImg()%>  " /></td>
					<td><%=productTypeMap.get(temp.getProductTypeId()).getProductTypeName()%></td>
					<td>
						<form action="${pageContext.request.contextPath}/AddProductInCartServlet" method="post">
							<input type="text" readonly value="<%=temp.getId()%>"
								name="indexofproduct">
							<button type="submit">Add in cart</button>
						</form>
						<form
							action="${pageContext.request.contextPath}/ViewDetailsProductClient"
							method="post">
							<input type="text" readonly value="<%=temp.getId()%>"
								name="idproduct">
							<button type="submit">View details</button>
						</form>
					</td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>

		</main>
		<br />
		<hr />
		<footer id="footer"> </footer>

	</div>
</body>
</html>