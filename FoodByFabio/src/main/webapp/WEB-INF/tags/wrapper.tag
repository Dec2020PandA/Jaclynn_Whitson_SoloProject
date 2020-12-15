<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<html>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Food By Fabio - Healthy Nutrition Delivered</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">
</head>
<body>
<div class ="container">
	<div class="top-banner">
	<img src="/images/Food-by-fabio-banner.png">
	</div>
<div id="home-links">
<h1>Welcome ${user.firstName} ${user.lastName}</h1>
<p><a href="/home">Home</a>   |   <a href="/logout">Logout</a></p>
</div>
	<jsp:doBody/>
</div>
</body>
</html>