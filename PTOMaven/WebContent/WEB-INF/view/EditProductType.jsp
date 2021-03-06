<%@page import="constantPack.AppRequestAttribute"%>
<%@page import="constantPack.AppSessionAttributes"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="modelMag.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://unpkg.com/purecss@0.6.2/build/pure-min.css" integrity="sha384-UQiGfs9ICog+LwheBSRCt1o5cbyKIHbwjWscjemyBMT9YCUMZffs6UqUTd0hObXD" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css" rel="stylesheet">
<title>Admin Page</title>
</head>
<body>
	<div id="container">

		<header id="header">

			<h3>Welcome admin ${sessionScope[AppSessionAttributes.USERNAME]}</h3>

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
		<hr/>
		<br/>
		<main> 
		<%
			ProductType temp = (ProductType)request.getAttribute(AppRequestAttribute.TEMP_PRODUCT_TYPE);
		%>
			<form action="${pageContext.request.contextPath}/SaveEditProductTypeServlet" method="post"  class="pure-form" >
				<input type="number" readonly value="<%=temp.getId()%>" name="<%=AppRequestAttribute.PRODUCT_TYPE_ID%>" hidden>
				<br/>
				<input type="text" value="<%=temp.getProductTypeName() %>" name="<%=AppRequestAttribute.PRODUCT_TYPE_NAME %>" size="20">
				<button class="pure-button pure-button-primary" type="submit">Save edit</button>
			</form>


		</main>
		<br/>
		<hr/>
		<footer id="footer"> </footer>
	</div>
</body>
</html>