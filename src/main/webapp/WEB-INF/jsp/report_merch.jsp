<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
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
</head>
<body>

	<div class="jumbotron text-center" style="margin-bottom: 0">
		<h1>Logo</h1>
	</div>

	<div class="container" align="center" style="margin-top: 30px">	
			<h1>Сводка по мерчам(объектам)</h1>
		<div class="row align-items-center">
		<!--List of merchs  -->
		<div class="col-sm-6">
		<table class="table table-hover table-sm">
			<thead class="table-info">
				<tr>
					<th>ФИО</th>
					<c:forEach var="data" items="${listOfDates}">
						<th>"${data}"</th>
					</c:forEach>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="merch" items="${listOfMerchs}">
					<tr>
						<td>${merch.merch.name}</td>
						<td> 					
<%-- 							<c:forEach var="fotos" items="${merch.photos[${data}]}">
							<c:if test=test="${not empty message}">
								<th>For</th>
							</c:if>
							</c:forEach> --%>
<%-- 						<td>
							<form action="${prefix}/merch_inner/show/${merch.id}"
								method="get">
								<button type="submit" name="update" value="update">Update</button>
							</form>	
						</td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			</div>
		</div>
	</div>
</body>
</html>