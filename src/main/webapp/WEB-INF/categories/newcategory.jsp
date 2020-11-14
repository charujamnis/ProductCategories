
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<style>
		.error {color:red}
	</style>
<title>Create a Category</title>
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
	rel="stylesheet" 
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
	crossorigin="anonymous">

</head>
<body>

<div class="container">
	<h2>Add Category </h2>
		<form:form style="width:300px" role="form" method="POST" action="/categories/createcategory" modelAttribute="newcategory">
			<div class="form form-group">
				<form:label path="name">Category Name: </form:label>
				<form:input class="form-control" path="name"/><form:errors path="name" cssClass="error"/>
			</div>
				<input type="submit" value="Create Category"/>
		</form:form>
</div>
</body>
</html>