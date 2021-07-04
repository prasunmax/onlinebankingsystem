<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<style type="text/css">
.errormsg {
	color: red;
}
</style>
<div class="container">
	<div class="jumbotron col-md-6 col-md-offset-3"
		style="margin-top: 50px">
		<div class="row">
			<div class="col-md-6">
				<div class="card" style="width: 18rem;">
					<img class="img-circle img-responsive card-img-top" alt=""
						src="image/user.png">
					<div class="card-body">
						<h2>${profile.first_name}&nbsp;${profile.last_name}</h2>
						<ul class="list-group">
							<li class="list-group-item"><i class="bi bi-map"></i>
								${profile.getBranch()}</li>
							<li class="list-group-item"><i class="bi bi-house"></i>${profile.getAddress()}</li>
							<li class="list-group-item"><i class="bi bi-telephone"></i>${profile.getPhone_number()}</li>
							<li class="list-group-item"><i class="bi bi-envelope"></i>${profile.getEmail()}</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="account_details col-md-6 col-md-offset-1"
				style="margin-top: 30px;">
				<h2>Account Details</h2>
				<hr class="divider">
				<table class="table table-user-information col-md-10">
					<tbody>
						<tr>
							<td><b>First Name:</b></td>
							<td>${profile.first_name}</td>
						</tr>
						<tr>
							<td><b>Last Name:</b></td>
							<td>${profile.last_name}</td>
						</tr>
						<tr>
							<td><b>Account Number:</b></td>
							<td>${profile.getAccount_no()}</td>
						</tr>
						<tr>
							<td><b>City</b></td>
							<td>${profile.getCity()}</td>
						</tr>
						<tr>
							<td><b>Branch Name</b></td>
							<td>${profile.getBranch()}</td>
						</tr>
						<tr>
							<td><b>Postal Code</b></td>
							<td>${profile.getZip()}</td>
						</tr>
						<tr>
							<td><b>UserName</b></td>
							<td>${profile.getUsername()}</td>
						</tr>
						<tr>
							<td><b>Phone Number</b></td>
							<td>${profile.getPhone_number()}</td>
						</tr>
						<tr>
							<td><b>Email</b></td>
							<td><a href="mailto:" ${profile.getEmail()}>${profile.getEmail()}</a></td>
						</tr>
						<tr>
							<td><b>Account Type</b></td>
							<td>${profile.getAccount_type()}</td>
						</tr>
						<tr>
							<td><b>Registration Date</b></td>
							<td><fmt:formatDate value="${profile.reg_date}"
									type="date" pattern="dd-MMM-yyyy" /></td>
						</tr>
						<tr>
							<td><b>Amount</b></td>
							<td>&#8377;${profile.getAmount()}</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>

<%@ include file="common/footer.jspf"%>