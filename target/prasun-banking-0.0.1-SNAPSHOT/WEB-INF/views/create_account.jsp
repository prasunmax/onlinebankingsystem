<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<style type="text/css">
.errormsg {
	color: red;
}
</style>
<div class="container">
	<div class="row">
		<div class="account col-md-6 col-md-offset-3">
			<h1 class="well text-center">Create New Account</h1>
			<div class="col-lg-12 well">
				<div class="row">
 					<c:if test="${not empty registrationForm.error}">
						<div class="form-group">
							<p class="errormsg">
								<spring:message code="registration.error" />
							</p>
						</div>
					</c:if> 
					<form:form action="register" method="post"
						modelAttribute="registrationForm">
						<div class="col-sm-12">
							<div class="row">
								<div class="col-sm-6 form-group">
									<form:label class="required" path="first_name">
										<spring:message code="first_name" />
									</form:label>
									<form:input type="text" placeholder="Enter First Name Here.."
										class="form-control" path="first_name" required="required"
										name="first_name" />
									<small><form:errors path="first_name"
											cssClass="errormsg" /></small>
								</div>
								<div class="col-sm-6 form-group">
									<form:label class="required" path="last_name">
										<spring:message code="last_name" />
									</form:label>
									<form:input type="text" placeholder="Enter Last Name Here.."
										class="form-control" path="last_name" name="last_name"
										required="required" />
									<small><form:errors path="last_name"
											cssClass="errormsg" /></small>
								</div>
							</div>
							<div class="form-group">
								<form:label class="required" path="address">
									<spring:message code="address" />
								</form:label>
								<form:textarea placeholder="Enter Address Here.." rows="3"
									path="address" class="form-control" name="address"
									required="required"></form:textarea>
								<small><form:errors path="address" cssClass="errormsg" /></small>
							</div>
							<div class="row">
								<div class="col-sm-4 form-group">
									<form:label path="city">
										<spring:message code="city" />
									</form:label>
									<form:input type="text" placeholder="Enter City Name Here.."
										class="form-control" path="city" name="city" />
									<small><form:errors path="city" cssClass="errormsg" /></small>
								</div>
								<div class="col-sm-4 form-group">
									<form:label class="required" path="branch">
										<spring:message code="branch" />
									</form:label>
									<div class="form:input-group-btn">
										<form:select class="form-select" name="branch" path="branch"
											required="required">
											<option>Kolkata</option>
											<option>Mumbai</option>
											<option>Chennai</option>
											<option>New Delhi</option>
											<option>Jaipur</option>
											<option>Ranchi</option>
											<option>Patna</option>
											<option>Siliguri</option>
										</form:select>
									</div>
									<small><form:errors path="branch" cssClass="errormsg" /></small>
								</div>
								<div class="col-sm-4 form-group">
									<form:label path="zip">
										<spring:message code="zip" />
									</form:label>
									<form:input type="text" placeholder="Enter Zip Code Here.."
										class="form-control" path="zip" name="zip" />
									<small><form:errors path="zip" cssClass="errormsg" /></small>
								</div>
							</div>
							<div class="form-group">
								<form:label path="username" class="required">
									<spring:message code="username" />
								</form:label>
								<form:input type="text" placeholder="Enter User Name Here.."
									class="form-control" path="username" name="username"
									required="required" />
								<small><form:errors path="username" cssClass="errormsg" /></small>
							</div>

							<div class="row">
								<div class="col-sm-6 form-group">
									<form:label class="required" path="password">
										<spring:message code="password" />
									</form:label>
									<form:input type="password" required="required"
										placeholder="Enter Password Here.." min="5" path="password"
										class="form-control" name="password" id="password" />
									<small><form:errors path="password" cssClass="errormsg" /></small>
								</div>
								<div class="col-sm-6 form-group">
									<form:label class="required" path="re_password">
										<spring:message code="re_password" />
									</form:label>
									<form:input type="password" required="required"
										placeholder="Enter Re-password Here.." class="form-control"
										name="re_password" id="re_password" path="re_password"
										onkeyup="checkPass(); return false;" />
									<p id="confirmMessage" style="margin-top: 10x;"></p>
									<small><form:errors path="re_password"
											cssClass="errormsg" /></small>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<form:label class="required" path="phone_number">
										<spring:message code="phone_number" />
									</form:label>
									<form:input type="tel" placeholder="Enter Phone Number Here.."
										path="phone_number" class="form-control" name="phone_number"
										required="required" />
									<small><form:errors path="phone_number"
											cssClass="errormsg" /></small>
								</div>
								<div class="col-sm-6 form-group">
									<form:label class="required" path="pan">
										<spring:message code="pan" />
									</form:label>
									<form:input type="text" placeholder="Pan Number" path="pan"
										class="form-control" name="pan" required="required" />
									<small><form:errors path="pan" cssClass="text-warning" /></small>
								</div>
							</div>
							<div class="row">
								<div class="form-group col-sm-6">
									<form:label class="required" path="email">
										<spring:message code="email" />
									</form:label>
									<form:input type="text"
										placeholder="Enter Email Address Here.." path="email"
										class="form-control" name="email" required="required" />
									<small><form:errors path="email" cssClass="errormsg" /></small>
								</div>
								<div class="col-sm-6 form-group">
									<form:label class="required" path="account_type">
										<spring:message code="account_type" />
									</form:label>
									<div class="form:input-group-btn">
										<form:select class="form-select" path="account_type"
											name="account_type" required="required">
											<option>Saving Account</option>
											<option>Current Account</option>
										</form:select>
									</div>
									<small><form:errors path="account_type"
											cssClass="errormsg" /></small>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-6 form-group">
									<form:label class="required" path="salary">
										<spring:message code="salary" />
									</form:label>
									<form:input type="number"
										placeholder="Enter Intial Amount Here.." class="form-control"
										path="salary" name="salary" required="required" />
									<small><form:errors path="salary" cssClass="errormsg" /></small>
								</div>
								<div class="col-sm-6 form-group">
									<form:label class="required" path="amount">
										<spring:message code="amount" />
									</form:label>
									<form:input type="number"
										placeholder="Enter Intial Deposit Amount Here.." class="form-control"
										path="amount" name="amount" required="required" />
									<small><form:errors path="amount" cssClass="errormsg" /></small>
								</div>
							</div>

							<!-- 							<div class="form-group">
								<span class="text-muted"><em><span
										style="color: red; font-size: 14px">*</span> Indicates
										required field</em> </span>
							</div>
 -->
							<input type="submit" class="btn btn-lg btn-info" />
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>

<%@ include file="common/footer.jspf"%>
