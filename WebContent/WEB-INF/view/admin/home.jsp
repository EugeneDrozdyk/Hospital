<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>

<div class="clearfix">
	<div class="navigation col-md-2">
		<ul class="navigation__list">
			<li class="navigation__item"><a class="navigation__link"
				href="showAccounts?idRole=2"><mytag:message
						key="admin.home.doctors"></mytag:message></a>
				<ul class="sub-menu">
					<c:forEach var="category" items="${categories }">
						<li class="sub-menu__item"><a class="sub-menu__link"
							href="showAccounts?idRole=2&idCategory=${category.getId() }">${category.getName()}</a>
						</li>
					</c:forEach>
				</ul></li>
			<li class="navigation__item"><a class="navigation__link"
				href="showAccounts?idRole=3"><mytag:message
						key="admin.home.nurses"></mytag:message></a></li>
			<li class="navigation__item"><a class="navigation__link"
				href="showAccounts?idRole=4"><mytag:message
						key="admin.home.patients"></mytag:message></a></li>
			<li class="navigation__item"><a class="navigation__link"
				href="#" data-toggle="modal" data-target="#add-account"><mytag:message
						key="admin.home.add" /></a></li>
			<li class="navigation__item"><a class="navigation__link"
				href="statistic"><mytag:message key="admin.home.statistics" />
			</a></li>
		</ul>
	</div>

	<c:if test="${sessionScope.accounts.size() == 0}">
		<div class="empty__list">
			<h3>
				<mytag:message key="list.empty"></mytag:message>
			</h3>
		</div>
	</c:if>

	<c:if test="${sessionScope.accounts.size() != 0  && accounts != null}">
		<div class="col-md-10">
			<div>
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th><mytag:message key="admin.home.last_name" /></th>
							<th><mytag:message key="admin.home.first_name" /></th>
							<th><mytag:message key="admin.home.middle_name" /></th>
							<th><mytag:message key="admin.home.date_of_birth" /></th>
							<th><mytag:message key="admin.home.email" /></th>
							<th><mytag:message key="admin.home.login" /></th>
							<th><mytag:message key="admin.home.actions" /></th>
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
								<td class="tac">
									<div class="btn-group" role="group" aria-label="...">
										<c:if test="${account.isAssigned() == true }">
											<a href="#" type="button"
												class="btn btn-success edit-account" data-toggle="modal"
												data-target="#update-account"><mytag:message
													key="admin.home.edit" /></a>
										</c:if>
										<c:if test="${account.isAssigned() == false }">
											<a href="#" type="button"
												class="btn btn-success edit-account" data-toggle="modal"
												data-target="#assign-doctor"><mytag:message
													key="admin.assign.doctor" /></a>
										</c:if>
										<a href="deleteAccount?id=${account.getId() }"
											onclick="return confirm('<mytag:message
											key="admin.home.sure"/>')"
											type="button" class="btn btn-danger"><mytag:message
												key="admin.home.delete" /></a>
									</div>
								</td>
							</tr>
							<c:set var="count" value="${count + 1}" scope="page" />
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>

		<c:if test="${sessionScope.idRole != null}">
			<div class="dropdown">
				<button class="btn btn-default dropdown-toggle" type="button"
					id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="true">
					<mytag:message key="admin.home.sort" />
					<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
					<li><a href="showAccounts?idSort=1"><mytag:message
								key="admin.home.sort.abc" /></a></li>
					<li><a href="showAccounts?idSort=2"><mytag:message
								key="admin.home.sort.date" /></a></li>
				</ul>
			</div>
		</c:if>
	</c:if>

</div>