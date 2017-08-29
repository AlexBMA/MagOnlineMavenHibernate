<%@page import="constantPack.AppRequestAttribute"%>
<%@page import="constantPack.AppRedirectPages"%>
<%@page import="constantPack.AppSessionAttributes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*" %>
<%@ page import="modelMag.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
			<h3>Welcome admin <%=session.getAttribute(AppSessionAttributes.USERNAME)%></h3>
			<nav>
				<ul class="pure-menu-list">
					
				
					<li class="pure-menu-item">
						<form action="${pageContext.request.contextPath}/ViewAllProductsServlet" method="get" class="pure-form">
							<button type="submit" class="pure-button pure-button-primary">Product options</button>
						</form>
						
					</li>
					<li class="pure-menu-item">
						<form action="${pageContext.request.contextPath}/ViewAllProductTypeServlet" method="post" class="pure-form">
							<button type="submit" class="pure-button pure-button-primary">ProductType options</button>
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
						
					</li>
				</ul>
			</nav>
			<br/>
		</header>
		
		<br/>
		<main>
		
			
			
			
			<table class="pure-table pure-table-horizontal">
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
					
					
				
					
					<!-- =productTypeMap.get(p.getProductTypeId()).getProductTypeName()
						<c:out value="${map['key']}"/>
					-->
					
					<c:set var="map" value="${requestScope[AppRequestAttribute.MAP_PRODUCT_TYPE]}"/>
					<c:forEach items="${requestScope[AppRequestAttribute.LIST_PRODUCTS]}" var="tempProduct">
						<tr>
							<td>${tempProduct.name}</td>
							<td>${tempProduct.id}</td>
							
							<c:set var="keyDim" value="${tempProduct.productTypeId}"/>
							<td>
								 ${map[keyDim].productTypeName}	
							</td>
							
							<td>${tempProduct.productTypeId}</td>
							<td>${tempProduct.price}</td>
							<td>${tempProduct.numberOfItems}</td>
							<td>${tempProduct.linkImg}</td>
							<td>
								 <form action="${pageContext.request.contextPath}/EditProductServlet" method="get" class="pure-form">	
									<input type="text" value="${tempProduct.id}" readonly name="<%=AppRequestAttribute.ID_PRODUCT %>" hidden>
									<button type="submit" class="pure-button pure-button-primary">Edit</button> 
								 </form> <br/>
								 
								 <form action="${pageContext.request.contextPath}/DeleteProductServlet" method="post" class="pure-form">
								 	<input type="text" value="${tempProduct.id}" readonly name="<%=AppRequestAttribute.ID_PRODUCT %>" hidden>
								 	<button type="submit" class="pure-button pure-button-primary">Delete</button>
								 </form>
							</td>
						</tr>
					</c:forEach>		
				</tbody>
			</table>
			
			
			<form action="${pageContext.request.contextPath}/AddProductServlet" method="post" class="pure-form">
				
				<h4>New Product</h4>
				
				<input type="text" placeholder="name of product" name="<%=AppRequestAttribute.PRODUCT_NAME%>">
				<input type="number"  min="1" placeholder="number of items" name="<%=AppRequestAttribute.PRODUCT_NUMBER_OF_ITEMS%>">
				<input type="number"  min="1" step="0.01" placeholder="price" name="<%=AppRequestAttribute.PRODUCT_PRICE%>">
				
				<select name="<%=AppRequestAttribute.PRODUCT_TYPE_NAME%>">
					<c:forEach items="${map}" var="temp">
						 <option >
						 	${temp.value.productTypeName}
  						</option>
					</c:forEach>
                   
                 </select>
				
				<input type="text" placeholder="link image" name="<%=AppRequestAttribute.PRODUCT_LINK_IMG%>">
				
				<button type="submit" class="pure-button pure-button-primary">Add product</button>
				<button type="reset" class="pure-button pure-button-primary">Rest fields</button>
			</form>
			
		</main>
		<br/>
		
		<footer id="footer">
		</footer>
	
	</div>
</body>
</html>