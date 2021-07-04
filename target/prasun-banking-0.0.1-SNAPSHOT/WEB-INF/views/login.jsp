<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="container">
	<div class="row">
		<div class="bg-light rounded-3 col-md-6 col-md-offset-3"
			style="margin-top: 50px">
			<h1 style="margin-bottom: 30px" class="col-md-10 col-md-offset-1">Sign
				in to your account</h1>
			<div class="row">
				<div class="col-md-offset-2">
					<c:if test="${not empty loginform.error}">
						<div class="form-group">
							<p class="text-danger">
								<spring:message code="login.error" />
							</p>
						</div>
					</c:if>
					<c:if test="${not empty loginform.success}">
						<div class="form-group">
							<p class="text-success">
								<spring:message code="login.success" />
							</p>
						</div>
					</c:if>
					<form:form method="post" action="login" modelAttribute="loginform">
						<div class="form-group">
							<form:label path="username">
								<spring:message code="username" />*</form:label>
							<form:input type="text" path="username" name="username"
								required="requried" class="form-control" id="username"
								placeholder="User Name" />
							<small><form:errors path="username" cssClass="errormsg" /></small>
						</div>
						<div class="form-group">
							<label for="password"><spring:message code="password" />*</label>
							<input type="password" name="password" required
								class="form-control" id="password" placeholder="Password">
							<small><form:errors path="password" cssClass="errormsg" /></small>
						</div>
						<br />
						<div class="form-group">
							<input type="submit" class="btn btn-primary btn-lg"
								value="Sign to your account"></input>
						</div>
					</form:form>
					New to this web-site!!!!. Please <a href="register">register</a>
					with us.
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>