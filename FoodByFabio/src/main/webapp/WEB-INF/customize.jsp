<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Food By Fabio - Customize Meals</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
<t:wrapper>
	<div class="top">
		<h1>Customize Your Meal</h1>
		<p>For those who have goals they need to crush - whether it's a body building show, upcoming fight, or doctor's orders. We will do the weighing and measuring to keep you on track.</p>
	</div>
<div id="custom">
<form:form method="Post" action="/addCustomMeal" modelAttribute="customMeal">
	<div class="form-group">
	<select onchange="meatChange(event)" name="meats">
	
		<c:forEach var="protein" items="${meats}">
			<option value="${protein.id}">${protein.name}</option>
		</c:forEach>
	</select>
	<select name="portions">
		<c:forEach var="size" items="${portions}">
			<option value="${size.id}">${size.measurement} ${size.unit}</option>
		</c:forEach>
	</select>
	</div>
	<div class="form-group">
	<select name="carbs">
		<c:forEach var="carb" items="${carbs}">
			<option value="${carb.id}">${carb.name}</option>
		</c:forEach>
	</select>
	<select name="portions">
		<c:forEach var="size" items="${portions}">
			<option value="${size.id}">${size.measurement} ${size.unit}</option>
		</c:forEach>
	</select>
	</div>
		<div class="form-group">
	<select name="veggies">
		<c:forEach var="veg" items="${veggies}">
			<option value="${veg.id}">${veg.name}</option>
		</c:forEach>
	</select>
	<select name="portions">
		<c:forEach var="size" items="${portions}">
			<option value="${size.id}">${size.measurement} ${size.unit}</option>
		</c:forEach>
	</select>
	</div>
	<input type="submit" class="btn btn-success" value="Add To Cart"/>
</form:form>
<img id="meatimage" src="/images/steak2.jpg" >
</div>
<script type="text/javascript" src="/js/custom.js"></script>
</t:wrapper>
</body>
</html>