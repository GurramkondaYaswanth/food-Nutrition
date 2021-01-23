<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
        <div>Food Nutrition</div>
        <ul>
        	 <li> <a href="${pageContext.request.contextPath}/allfooditems">All FoodItems</a></li>
             <li> <a href="${pageContext.request.contextPath}/login">Login</a></li>
            <li> <a href="${pageContext.request.contextPath}/signup">Sign Up</a></li>
         </ul>
    </nav>
    
    
    <div class="body-div1">
      
     <div >
        <input id="foodtitle" name="FoodItemWord" placeholder="FoodItem Name" type="text">
         <a href="${pageContext.request.contextPath}/search"> <button class="searchbtn"  > Search</button></a> 
   </div>
           
  <a href="${pageContext.request.contextPath}/new"> 
  <button class="button" id="addBlog" ><i class="fas fa-plus-circle"></i>Add Food-Item</button>
  </a>  
    </div >
    
 
    
    

<div class="body-div2">
   <%--
  <div >
        <input id="foodtitle" name="FoodItemWord" placeholder="FoodItem Name" type="text">
         <a href="search?FoodItemWord=<c:out value='%= request.getParameter("FoodItemWord")%' />"> <button class="searchbtn"  > Search</button></a> 
   </div> 
   --%>
 

<c:forEach var="FoodItem" items="${listFoodItems}">
      <div class="article-card">
            <img src="./assets/${FoodItem.getFoodItemTitle()}.jpg" alt="${FoodItem.getFoodItemTitle()}" class="foodpics" style="width:250px;height:200px">
            <div class="card-text">
                <h1 id="blog-title"><c:out value="${FoodItem.getFoodItemTitle()}"  /></h1>
                <p id="blog-description"><c:out value="${FoodItem.getFoodItemDescription()}" /></p>
            </div>
      	  <div class="card-buttons">
             <a href="edit?id=<c:out value='${FoodItem.getFoodItemId()}' />"><button type="button" id="edit">EDIT</button></a> <span>|</span><a href="delete?id=<c:out value='${FoodItem.getFoodItemId()}'/>"><button id="delete">DELETE</button></a>
            </div>
        </div>
     </c:forEach> 
</div>

</body>
</html>