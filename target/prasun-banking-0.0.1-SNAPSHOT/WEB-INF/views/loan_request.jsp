<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row" style="margin-top: 50px;">
		<div class="col-md-8 col-md-offset-2">
			<h3>Loan Requests</h3>
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
							<th>Approve</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${loan}" var="l">
							<tr>
								<td>${l.getFirst_name()}</td>
								<td>${l.getLast_name()}</td>
								<td>${l.getAccount_no()}</td>
								<td>${l.loan_type}</td>
								<td><fmt:formatDate value="${l.loan_date}" type="date"
										pattern="dd-MMM-yyyy" /></td>
								<td>${l.getLoan_amount()}</td>
								<td><p data-placement="top" data-toggle="tooltip"
										title="Approve"></p></td>
								<td><p data-placement="top" data-toggle="tooltip"
										title="Delete"></p></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>