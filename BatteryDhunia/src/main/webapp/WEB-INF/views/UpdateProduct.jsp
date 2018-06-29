<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Product Information</h2>
     
          <c:url value="/UpdateProduct" var="update"/>  
      <form action=${update} method="get">
	<table align="center">
	<tr>
			<td>Product Id</td>
			<td><input type="text" readonly id="productId" name="productId" value="${productInfo.productId}" /></td>
		</tr>
<tr>
			<td>Category Id</td>
			<td><input type="text" readonly id="categoryId" name="categoryId" value="${productInfo.categoryId}" /></td>
		</tr>
		<tr>
			<td>Product Name</td>
			<td><input type="text" id="proname" name="proname" value="${productInfo.productName}" /></td>
		</tr><tr>
		<td>Product Desc</td>
		<td><input type="text" id="prodesc" name="prodesc" value="${productInfo.prodDesc}" /></td>
		</tr>
		<tr>
		<td>Product Cost</td>
		<td><input type="text" id="procost" name="procost" value="${productInfo.price}"/></td>
		</tr>		
		
				
		<tr>
			<td colspan="2"><input type="submit" value="SUBMIT" /> <input
				type="reset" value="RESET" /></td>
		</tr>
	</table>
</form>      
            
        <table align="center" border=1px;>
	<tr>
		<td>product ID</td>
		<td>category ID</td>
		<td>product Name</td>
		<td>product Desc</td>
		<td>product cost</td>
		<td>Operation</td>
	</tr>
	<c:forEach items="${listProducts}" var="product">
		<tr>
			<td>${product.productId}</td>
			<td>${product.categoryId}</td>
			<td>${product.productName}</td>
			<td>${product.prodDesc}</td>
			<td>${product.price}</td>
			
			<td><a
				href="<c:url value="/updateProduct/${product.productId}"/>">Update</a>/
				<a href="<c:url value="/deleteProduct/${product.productId}"/>">Delete</a>
			</td>
		</tr>
	</c:forEach>
	
</table>      
      
</body>
</html>
<jsp:include page="footer.jsp"></jsp:include>