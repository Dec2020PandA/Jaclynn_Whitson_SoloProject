<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Food By Fabio - Healthy Nutrition Delivered</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="container">
	<div class="top-banner">
	<img src="/images/Food-by-fabio-banner.png">
	</div>
	<div class="meal-choice">
	<img src="/images/custommeal.jpg">
	<p>Customize your portions to build the body you want.</p>
	<a href="/custommeals" class="btn btn-success">Custom Meals</a>
	</div>
	<div class="meal-choice">
	<img src="/images/pizza.jpg">
	<p>Delicious recipes prepared to perfection to make health taste great!</p>
	<a href="/quickmeals" class="btn btn-success">Quick Meals</a>
	</div>
	<div class="meal-choice">
	<img src="/images/randommeal.jpg">
	<p>Save some cash and let the chef choose your menu for the week!</p>
	<a href="/randommeals" class="btn btn-success">Chef's Choice</a>
	</div>
</div>
</body>
</html>