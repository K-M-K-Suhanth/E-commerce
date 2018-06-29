<%@include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Insert title here</title>
</head>
<body>
 <c:url value="/conforminsertproduct" var="url"></c:url> 

<form action="${url}" method="get" enctype="multipart/form-data">
	<table align="center">
		<tr>
		<td>Product Name</td>
		<td><input type="text" id="proname" name="proname" /></td>
		</tr><tr>
		<td>Product Desc</td>
		<td><input type="text" id="prodesc" name="prodesc" /></td>
		</tr>
		<tr>
		<td>Product Cost</td>
		<td><input type="text" id="procost" name="procost" /></td>
		</tr><tr>
		<td>category id</td>
		<td><input type="text" id="catid" name="catid" /></td>
		</tr>
		<tr>
		<td>supplier id</td>
		<td><input type="text" id="supid" name="supid" /></td>
		</tr>
		<!-- <td>Product Image</td>
			<td>
				<input type="file" path="pimage"/>
			</td> -->
		<tr>
		<td></td>
			<td colspan="2"><input type="submit" value="SUBMIT" /> <input
				type="reset" value="RESET" /></td>
		</tr>
	</table>
</form>
<br/>
<table align="center" border=1px;>
	<tr>
		<th>Product ID</th>
		<th>Product Name</th>
		<th>Product Desc</th>
		<th>Product Price</th>
		<th>Category ID</th>
		<th>Operation</th>
	</tr>
	<c:forEach items="${listProducts}" var="product">
	
		<tr>
			<td><c:out value="${product.productId}"/></td>
			<td>${product.productName}</td>
			<td>${product.prodDesc}</td>
			<td>${product.price}</td>
			<td>${product.categoryId}</td>
			<td><a href="<c:url value="/updateProduct/${product.productId}"/>">Update</a>
				<a href="<c:url value="/deleteProduct/${product.productId}"/>">Delete</a>
			</td>
		</tr>
	</c:forEach>	
</table>           

</body>
</html>
<jsp:include page="footer.jsp"/>