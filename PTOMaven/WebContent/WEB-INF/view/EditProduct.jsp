<%@page import="constantPack.AppSessionAttributes"%>
<%@page import="constantPack.AppRequestAttribute"%>
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
		
		<br/>
		<main>
			<% 
				Product productLocal = (Product)request.getAttribute(AppRequestAttribute.PRODUCT_TEMP); 
				Map<Integer,ProductType> productTypeMap= (Map)request.getAttribute(AppRequestAttribute.MAP_PRODUCT_TYPE);
			%>
			
			<form action="${pageContext.request.contextPath}/SaveEditServlet" method="post" class="pure-form pure-form-aligned">
				
				<h4>Edit Product</h4>
				 <fieldset>
				
				<input type="number" required="required" name="<%=AppRequestAttribute.ID_PRODUCT %>" value="<%=productLocal.getId() %>" readonly hidden>
				<br/>
				<div class="pure-control-group">
				<label>Product name: </label>
				<input type="text" required="required"name="<%=AppRequestAttribute.PRODUCT_NAME %>" value="<%=productLocal.getName() %>" >
				</div>
				<br/>
				<div class="pure-control-group">
				<label>Number of items: </label>
				<input type="number"  required="required" min="1"  name="<%=AppRequestAttribute.PRODUCT_NUMBER_OF_ITEMS %>" value="<%=productLocal.getNumberOfItems() %>" size="4">
				</div>
				<br/>
				<div class="pure-control-group">
				<label>Price: </label>
				<input type="number" required="required" min="1"  step="0.01" name="<%=AppRequestAttribute.PRODUCT_PRICE %>" value="<%=productLocal.getPrice() %>" size="7">
				</div>
				<br/>
				<div class="pure-control-group">
				<label>Product type: </label>
				<select name="<%=AppRequestAttribute.PRODUCT_TYPE_NAME %>" required>
                    <% 	
  						if( productTypeMap!=null){
  							Set<Integer> keySet = productTypeMap.keySet();
  							for(Integer key: keySet){
  					%>
  						<option>
  						<%=productTypeMap.get(key).getProductTypeName() %>
  						</option>
  					<%} }%>
                    </select>
                 </div>   
				<br/>
				
				<img src="<%=productLocal.getLinkImg() %>"/>
				
				<br/>
				<div class="pure-control-group">
				<label>Image link</label>
				<input type="text" name="<%=AppRequestAttribute.PRODUCT_LINK_IMG%>" value="<%=productLocal.getLinkImg() %>" size="35">
				<br/>
				<button type="submit" class="pure-button pure-button-primary">Save edit </button>
				<button type="reset" class="pure-button pure-button-primary">Reset fields</button>
				</div>
				
				
				 </fieldset>
			</form>
			
			
			
			
			
		</main>
		<br/>
		
		<footer id="footer">
		</footer>
	
	</div>
</body>
</html>