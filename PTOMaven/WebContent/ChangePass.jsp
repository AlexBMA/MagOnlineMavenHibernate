<%@page import="constantPack.AppSessionAttributes"%>
<%@page import="constantPack.AppRequestAttribute"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://unpkg.com/purecss@0.6.2/build/pure-min.css" integrity="sha384-UQiGfs9ICog+LwheBSRCt1o5cbyKIHbwjWscjemyBMT9YCUMZffs6UqUTd0hObXD" crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="${pageContext.request.contextPath}/resources/css/style.css"
	type="text/css" rel="stylesheet">
</head>
<body>
	<div id="container">
		<header id="header">
		<h3>Welcome admin <%=session.getAttribute(AppSessionAttributes.USERNAME)%></h3>
			
		
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
			<br/>
		
			<form action="${pageContext.request.contextPath}/ChangePass" method="post" class="pure-form">
				<input type ="password" placeholder="new pass" name="<%=AppRequestAttribute.NEW_PASS%>">
				<input type="password" placeholder="new pass again" name="<%=AppRequestAttribute.NEW_PASS2%>">
				<button type="submit" class="pure-button pure-button-primary">Submit </button>
				<button type="reset" class="pure-button pure-button-primary">Reset</button>
			</form>
		
		</main>
		<br/>
		<footer id="footer">
		</footer>
	</div>
</body>
</html>