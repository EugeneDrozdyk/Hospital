<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>

<div class="modal fade" id="assign-doctor" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="">
				<div class="">
					<h3 class="">
						<mytag:message key="admin.assign.doctor" />
					</h3>
				</div>
				<div class="">
					<form method="POST" action="assignDoctor">
						<div class="form-group">
							<select name="doctor" class="form-control">
								<c:forEach var="doctor" items="${doctors }">
									<option value="${doctor.getId() }">${doctor.getLastName() }
										- ${doctor.getFirstName() } - ${doctor.getMiddleName() }</option>
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
