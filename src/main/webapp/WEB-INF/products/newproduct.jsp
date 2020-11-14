<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
	<style>
		.error {color:red}
	</style>
<meta charset="ISO-8859-1">
<title>Create a Product</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">

</head>
<body>

<div class="container">
	<h2>Add Product </h2>
	<form:form style="width:300px" role="form" method="POST" action="/products/createproduct" modelAttribute="newproduct">
			<div class="form form-group">
				<form:label path="name">Product Name: </form:label>
				<form:input class="form-control" path="name"/><form:errors path="name" cssClass="error"/>
			</div>
			<div class="form form-group">
				<form:label path="description">Description: </form:label>
				<form:input  class="form-control" path="description"/><form:errors path="description"/>
			</div>

			<div class="form form-group">
				<form:label path="price">Price: </form:label>
				<form:input class="form-control" path="price"/><form:errors path="price"/>
			</div>
				<input type="submit" value="Create Product"/>
</form:form>
</div>
</body>
</html>