<jsp:include page="header.jsp"/>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
   <style>
   /* Popup container - can be anything you want */
.popup {
    position: relative;
    display: inline-block;
    cursor: pointer;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
}

/* The actual popup */
.popup .popuptext {
    visibility: hidden;
    width: 160px;
    background-color: #555;
    color: #fff;
    text-align: center;
    border-radius: 6px;
    padding: 8px 0;
    position: absolute;
    z-index: 1;
    bottom: 125%;
    left: 50%;
    margin-left: -80px;
}

/* Popup arrow */
.popup .popuptext::after {
    content: "";
    position: absolute;
    top: 100%;
    left: 50%;
    margin-left: -5px;
    border-width: 5px;
    border-style: solid;
    border-color: #555 transparent transparent transparent;
}

/* Toggle this class - hide and show the popup */
.popup .show {
    visibility: visible;
    -webkit-animation: fadeIn 1s;
    animation: fadeIn 1s;
}

/* Add animation (fade in the popup) */
@-webkit-keyframes fadeIn {
    from {opacity: 0;} 
    to {opacity: 1;}
}

@keyframes fadeIn {
    from {opacity: 0;}
    to {opacity:1 ;}
}
   </style>
   <script>
// When the user clicks on div, open the popup
   function myFunction() {
       var popup = document.getElementById("myPopup");
       popup.classList.toggle("show");
   }
   </script>
<div class="container">
	<table class="table" align="center">
	<tr>
		<td rowspan="6">
		<img src="<c:url value="/resources/images/${product.productId}.jpg"/>" width="300" height="300"/>
		</td>
		<td>Product ID</td><td>${product.productId}</td>
	</tr>
	<tr>
		<td>Price</td>
		<td>${product.price}</td>
	</tr>
	<tr>
		<td>Product Name</td>
		<td>${product.productName}</td>
	</tr>	
	<tr>
		<td>Category</td>
		<td>${product.categoryId}</td>
	</tr>
	<tr>
		<td>Description</td>
		<td>${product.prodDesc}</td>
	</tr>
	<tr>
		<td colspan="2">
		
			<form action="<c:url value="/addtocart/${product.productId}"/>" method="get">
				<table>
					<tr><td>Quantity</td>
						<td>
						<select name="quantity">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
						</td>
						<td>
						<div class="popup" onclick="myFunction()"><input type="submit" value="AddToCart" class="btn btn-success btn-block"/>
  <span class="popuptext" id="myPopup">Added to cart!</span>
</div>
						
						</td>
				</table>
			</form>
		
		</td>
	</tr>
	
	</table>
</div>
<jsp:include page="footer.jsp"/>