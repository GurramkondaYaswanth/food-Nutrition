<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Food nutrition</title>
<link type="text/css" rel="stylesheet" href="./css/style.css">
</head>
<style>
	/* The container */
.container {
  display: block;
  position: relative;
  padding-left: 35px;
  margin-bottom: 12px;
  cursor: pointer;
  font-size: 22px;
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
}

/* Hide the browser's default radio button */
.container input {
  position: absolute;
  opacity: 0;
  cursor: pointer;
}

/* Create a custom radio button */
.checkmark {
  position: absolute;
  top: 0;
  left: 0;
  height: 25px;
  width: 25px;
  background-color: #eee;
  border-radius: 50%;
}

/* On mouse-over, add a grey background color */
.container:hover input ~ .checkmark {
  background-color: #ccc;
}

/* When the radio button is checked, add a blue background */
.container input:checked ~ .checkmark {
  background-color: #2196F3;
}

/* Create the indicator (the dot/circle - hidden when not checked) */
.checkmark:after {
  content: "";
  position: absolute;
  display: none;
}

/* Show the indicator (dot/circle) when checked */
.container input:checked ~ .checkmark:after {
  display: block;
}

/* Style the indicator (dot/circle) */
.container .checkmark:after {
 	top: 9px;
	left: 9px;
	width: 8px;
	height: 8px;
	border-radius: 50%;
	background: white;
}
	
</style>
<body>
	<nav>
	<img alt="logo" src="../assets/logo.svg">
	<ul>
	<li> <a href="${pageContext.request.contextPath }/login">Login</a></li>
	<li> <a href="${pageContext.request.contextPath }/signup">Sign up</a></li>
	</ul>
	</nav>
	<div class="login-form">
		<div class="title">Login</div>
		<form action="${pageContext.request.contextPath}/login" method="post">
		<div>
		<label class="container">Admin
			<input type="radio" name="radio" id="admin"  value="admin" checked="checked" />
			<span class="checkmark"></span>
		</label>
		<label class="container">customer
			<input type="radio" name="radio" id="user"  value="user" />
			<span class="checkmark"></span>
		</label>
		</div>
		<label class ="label" for="email">Email</label>
		<input type="text" name="email" id="email">
		<label class ="label" for="password">Password</label>
		<input type="password" name="password" id="password">
		<button class="button" type="submit">Login</button>
		<a class="forgot-password" href="">Forgot Password</a>
		</form>
	</div>
	
</body>
</html>