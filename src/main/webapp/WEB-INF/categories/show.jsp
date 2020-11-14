<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">
<title>Products and Categories</title>
</head>
<body>
	<div class="container">
		<nav>
			<h3><a href="/">Products</a> | <a href="/categories/category">Categories</a></h3>
		</nav>
		<h2>${ category.name }</h2>
		<h3>Products: </h3>
		<ul>
			<c:forEach items="${ category.products }" var="prod">
				<li>${ prod.name }</li>
			</c:forEach>
		</ul>
		<h3>Add Product ${ catgory.name } </h3>
		<form:form action="/associations/categories" method="POST" modelAttribute="association">
			<form:input type="hidden" path="category" value="${category.id}"/>
			<div class="form-group">
				<form:label path="product">Product</form:label>
				<form:errors path="product"/>
				<form:select class="form-control" path="product">
		        <c:forEach items="${ notInProducts }" var="nonProd">
		        	<option value=${ nonProd.id }>${ nonProd.name }</option>
		        </c:forEach>
		        </form:select>
		    </div>
		    <button class="btn btn-primary">Add</button>
		</form:form>
	</div>
</body>
</html>