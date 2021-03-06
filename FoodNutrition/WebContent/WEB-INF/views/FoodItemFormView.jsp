<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Food Nutrition</title>
<link rel="stylesheet" href="./css/blog.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.12.1/css/all.min.css">
</head>
<body>
 	<nav>
        <img src="./assets/logo.svg" alt="logo" />
        <ul>
        	 <li> <a href="${pageContext.request.contextPath}/allfooditems">All FoodItems</a></li>
             <li> <a href="${pageContext.request.contextPath}/login">Login</a></li>
            <li> <a href="${pageContext.request.contextPath}/signup">Sign Up</a></li>
         </ul>
    </nav>
    
    <form action="${pageContext.request.contextPath}/new" id="form" method="post" name="form">
    <input id="title" name="title" placeholder="Title" type="text">
    <textarea id="msg" name="message" placeholder="Description"></textarea>
    <button id="post" type="submit">Post</button>
    </form>
</body>
</html>



