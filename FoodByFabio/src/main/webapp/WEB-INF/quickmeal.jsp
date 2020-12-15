<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Food By Fabio - Quick Meals</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
<t:wrapper>

<form method="Post" action="/addQuickMeal/">

	<div class="card">
			<c:forEach var="meal" items="${quickMeals}">
<input type="hidden" name="meal" value="${meal.id}"/>
  <img class="card-img-top" src="${meal.image_url}" >
  <div class="card-body">
    <h4 class="card-title" value="${meal.id}"> ${meal.name}</h4>
    <p class="card-text">
      ${meal.description}
    </p>
    <select name="quantity" id="quantity" onChange="updatePrice(event)">
    <option value='1'>1</option>
    <option value='2'>2</option>
    <option value='3'>3</option>
    <option value='4'>4</option>
    <option value='5'>5</option>
    </select>
        <p id="price">$${meal.price}0</p>
        <p id="total"></p>
    <button class="btn btn-primary">Add to Cart</button> 
    	  </c:forEach>
  </div>
  </form>
  <hr>
  

<hr>
  

</div>
<script type="text/javascript" src="/js/custom.js"></script>
</t:wrapper>
</body>
</html>