<%@include file="header.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<table align="center">
	<form:form method="post" action="InsertProduct"
		modelAttribute="product" enctype="multipart/form-data">
		<tr>
			<td>Product Name</td>
			<td><form:input path="productName" />
		</tr>
		<tr>
			<td>Category</td>
			<td>
			<form:select path="categoryId">
				<form:option value="0" label="--select--"/>
				<form:option value="1" label="automotive"/>
				<form:option value="2"  label="industries"/>
				<form:option value="3"  label="homeups"/>
				<form:options items="${categoryList}"/>
			</form:select>
			</td>
		</tr>
		<tr>
			<td>Supplier</td>
			<td><form:input path="supplierId"/></td>
		</tr>
		<tr>
			<td>Price</td>
			<td><form:input path="price"/></td>
		</tr>
		<tr>
			<td>Product Description</td>
			<td><form:input path="prodDesc"/></td>
		</tr>
		<tr>
			<td>Product Image</td>
			<td>
				<form:input type="file" path="pimage"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="Insert Product"/>
			</td>
		</tr>

	</form:form>
</table>