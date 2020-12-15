<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
<title>Admin Add</title>
</head>
<body>
<div class="container">
<h1>Add Ingredients To Database</h1>
<h3>Add Meats</h3>
<form:form method="Post" action="/meats/new" modelAttribute="meat">
	<div class="form-group">
	<form:label path="name">Type of meat:
	<form:errors path="name"/>
	<form:input path="name"/></form:label>
	</div>
	<input type="submit" value="Create"/>
</form:form>
<h3>Add Carbs</h3>
<form:form method="Post" action="/carbs/new" modelAttribute="carb">
	<div class="form-group">
	<form:label path="name">Type of carb:
	<form:errors path="name"/>
	<form:input path="name"/></form:label>
	</div>
	<input type="submit" value="Create"/>
</form:form>
<h3>Add Veggies</h3>
<form:form method="Post" action="/veggies/new" modelAttribute="veggie">
	<div class="form-group">
	<form:label path="name">Type of veggie:
	<form:errors path="name"/>
	<form:input path="name"/></form:label>
	</div>
	<input type="submit" value="Create"/>
</form:form>

<h1>Add Quick Meals</h1>

<!-- trying to add images - doesn't work -->
<!-- <form method="POST" action="/quickmeal/new" enctype="multipart/form-data">
	<div class="form-data">Name of Meal:<input type="text" name="name"></div>
	<div class="form-data"><textarea name="description">Description of meal:</textarea></div>
	<div class="form-data">Price of Meal:<input type="text" name="price"></div>
	<div class="form-data">Select image of meal:<input type="file" name="image"></div>
	<button>Add Quick Meal</button>
</form> -->

<form:form method="Post" action="/quickmeals/new" modelAttribute="quickmeal">
	<div class="form-group">
	<form:label path="name">Name of Meal::
	<form:errors path="name"/>
	<form:input path="name"/></form:label>
	</div>
		<div class="form-group">
	<form:label path="description">Description of Meal:
	<form:errors path="description"/>
	<form:input path="description"/></form:label>
	</div>
		<div class="form-group">
	<form:label path="price">Price of Meal::
	<form:errors path="price"/>
	<form:input path="price"/></form:label>
	</div>
	<input type="submit" value="Create"/>
</form:form>


<h1>Add Available Portions</h1>
<form:form method="Post" action="/portions/new" modelAttribute="portion">
	<div class="form-group">
	<form:label path="measurement">Measurement:
	<form:errors path="measurement"/>
	<form:input path="measurement"/></form:label>
	</div>
		<div class="form-group">
	<form:label path="unit">Unit of Measurement:
	<form:errors path="unit"/>
	<form:input path="unit"/></form:label>
	</div>
	<input type="submit" value="Create"/>
</form:form>
<h1>Add Pickup Locations to Database</h1>
<form:form method="Post" action="/pickuplocations/new" modelAttribute="pickuplocation">
	<div class="form-group">
	<form:label path="companyName">Business Name:
	<form:errors path="companyName"/>
	<form:input path="companyName"/></form:label>
	</div>
		<div class="form-group">
	<form:label path="streetNumber">Street #:
	<form:errors path="streetNumber"/>
	<form:input path="streetNumber"/></form:label>
	<select name="direction">
	<option>N</option>
	<option>S</option>
	<option>E</option>
	<option>W</option>
	</select>
	</div>
			<div class="form-group">
	<form:label path="streetName">Street Name:
	<form:errors path="streetName"/>
	<form:input path="streetName"/></form:label>
	</div>
		<div class="form-group">
	<form:label path="apt">Ste #:
	<form:errors path="apt"/>
	<form:input path="apt"/></form:label>
	</div>
		<div class="form-group">
	<form:label path="city">City:
	<form:errors path="city"/>
	<form:input path="city"/></form:label>
	</div>
		<div class="form-group">
	<form:label path="state">State:
	<form:errors path="state"/>
	<form:input path="state"/></form:label>
	</div>
		<div class="form-group">
	<form:label path="zip">Zip Code:
	<form:errors path="zip"/>
	<form:input path="zip"/></form:label>
	</div>
	<input type="submit" value="Create"/>
</form:form>
</div>



</body>
</html>