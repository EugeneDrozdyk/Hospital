<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<c:if test="${loginError != null }">
				<div class="alert alert-danger" role="alert">${loginError }</div>
			</c:if>
			<div class="">
				<div class="">
					<h3 class="">
						<mytag:message key="login.welcome" />
					</h3>
				</div>
				<div class="">
					<form method="POST" action="login">
						<div class="form-group">
							<input name="login" class="form-control" id="exampleInputEmail"
								placeholder=<mytag:message key="login.login"/>>
						</div>
						<div class="form-group">
							<input name="password" type="password" class="form-control"
								id="exampleInputPassword"
								placeholder=<mytag:message key="login.password"/>>
						</div>
						<div class="form-group">
							<select name="role" class="form-control">
								<option value="1"><mytag:message key="login.admin" /></option>
								<option value="2"><mytag:message key="login.doctor" /></option>
								<option value="3"><mytag:message key="login.nurse" /></option>
								<option value="4"><mytag:message key="login.patient" /></option>
							</select>
						</div>
						<div class="checkbox">
							<label> <input type="checkbox" name="remember"
								value="true"> <mytag:message key="login.remember" />
							</label>
						</div>
						<div class="text-center">
							<button type="submit" class="btn btn-default btn-submit-enter">
								<mytag:message key="login.submit" />
							</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>