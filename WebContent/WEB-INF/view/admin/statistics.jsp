<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>

<div class="clearfix">
	<div class="col-md-12">
		<div>
			<a href="home" type="button" class="btn btn-success back-home"><mytag:message
					key="admin.home.back" /></a>
			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th><mytag:message key="admin.home.last_name" /></th>
						<th><mytag:message key="admin.home.first_name" /></th>
						<th><mytag:message key="admin.home.middle_name" /></th>
						<th><mytag:message key="admin.home.date_of_birth" /></th>
						<th><mytag:message key="admin.home.email" /></th>
						<th><mytag:message key="admin.home.login" /></th>
						<th><mytag:message key="admin.home.amount" /></th>
					</tr>
				</thead>
				<tbody>
					<c:set var="count" value="0" scope="page" />
					<c:forEach var="account" items="${accounts }">
						<tr data-id="${account.getId() }">
							<td class="name">${account.getLastName() }</td>
							<td>${account.getFirstName() }</td>
							<td>${account.getMiddleName() }</td>
							<td>${account.getDateOfBirth() }</td>
							<td>${account.getEmail() }</td>
							<td>${account.getLogin() }</td>
							<td>${statistics.get(count)}</td>
						</tr>
						<c:set var="count" value="${count + 1}" scope="page" />
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</div>