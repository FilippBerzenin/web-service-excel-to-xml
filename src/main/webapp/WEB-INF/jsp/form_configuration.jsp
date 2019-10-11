<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<script src="/js/form_configuration.js"></script>
<style>
.fakeimg {
	height: 200px;
	background: #aaa;
}
</style>
<c:set var="prefix" value="${pageContext.request.contextPath}" />
<c:set var="page" value="${page}" />
<c:set var="merch" value="${entity}" />
<title>Form for input new configuration</title>
</head>
<body>

	<div class="jumbotron text-center" style="margin-bottom: 0">
		<h1>Logo</h1>
	</div>

	<div class="container" align="center" style="margin-top: 30px">
		<div align="left">
			<a href="${prefix}/">Menu</a>
		</div>
		<div align="center">
			<c:if test="${message != null}">
				<div class="alert alert-warning">"${message}"</div>
			</c:if>
		</div>
		<!--Add new configuration  -->
		<form:form method="post" action="${prefix}/${page}/add/"
			modelAttribute="entity">
			<div class="form-group">
				<div class="col-sm-6">
					<div align="center">
						<spring:hasBindErrors name="entity">
							<c:forEach var="error" items="${errors.allErrors}">
								<b><spring:message code="${error.code}"
										arguments="${error.arguments}"
										text="${error.field} ${error.defaultMessage}" /></b>
								<br />
							</c:forEach>
						</spring:hasBindErrors>
					</div>
					<input type="hidden" name="_csrf" value="${_csrf.token}" />
					<button type="submit" style="margin-top: 5px">Save
						configuration</button>
					<h3>Total date</h3>
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="text-center">Rezult column</th>
								<th class="text-center">Resorce column</th>
								<th class="text-center">If use excel resorces</th>
								<th class="text-center">Excel list</th>
								<th class="text-center">Excel cell</th>
							</tr>
						</thead>
						<tr class="align-middle text-center">
							<td class="align-middle text-center"><form:label path="shop">Shop</form:label></td>
							<td class="align-middle text-center"><form:input
									path="shop.name" /></td>
							<td class="align-middle text-center"><form:checkbox
									path="shop.excelData" /></td>
							<td class="align-middle text-center"><form:input
									path="shop.listFromExcelBook" /></td>
							<td class="align-middle text-center"><form:input
									path="shop.cellFromExcelBook" /></td>
						</tr>
						<tr class="align-middle text-center">
							<td class="align-middle text-center"><form:label path="name">Name</form:label></td>
							<td class="align-middle text-center"><form:input
									path="name.name" /></td>
							<td class="align-middle text-center"><form:checkbox
									path="name.excelData" /></td>
							<td class="align-middle text-center"><form:input
									path="name.listFromExcelBook" /></td>
							<td class="align-middle text-center"><form:input
									path="name.cellFromExcelBook" /></td>
						</tr>
						<tr class="align-middle text-center">
							<td class="align-middle text-center"><form:label
									path="company">Company</form:label></td>
							<td class="align-middle text-center"><form:input
									path="company.name" /></td>
							<td class="align-middle text-center"><form:checkbox
									path="company.excelData" /></td>
							<td class="align-middle text-center"><form:input
									path="company.listFromExcelBook" /></td>
							<td class="align-middle text-center"><form:input
									path="company.cellFromExcelBook" /></td>
						</tr>
						<tr class="align-middle text-center">
							<td class="align-middle text-center"><form:label path="url">URL</form:label></td>
							<td class="align-middle text-center"><form:input
									path="url.name" /></td>
							<td class="align-middle text-center"><form:checkbox
									path="url.excelData" /></td>
							<td class="align-middle text-center"><form:input
									path="url.listFromExcelBook" /></td>
							<td class="align-middle text-center"><form:input
									path="url.cellFromExcelBook" /></td>
						</tr>
						<tr class="align-middle text-center">
							<td class="align-middle text-center"><form:label
									path="platform">Platform (Optional element)</form:label></td>
							<td class="align-middle text-center"><form:input
									path="platform.name" /></td>
							<td class="align-middle text-center"><form:checkbox
									path="platform.excelData" /></td>
							<td class="align-middle text-center"><form:input
									path="platform.listFromExcelBook" /></td>
							<td class="align-middle text-center"><form:input
									path="platform.cellFromExcelBook" /></td>
						</tr>
						<tr class="align-middle text-center">
							<td class="align-middle text-center"><form:label
									path="currencies">Currencies (UAH)</form:label></td>
							<td class="align-middle text-center"><form:input
									path="currencies.name" /></td>
							<td class="align-middle text-center"><form:checkbox
									path="currencies.excelData" /></td>
							<td class="align-middle text-center"><form:input
									path="currencies.listFromExcelBook" /></td>
							<td class="align-middle text-center"><form:input
									path="currencies.cellFromExcelBook" /></td>
						</tr>
					</table>
				</div>
				<div class="col-sm-6">
					<table id="currencies">
						<thead>
							<tr>
								<th class="text-center">Currencie id</th>
								<th class="text-center">Currencies name</th>
							</tr>					
					</thead>
						<tr>
							<td><input type="text" value="1"></td>
							<td><input type="text" value="UAH"></td>
							<td><input type="button" value="Add new currencie" onclick="addCurrencie();"></td>
						</tr>
					</table>
					<button type="button" onclick="saveCurrencies();">Save currencies</button>
				</div>
				<div>
					<table>
						<thead>
							<tr>
								<th class="text-center">Categorie name</th>
								<th class="text-center">Categorie id</th>
								<th class="text-center">Parent categorie id</th>
							</tr>
						</thead>
						
						<tr>
						<span id="categories"></span>
						<td><button type="button" value="add categorie" onclick="addCat();">Add categorie</button></td>
						</tr>
					</table>
				</div>
			</div>
		</form:form>
	</div>

</body>
</html>