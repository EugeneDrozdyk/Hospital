<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>

<div class="modal fade" id="add-account" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<c:if test="${registrationError != null }">
				<div class="alert alert-danger registration" role="alert">${registrationError }</div>
			</c:if>

			<div class="">
				<div class="">
					<h3 class="">
						<mytag:message key="admin.registration" />
					</h3>
				</div>
				<div class="">
					<form method="POST" action="addAccount">
						<div class="form-group">
							<input name="login" class="form-control" id="exampleInputEmail"
								placeholder=<mytag:message key="admin.home.login"/>>
						</div>
						<div class="form-group">
							<input name="password" type="password" class="form-control"
								id="exampleInputPassword"
								placeholder=<mytag:message key="admin.registration.password"/>>
						</div>
						<div class="form-group">
							<input name="lastName" class="form-control"
								id="exampleInputEmail"
								placeholder=<mytag:message key="admin.home.last_name"/>>
						</div>
						<div class="form-group">
							<input name="firstName" class="form-control"
								id="exampleInputEmail"
								placeholder=<mytag:message key="admin.home.first_name"/>>
						</div>
						<div class="form-group">
							<input name="middleName" class="form-control"
								id="exampleInputEmail"
								placeholder=<mytag:message key="admin.home.middle_name"/>>
						</div>
						<div class="form-group">
							<input name="email" class="form-control" id="exampleInputEmail"
								placeholder=<mytag:message key="admin.home.email"/>>
						</div>
						<div class="form-group">
							<input name="dateOfBirth" class="form-control"
								id="exampleInputEmail"
								placeholder=<mytag:message key="admin.home.date_of_birth"/>>
						</div>

						<div class="form-group">
							<select name="role" class="form-control select-profession">
								<option value="4"><mytag:message key="login.patient" /></option>
								<option value="2"><mytag:message key="login.doctor" /></option>
								<option value="3"><mytag:message key="login.nurse" /></option>
							</select>
						</div>

						<div class="form-group category-doctor">
							<select name="category" class="form-control">
								<c:forEach var="category" items="${categories }">
									<option value="${category.getId() }">${category.getName() }</option>
								</c:forEach>							
							</select>
						</div>
						
						<div class="text-center">
							<button type="submit" class="btn btn-default">
								<mytag:message key="admin.registration.book" />
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
