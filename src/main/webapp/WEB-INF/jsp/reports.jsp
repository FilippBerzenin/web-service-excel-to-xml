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
      .error {
         color: #ff0000;
      }

      .errorblock {
         color: #000;
         background-color: #ffEEEE;
         border: 3px solid #ff0000;
         padding: 8px;
         margin: 16px;
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
		<div class="align-items-center">
			<h3>Формирование сводки</h3>
			<c:if test="${not empty message}">
			<br>
				<div class="alert alert-success">${message}</div>
			</c:if>
			<br>
			<div>
				<form:form action="${prefix}/reports/createRequest"
					modelAttribute="requestFor" method="post">
					<div class="row">
						<div class="col-sm">
							<form:input class="form-control" type="date"
								path="dateStartSearch" />
						</div>
						<div class="col-sm">
							<form:input class="form-control" type="date"
								path="dateFinishSearch" />
						</div>
						<div class="col-sm">
							<form:select path="typeReqest">
								<form:options items="${objectTypes}" itemValue="value" />
							</form:select>
						</div>
					</div>
					<div class="row align-items-center" style="margin-top: 10px">
					<div class="col-sm">
						<input type="submit" value="Сформировать сводку" />
					</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>