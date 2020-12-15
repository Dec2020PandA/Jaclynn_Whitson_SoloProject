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
<div class="background">
	<img src="/images/Food-by-fabio-banner.png"><img src="/images/LoginPageMealMed.jpg">
	<div id="login" class="text-center">
		<div class="col">
			<h1 class="font-weight-bolder text-white">Login</h1>
			<p class="font-weight-bolder text-white">${loginError}</p>

			<form method="POST" action="/login" class="form-inline justify-content-center">
		<div class="form-group mb-2">
			<label class="font-weight-bolder text-white">Email:</label>
			<input class="form-control" type="email" name="lEmail">
		</div>
		<div class="form-group mb-2">
			<label class="font-weight-bolder text-white justify-content-center">Password:</label>
			<input class="justify-content-center" type="password" name="lPassword">
		</div>
		<button class="btn btn-success">Login</button>
		</form>
	</div>
	</div>
	<p id="register-link" class="float-right">Not a member? <a href="/register">Register</a> for deliciousness delivered!
</div>
</div>
</body>
</html>