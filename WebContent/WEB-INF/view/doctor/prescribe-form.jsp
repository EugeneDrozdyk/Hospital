<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>

<div class="modal fade" id="assign-treatment" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<c:if test="${prescribeError != null }">
				<div class="alert alert-danger prescribe" role="alert">${prescribeError }</div>
			</c:if>
			<div class="">
				<div class="">
					<h3 class="">
						<mytag:message key="doctor.home.therapy" />
					</h3>
				</div>
				<div class="">
					<form method="POST" action="prescribe">
						<div class="form-group">
							<input name="diagnosis" class="form-control"
								id="exampleInputEmail"
								placeholder=<mytag:message key="doctor.home.diagnosis"/>>
						</div>
						<div class="form-group" class="form-control">
							<label><mytag:message key="doctor.home.proc"></mytag:message></label>
						</div>
						<div class="form-group">
							<select name="procedure" class="form-control">
								<option value="0"><mytag:message
										key="doctor.home.select" /></option>
								<c:forEach var="procedure" items="${procedures }">
									<option value="${procedure.getId() }">${procedure.getName() }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group" class="form-control">
							<label><mytag:message key="doctor.home.pils"></mytag:message></label>
						</div>
						<div class="form-group">
							<select name="medicament" class="form-control">
								<option value="0"><mytag:message
										key="doctor.home.select" /></option>
								<c:forEach var="medicament" items="${medicaments }">
									<option value="${medicament.getId() }">${medicament.getName() }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group" class="form-control">
							<label><mytag:message key="doctor.home.operation"></mytag:message></label>
						</div>
						<div class="form-group">
							<select name="operation" class="form-control">
								<option value="0"><mytag:message
										key="doctor.home.select" /></option>
								<c:forEach var="operation" items="${operations }">
									<option value="${operation.getId() }">${operation.getName() }</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group hide">
							<input name="currentId" class="form-control">
						</div>
						<div class="text-center">
							<button type="submit" class="btn btn-default">
								<mytag:message key="admin.assign" />
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>