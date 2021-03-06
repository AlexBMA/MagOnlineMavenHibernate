<%@page import="constantPack.AppRequestAttribute"%>
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
	   rel="stylesheet" />
      
<title>Client Page</title>

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
						<form action="${pageContext.request.contextPath}/LogoutServlet" method="get" class="pure-form">
							<button type="submit" class="pure-button pure-button-primary">Log out</button>	
						</form>
						
					</li>
				</ul>
			</nav>
			<br/>
		</header>
		<br/>
		<main id="cart">
		
			<c:set var="theCart" value="${sessionScope[AppSessionAttributes.CART]}"></c:set>
			<c:set var="msg" value="${sessionScope[AppRequestAttribute.MSG]}"></c:set>
			
			<c:if test="${msg !=null}">
				<h4>${msg}</h4>
			</c:if>
			
			<c:forEach items="${theCart.productsFromCart}" var="temp"  varStatus="loop">
					<img src="" id="cosimg"/>
					<label>Number of items ${temp.cantitateComandata}</label>
					<label>Price of items </label>
					<form action="${pageContext.request.contextPath}/DeleteProductFromCartServlet" method="post" class="pure-form">
					<input type="text" readonly hidden  value="${loop.index}" name="<%=AppRequestAttribute.INDEX_OF_PRODUCT%>"/>
					<button type="submit" class="pure-button pure-button-primary" >Delete product from cart</button>
				</form>
			
			</c:forEach>
			
		
			<h4>${theCart.totalPriceOfCart}</h4>
			
			<form action="${pageContext.request.contextPath}/SaveCartServlet" method="post" class="pure-form">
			
				<button type="submit" class="pure-button pure-button-primary">Save cart</button>
			</form>
		</main>
		<br/>
		<footer id="footer">
		
		
		</footer>
	
	</div>
</body>
</html>