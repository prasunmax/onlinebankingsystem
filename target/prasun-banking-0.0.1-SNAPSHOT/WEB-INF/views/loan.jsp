<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<style type="text/css">
.errormsg {
	color: red;
}
</style>
<div class="container">

	<div class="row" style="margin-top: 50px;">
		<div class="col-md-8 col-md-offset-4">
			<h2>Loan Request</h2>
			<hr>
			<div class="col-md-12">
				<c:if test="${not empty loan.error}">
					<div class="form-group">
						<p class="errormsg">
							<spring:message code="laon.eligibility.error" />
						</p>
					</div>
				</c:if>
				<form:form method="post" action="loan" modelAttribute="loan">
					<form:input type="hidden" path="username" name="username" />
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
					<div class="row">
						<div class="col-sm-6 form-group">
							<form:label path="loan_amount" class="control-label"> Loan
							Amount</form:label>
							<form:input type="number" placeholder="Enter Loan Amount"
								class="form-control" path="loan_amount" name="loan_amount"
								required="required" />
							<small><form:errors path="loan_amount"
									cssClass="errormsg" /></small>
						</div>
						<div class="col-sm-6 form-group">
							<form:label class="required" path="loan_type">
								<spring:message code="loan.type" />
							</form:label>
							<div class="form:input-group-btn">
								<form:select class="form-select" path="loan_type"
									name="loan_type" required="required">
									<option>Home Loan</option>
									<option>Car Loan</option>
									<option>Study Loan</option>
								</form:select>
							</div>
							<small><form:errors path="loan_type" cssClass="errormsg" /></small>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6 form-group">
							<form:label path="rateOfInterest" class="control-label">
								<spring:message code="loan.rateOfInterest" />
							</form:label>
							<form:input type="number" placeholder="Enter rate of interest"
								class="form-control" path="rateOfInterest" name="rateOfInterest"
								required="required" />
							<small><form:errors path="rateOfInterest"
									cssClass="errormsg" /></small>
						</div>
						<div class="col-sm-6 form-group">
							<form:label class="required" path="duration">
								<spring:message code="loan.duration" />
							</form:label>
							<div class="form:input-group-btn">
								<form:input type="number" placeholder="Duration in months"
									class="form-control" path="duration" name="duration"
									required="required" />

							</div>
							<small><form:errors path="duration" cssClass="errormsg" /></small>
						</div>
					</div>
					<div class="row">
						<div class="col-sm-6 form-group">
							<form:label class="required" path="loan_date">
								<spring:message code="loan.loan_date" />
							</form:label>
							<div class="input-group date" style="margin-top: 20px;">
								<fmt:formatDate value="${loan_date}" type="date"
									pattern="mm/dd/yyyy" var="loan_date" />
								<form:input type="text" path="loan_date" />
								<div class="input-group-addon">
									<i class="bi bi-calendar"></i>
								</div>
							</div>
							<small><form:errors path="loan_date" cssClass="errormsg" /></small>
						</div>
						<div class="col-sm-6 form-group">
							<form:label class="required" path="emi_start_date">
								<spring:message code="loan.emi_date" />
							</form:label>
							<div class="input-group date" style="margin-top: 20px;">
								<fmt:formatDate value="${emi_start_date}" type="date"
									pattern="mm/dd/yyyy" var="emi_start_date" />
								<form:input type="text" path="emi_start_date" />
								<div class="input-group-addon">
									<i class="bi bi-calendar"></i>
								</div>
							</div>
							<small><form:errors path="emi_start_date"
									cssClass="errormsg" /></small>
						</div>
					</div>
					<div class="col-sm-6 form-group">
						<form:label path="emi_amount" class="control-label">
							<spring:message code="loan.emi_amount" />
						</form:label>
						<form:input type="number" placeholder="Emi amount ..."
							class="form-control" path="emi_amount" name="emi_amount"
							required="required" />
						<small><form:errors path="emi_amount" cssClass="errormsg" /></small>
					</div>
					<div class="form-group">
						<div class="col-md-offset-4 col-md-12" style="margin-top: 20px;">
							<input type="submit" class="btn btn-primary btn-lg"
								value="Submit"></input>
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>