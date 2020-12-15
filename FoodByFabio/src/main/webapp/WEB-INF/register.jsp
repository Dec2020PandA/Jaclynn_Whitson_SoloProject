<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register To Deliciousness</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
<link rel="stylesheet" href="/css/style.css">
</head>
<div class="container">
<div class="background">
<img src="/images/Food-by-fabio-banner.png">
<div id="register">
<h1>Welcome</h1>
<div class="row">
<div class="col">
<h3>Register</h3>
<form:form action="/register" method="post" modelAttribute="user" id="register-form" class="justify-content-center">
			    <div class="form-row">
			    <div class="form-group col-md-6">
			        <form:label path="firstName">First Name</form:label>
			        <form:errors path="firstName"/>
			        <form:input class="form-control" path="firstName"/>
			    </div>
			    <div class="form-group col-md-6">
			        <form:label path="lastName">Last Name</form:label>
			        <form:errors path="lastName"/>
			        <form:input class="form-control" path="lastName"/>
			    </div>
			    <div class="form-group col-md-12">
			        <form:label path="email">Email</form:label>
			        <form:errors path="email"/>
			       <form:input type="email" class="form-control" path="email"/>
			    </div>
			    <div class="form-groupc col-md-6">
			        <form:label path="password">Password</form:label>
			        <form:errors path="password"/>
			       <form:input type="password" class="form-control" path="password"/>
			    </div>
			    <div class="form-group col-md-6">
			        <form:label path="confirmPassword">Confirm Password</form:label>
			        <form:errors path="confirmPassword"/>
			       <form:input type="password" class="form-control" path="confirmPassword"/>
			    </div>
			    <input class="btn btn-success" type="submit" value="Register!"/>
</div>
</form:form>
</div>
</div>
</div>
</div>
</div>
</body>
</html>