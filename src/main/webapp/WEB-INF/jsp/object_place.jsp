<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/dopstyle.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
<script src="/js/bootstrap.min.js"></script>
<c:set var="prefix" value="${pageContext.request.contextPath}" />
<c:set var="page" value="${page}" />
<title>Object(place) page</title>
</head>
<body>
	<div class="container">
			<div>
				<c:if test="${not empty message}">
			<div class="alert alert-success">${message}</div>
		</c:if>
		</div>
		<section class="inputObject">
			<div class="container">
			<h3>Add new object:</h2>
				<div class="row">
					<div class="form-group">
						<form:form method="post" action="${prefix}/object_place/create/"
							modelAttribute="entityFor">
							<table>
								<tr>
									<td><font color="red"><form:errors path="name" /></font></td>
									<td><form:input path="name" placeholder="object(place)" /></td>
									<td><button type="submit">Add new object</button></td>
								</tr>
							</table>
						</form:form>
					</div>
				</div>
			</div>
		</section>
		<section class="listOfObject">
			<div class="container">
			<h2>Objects list:</h2>
			<table class="table table-hover">
			<thead class="table-info">
				<tr>
					<th>#</th>
					<th>ID</th>
					<th>Object name</th>
					<th>Objects photo</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="object_place" items="${listOfEntites}" varStatus="counter">
					<tr>
						<td>${counter.count}</td>
						<td>${object_place.id}</td>
						<td>${object_place.name}</td>
						<td>${object_place.photos}</td>
						<td>
							<form action="${prefix}/object_place/delete/${object_place.id}" method="post">
								<button type="submit" name="delete" value="Delete">Delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
			</div>
		</section>
	</div>
</body>
</html>