<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<style type="text/css">
.errormsg {
	color: red;
}

.successmsg {
	color: green;
}
</style>
<div class="container">
	<div class="row" style="margin-top: 50px;">
		<div class="col-md-offset-4">
			<c:if test="${not empty profile.error}">
				<c:if test="${profile.error == 'success'}">
					<div class="form-group">
						<p class="successmsg">
							<spring:message code="reset.success" />
						</p>
					</div>
				</c:if>
				<c:if test="${profile.error == 'error'}">
					<div class="form-group">
						<p class="errormsg">
							<spring:message code="reset.error" />
						</p>
					</div>
				</c:if>
			</c:if>
			<form:form role="form" modelAttribute="profile">
				<h2>Change Password</h2>
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
				<form:label path="password" class="control-label">
					<spring:message code="reset.new.password" />
				</form:label>
				<div class="col-sm-8 form-group">
					<form:input type="password" required="required"
						placeholder="Enter New Password.." path="password"
						class="form-control" id="password" />
				</div>

				<form:label path="re_password" class="control-label">
					<spring:message code="reset.new.re_password" />
				</form:label>
				<div class="col-sm-8 form-group">
					<form:input type="password" required="required"
						placeholder="Enter Re-Password.." path="re_password"
						class="form-control" id="re_password"
						onkeyup="checkPass(); return false;" />
				</div>
				<p id="confirmMessage" class="text-center" style="margin-top: 10x;"></p>

				<div class="col-md-12">
					<hr class="colorgraph">
				</div>
				<div class="row col-md-10 col-md-offset-1">
					<div class="col-xs-6 col-md-6">
						<input type="submit" value="Submit"
							class="btn btn-success btn-block btn-md" tabindex="7">
					</div>
					<div class="col-xs-6 col-md-6">
						<input class="btn btn-danger btn-block btn-md" type="reset"
							value="Clear">
					</div>
				</div>
			</form:form>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>