<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row" style="margin-top: 50px;">
		<div class="col-md-8 col-md-offset-2">
			<h3><spring:message code="loan.requests" /></h3>
			<form:form method="get" action="loans" modelAttribute="loan">
				<div class="col-sm-6 form-group">
					<h4>
						<form:label class="required" path="loan_type">
							<spring:message code="loan.type" />
						</form:label>
					</h4>
					<form:select class="form-select" path="loan_type" name="loan_type"
						id='loan_type' required="required" onchange="this.form.submit()">
						<option value="Home Loan">Home Loan</option>
						<option value="Car Loan">Car Loan</option>
						<option value="Study Loan">Study Loan</option>
					</form:select>
				</div>
			</form:form>
			<div class="table-responsive" style="margin-top: 40px">
				<table id="mytable" class="table table-bordred table-striped">
					<thead>
						<tr>
							<th>First Name</th>
							<th>Last Name</th>
							<th>Account No</th>
							<th>Loan Type</th>
							<th>Loan Date</th>
							<th>Amount</th>
							<sec:authorize access="hasRole('ADMIN')">
								<th>Approve</th>
								<th>Reject</th>
							</sec:authorize>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${loan.loan}" var="l">
							<tr>
								<td>${l.getFirst_name()}</td>
								<td>${l.getLast_name()}</td>
								<td>${l.getAccount_no()}</td>
								<td>${l.loan_type}</td>
								<td><fmt:formatDate value="${l.loan_date}" type="date"
										pattern="dd-MMM-yyyy" /></td>
								<td>${l.getLoan_amount()}</td>
								<sec:authorize access="hasRole('ADMIN')">
									<td><button class="btn btn-success">Approve</button>
									<td><button class="btn btn-danger">Reject</button>
								</sec:authorize>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<script>
$(function(){
	$('#loan_type').find('option[value="${loan.loan_type}"]').attr("selected",true);
});
</script>
<%@ include file="common/footer.jspf"%>