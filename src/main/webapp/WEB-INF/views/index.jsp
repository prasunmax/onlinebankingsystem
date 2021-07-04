<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container" style="margin-top: 0 px;">
	<div class="row">
		<div class="col-md-12">
			<div id="carouselExampleIndicators" class="carousel slide"
				data-bs-ride="carousel">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleIndicators"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
				</div>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="image/Current-Deposit1.jpg" class="d-block w-100"
							alt='<spring:message code="welcome.message"/>'>
					</div>
					<div class="carousel-item">
						<img src="image/Savings-Deposit1.jpg" class="d-block w-100"
							alt='<spring:message code="todo.caption" />'>
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>
		</div>
	</div>
	<div class="row">&nbsp;</div>
	<div class="row">
		<div class="col-6">
			<h2 class="text-center text-medium">
				<spring:message code="loan.scheme" />
			</h2>
			<p>
				<spring:message code="loan.scheme.desc" />
			</p>
			<div class="col-md-4 offset-md-4">
				<a type="button" class="btn btn-default btn-lg" href="loan.jsp"
					style="border-radius: 24px;">Learn more..</a>
			</div>
		</div>
		<div class="col-6">
			<h2 class="text-center text-medium">
				<spring:message code="deposit.scheme" />
			</h2>
			<p>
				<spring:message code="deposit.scheme.desc" />
			</p>
			<div class="scheme-button col-4 offset-md-4">
				<a type="button" class="btn btn-default btn-lg"
					href="deposit_scheme.jsp" style="border-radius: 24px;">Learn
					more..</a>
			</div>
		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>