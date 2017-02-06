<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>

<div class="modal fade" id="update-account" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<c:if test="${updatingError != null }">
				<div class="alert alert-danger updating" role="alert">${updatingError }</div>
			</c:if>

			<div class="">
				<div class="">
					<h3 class="">
						<mytag:message key="admin.edit" />
					</h3>
				</div>
				<div class="">
					<form class="edit-account-form" method="POST" action="editAccount">
						<div class="form-group">
							<input name="password" type="password" class="form-control"
								id="exampleInputPassword"
								placeholder=<mytag:message key="admin.edit.password"/>>
						</div>
						<div class="form-group">
							<input name="firstName" class="form-control"
								id="exampleInputEmail"
								placeholder=<mytag:message key="admin.edit.last_name"/>>
						</div>
						<div class="form-group">
							<input name="lastName" class="form-control"
								id="exampleInputEmail"
								placeholder=<mytag:message key="admin.edit.first_name"/>>
						</div>
						<div class="form-group">
							<input name="middleName" class="form-control"
								id="exampleInputEmail"
								placeholder=<mytag:message key="admin.edit.middle_name"/>>
						</div>
						<div class="form-group hide">
							<input name="currentId" class="form-control">
						</div>
						<div class="text-center">
							<button type="submit" class="btn btn-default">
								<mytag:message key="admin.update" />
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
