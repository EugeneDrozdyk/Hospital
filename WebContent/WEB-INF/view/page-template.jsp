<!-- Template for all JSP pages -->
<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="hospital" tagdir="/WEB-INF/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/SummaryTask4/style/css/bootstrap.css">
<link rel="stylesheet" href="/SummaryTask4/style/css/app.css">
</head>
<body>
	<jsp:include page="admin/registration-form.jsp"></jsp:include>
	<jsp:include page="admin/updating-form.jsp"></jsp:include>
	<jsp:include page="admin/assignment-form.jsp"></jsp:include>

	<jsp:include page="doctor/prescribe-form.jsp"></jsp:include>

	<header>
		<img src="/SummaryTask4/style/image/logo-epam.png">
		<c:if test="${sessionScope.CURRENT_ACCOUNT == null}">
			<button type="button" class="btn btn-primary inout-button"
				data-toggle="modal" data-target="#myModal">
				<mytag:message key="page-template.login" />
			</button>
		</c:if>
		<c:if test="${sessionScope.CURRENT_ACCOUNT != null}">
			<a href="/SummaryTask4/logout" type="button"
				class="btn btn-primary inout-button"><mytag:message
					key="page-template.logout" /></a>
		</c:if>
	</header>

	<c:if test="${sessionScope.CURRENT_ACCOUNT == null}">
		<jsp:include page="welcome-carousel.jsp" />
	</c:if>

	<div>
		<jsp:include page="${currentPage }" />
	</div>

	<hospital:footer>

	</hospital:footer>

	<script type="text/javascript"
		src="/SummaryTask4/style/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript"
		src="/SummaryTask4/style/js/bootstrap.js"></script>
	<script type="text/javascript" src="/SummaryTask4/style/js/app.js"></script>
</body>
</html>