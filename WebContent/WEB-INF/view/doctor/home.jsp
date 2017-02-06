<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>

<div class="clearfix">
	<div class="navigation col-md-2">
		<ul class="navigation__list">
			<li class="navigation__item"><a class="navigation__link"
				href="showAccounts?id=1"><mytag:message
						key="doctor.home.patients"></mytag:message></a></li>
			<li class="navigation__item"><a class="navigation__link"
				href="showAccounts?id=2"><mytag:message
						key="doctor.home.procedures"></mytag:message></a></li>
			<li class="navigation__item"><a class="navigation__link"
				href="showAccounts?id=3"><mytag:message
						key="doctor.home.medicaments"></mytag:message></a></li>
			<li class="navigation__item"><a class="navigation__link"
				href="showAccounts?id=4"><mytag:message
						key="doctor.home.operations"></mytag:message></a></li>
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
							<c:if test="${sessionScope.id == 2}">
								<th><mytag:message key="doctor.home.diagnosis" /></th>
								<th><mytag:message key="doctor.home.procedure" /></th>
							</c:if>
							<c:if test="${sessionScope.id == 3}">
								<th><mytag:message key="doctor.home.diagnosis" /></th>
								<th><mytag:message key="doctor.home.pil" /></th>
							</c:if>
							<c:if test="${sessionScope.id == 4}">
								<th><mytag:message key="doctor.home.diagnosis" /></th>
								<th><mytag:message key="doctor.home.oper" /></th>
							</c:if>
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
								<c:if test="${sessionScope.id >= 2}">
									<td>${info.get(count).getDiagnosis() }</td>
									<td>${info.get(count).getTreatment() }</td>
								</c:if>
								<td class="tac">
									<div class="btn-group" role="group" aria-label="...">
										<c:if test="${sessionScope.id == 1}">
											<a href="#" type="button"
												class="btn btn-success edit-account" data-toggle="modal"
												data-target="#assign-treatment"><mytag:message
													key="doctor.home.accept" /></a>
										</c:if>
										<c:if test="${sessionScope.id == 2}">
											<a href="perform?id=${account.getId() }&idService=2"
												type="button" class="btn btn-success edit-account"><mytag:message
													key="doctor.home.perform" /></a>
										</c:if>
										<c:if test="${sessionScope.id == 3}">
											<a href="perform?id=${account.getId() }&idService=3"
												type="button" class="btn btn-success edit-account"><mytag:message
													key="doctor.home.perform" /></a>
										</c:if>
										<c:if test="${sessionScope.id == 4}">
											<a href="perform?id=${account.getId() }&idService=4"
												type="button" class="btn btn-success edit-account"><mytag:message
													key="doctor.home.perform" /></a>
										</c:if>
									</div>
								</td>
							</tr>
							<c:set var="count" value="${count + 1}" scope="page" />
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</c:if>
</div>