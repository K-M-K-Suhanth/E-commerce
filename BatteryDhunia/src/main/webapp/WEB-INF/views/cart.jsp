<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
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
  color:blue;
}
</style>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
    <table align="center" class="table" >
        <tr>
        <th>Pimag</th>
            <th>ProductName</th>
            <th>Quantity</th>
            <th>Price</th>
        <th>SubTotal</th>
            <th>Update</th>
        </tr>
        <c:if test="${not empty listCartItems}">
		<c:forEach items="${listCartItems}" var="cartItem">
		<tr>
<td><img src="C:\Users\Suhanth\eclipse-workspace\BatteryDhunia\src\main\webapp\resources\images\product-list3.jpg" alt="now here" height="30" width="30"></td>
<td><a href="#"><i>${cartItem.productname}</i></a></td>
<td><b>${cartItem.quantity }</b></td>
<td><b>${cartItem.price}</b></td>
<td><b>${cartItem.price * cartItem.quantity }</b></td>
<td><a href="<c:url value="/deleteCartItem/${cartItem.cartId}"/>"><span class="glyphicon glyphicon-trash"></span></a></td>
</tr>
</c:forEach>
</c:if>
		<c:if test="${empty listCartItems}">
			<tr ><td><center>You Have No Items in Cart</center></td></tr>
		</c:if>
        <tr>
			<td colspan="3">Total Cost</td>
			<td>${cartItem.totalCost}</td>
			<td colspan="2"></td>
		</tr>
		<tr>
			<td colspan="3"><a href="/BatteryDhunia/displayproducts"><b>Continue Shopping</b></a></td>
			<td colspan="3"><a href="/BatteryDhunia/orderconfirm"><b>Checkout</b></a></td>
		</tr>
    </table>
<jsp:include page="footer.jsp"/>
</body>
</html>