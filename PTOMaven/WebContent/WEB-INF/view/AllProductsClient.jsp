<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="modelMag.*"%>
<%@ page import="constantPack.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://unpkg.com/purecss@0.6.2/build/pure-min.css" integrity="sha384-UQiGfs9ICog+LwheBSRCt1o5cbyKIHbwjWscjemyBMT9YCUMZffs6UqUTd0hObXD" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css" rel="stylesheet">
</head>
<body>
	<div id="container">

		<header id="header">
			<h2>Welcome ${sessionScope[AppSessionAttributes.USERNAME]}</h2>
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
						<form action="${pageContext.request.contextPath}/LogoutServlet"
							method="get" class="pure-form">
							<button type="submit" class="pure-button pure-button-primary">Log out</button>
						</form>
					</li>
				</ul>
			</nav>
			<br/>
		</header>
		
		<br />
		<main> 
	
		<!-- 
		<section>
			<nav>
				<ul class="pure-menu-list">
					<li class="pure-menu-item">
						<form action="${pageContext.request.contextPath}/" method="get" class="pure-form">
							<input type="search" placeholder="search box" name="searchitem">
							<button type="submit" class="pure-button pure-button-primary">Search</button>
						</form>
					</li>
					<li class="pure-menu-item">
						<form action="${pageContext.request.contextPath}/" method="get" class="pure-form">
							<select name="orderofitems">
								<option value="empty">...</option>
								<option value="priceup">Price up</option>
								<option value="pricedown">Price down</option>
								<option value="abcaup">A-Z </option>
								<option value="abcdown">Z-A </option>
							</select>
							<button type="submit" class="pure-button pure-button-primary">Sort</button>		
						</form>
					</li>
				</ul>
			</nav>
		</section>
 		-->
 		
 		<c:if test="${requestScope[AppRequestAttribute.MSG]!=null}">
 			<h4>${requestScope[AppRequestAttribute.MSG]}</h4>
 		</c:if>
		<br />

		<table class="pure-table pure-table-horizontal">
			<thead>
					<tr>
					<th>Product name</th>
					<th>Product price</th>
					<th>Product image</th>
					<th>Product type</th>
					<th>Product options</th>
				</tr>
			</thead>
			<tbody>
				
				<c:set var="map" value="${requestScope[AppRequestAttribute.MAP_PRODUCT_TYPE]}"></c:set>
				<c:forEach items="${requestScope[AppRequestAttribute.LIST_PRODUCTS]}" var="tempproduct">
					<tr>
						<td>${tempproduct.name}</td>
						<td>${tempproduct.price}</td>
						<td><img src="${tempproduct.linkImg}"/></td>
						<td>${map[tempproduct.id].productTypeName}</td>
						<td>
							<form action="${pageContext.request.contextPath}/AddProductInCartServlet" method="post" class="pure-form">
								<input type="text" readonly value="${tempproduct.id}"
								name="<%=AppRequestAttribute.ID_PRODUCT %>" hidden>
								<button type="submit" class="pure-button pure-button-primary">Add in cart</button>
							</form><br/>
							<form action="${pageContext.request.contextPath}/ViewDetailsProductClient" method="post" class="pure-form">
								<input type="text" readonly value="${tempproduct.id}"
								name="<%=AppRequestAttribute.ID_PRODUCT%>" hidden>
								<button type="submit" class="pure-button pure-button-primary">View details</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		</main>
		<br />
		
		<footer id="footer"> </footer>

	</div>
</body>
</html>