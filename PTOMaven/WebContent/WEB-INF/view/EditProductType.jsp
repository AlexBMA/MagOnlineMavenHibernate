<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="modelMag.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css" rel="stylesheet">
<title>Admin Page</title>
</head>
<body>
	<div id="container">

		<header id="header">

			<h3>
				Welcome admin
				<%=session.getAttribute("userName")%></h3>

			<nav>
				<ul>
					<li>Home</li>

					<li>
						<form
							action="${pageContext.request.contextPath}/ViewAllProductsServlet"
							method="get">
							<button type="submit">Product options</button>
						</form>

					</li>
					<li>
						<form
							action="${pageContext.request.contextPath}/ViewAllProductTypeServlet"
							method="post">
							<button type="submit">ProductType options</button>
						</form>
					</li>
					
					<li>
						<a href="${pageContext.request.contextPath}/ChangePass.jsp">
							<button>Change pass</button> 
						</a>
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
		<hr/>
		<br/>
		<main> 
		<%
			ProductType temp = (ProductType)request.getAttribute("producttype");
		%>
			<form action="${pageContext.request.contextPath}/SaveEditProductTypeServlet" method="post">
				<input type="number" readonly value="<%=temp.getId() %>" name="idproducttype" hidden>
				<br/>
				<input type="text" value="<%=temp.getProductTypeName() %>" name="nameofproducttype" size="20">
				<button type="submit">Save edit</button>
			</form>


		</main>
		<br/>
		<hr/>
		<footer id="footer"> </footer>
	</div>
</body>
</html>