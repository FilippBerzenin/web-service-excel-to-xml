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
		<div class="row align-items-center">
			<!--Add new configuration  -->
			<div class="col-sm-6">
				<div class="form-group">
					<form:form method="post" action="${prefix}/${page}/add/"
						modelAttribute="entity">
						<div align="center">
							<spring:hasBindErrors name="entity">
								<c:forEach var="error" items="${errors.allErrors}">
									<b><spring:message 
										code="${error.code}"
										arguments="${error.arguments}" 
										text="${error.field} ${error.defaultMessage}"/></b>
									<br />
								</c:forEach>
							</spring:hasBindErrors>
						</div>
						<input type="hidden" name="_csrf" value="${_csrf.token}" />
						<h3>Total date</h3>
						<table class="table">
							<thead class="table-info">
								<tr>
									<th>Rezult column</th>
									<th>Resorce column</th>
								</tr>
								<tr>
									<td><form:input path="shop" style="margin-top: 5px" /></td>
								</tr>
								<tr>
									<td><form:input path="name" style="margin-top: 5px" /></td>
								</tr>
								<tr>
									<td><form:input path="company" style="margin-top: 5px" /></td>
								</tr>
								<tr>
									<td><form:input path="url" style="margin-top: 5px" /></td>
								</tr>
								<tr>
									<td><button type="submit" style="margin-top: 5px">Сохранить</button></td>
								</tr>
						</table>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>