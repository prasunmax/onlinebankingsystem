<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div class="row" style="margin-top: 50px;">
		<div class="col-md-offset-4">
			<c:if test="${not empty profile.error}">
				<c:if test="${profile.error == 'success'}">
					<div class="form-group">
						<p class="text-success">
							<spring:message code="reset.success" />
						</p>
					</div>
				</c:if>
				<c:if test="${profile.error == 'error'}">
					<div class="form-group">
						<p class="text-danger">
							<spring:message code="reset.error" />
						</p>
					</div>
				</c:if>
			</c:if>
			<form:form role="form" modelAttribute="profile">
				<h2><spring:message code="reset.profile" /></h2>
				<div class="col-md-12">
					<hr class="colorgraph">
				</div>
				<form:label path="cur_pass" class="control-label">
					<spring:message code="reset.password" />
				</form:label>
				<div class="col-sm-8 form-group">
					<form:input type="password" required="required" path="cur_pass"
						placeholder="Enter Current Password.." class="form-control" />
				</div>
				<div class="row">
					<div class="col-sm-6 form-group">
						<form:label path="password" class="control-label">
							<spring:message code="reset.new.password" />
						</form:label>
						<form:input type="password" required="required"
							placeholder="Enter New Password.." path="password"
							class="form-control" id="password" />
					</div>
					<div class="col-sm-6 form-group">
						<form:label path="re_password" class="control-label">
							<spring:message code="reset.new.re_password" />
						</form:label>
						<form:input type="password" required="required"
							placeholder="Enter Re-Password.." path="re_password"
							class="form-control" id="re_password"
							onkeyup="checkPass(); return false;" />
						<p id="confirmMessage" class="text-center"
							style="margin-top: 10x;"></p>
					</div>
				</div>
				<div class="form-group">
					<form:label class="required" path="email">
						<spring:message code="email" />
					</form:label>
					<form:input type="text" placeholder="Enter Email Address Here.."
						path="email" class="form-control" name="email" required="required" />
					<small><form:errors path="email" cssClass="errormsg" /></small>
				</div>
				<div class="row">
					<div class="col-sm-6 form-group">
						<form:label class="required" path="first_name">
							<spring:message code="first_name" />
						</form:label>
						<form:input type="text" placeholder="Enter First Name Here.."
							class="form-control" path="first_name" required="required"
							name="first_name" />
						<small><form:errors path="first_name" cssClass="errormsg" /></small>
					</div>
					<div class="col-sm-6 form-group">
						<form:label class="required" path="last_name">
							<spring:message code="last_name" />
						</form:label>
						<form:input type="text" placeholder="Enter Last Name Here.."
							class="form-control" path="last_name" name="last_name"
							required="required" />
						<small><form:errors path="last_name" cssClass="errormsg" /></small>
					</div>
				</div>

				<div class="col-md-12">
					<hr class="colorgraph">
				</div>
				<div class="row col-md-10 col-md-offset-1">
					<div class="col-xs-6 col-md-6">
						<input type="submit" value="Submit"
							class="btn btn-success btn-block btn-md" tabindex="7">
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>