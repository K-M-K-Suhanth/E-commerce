<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
html, body { 
height: 100%; 
padding: 1em; 
margin: 05; 
box-sizing:border-box;
  -moz-box-sizing:border-box;
  -webkit-box-sizing:border-box;
  
}
divi { width: 25%; height: 50%; float: left; }
#divi1 { background: white; }
button{ background: #777;}
</style>
<title>Insert title here</title>
</head>
<body>
	<div class="row" >
	
<c:forEach items="${listProducts}" var="product"> 

	  <divi id="divi1">
	  
<img src="C:\Users\Suhanth\eclipse-workspace\BatteryDhunia\src\main\webapp\resources\images\${product.productId}.jpg" alt="now here" height="100" width="150">
<p>P.Id<b>${product.productId }</b></p>
<a href="<c:url value="/displayproducts/${product.productId}"/>"><p><b>${product.productName }</b></p></a>
<p>Price: <b>${product.price }</b></p>    
</divi>
	  </c:forEach>
  </div>
</body>
</html>
<%@include file="footer.jsp" %>