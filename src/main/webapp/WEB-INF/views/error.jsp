<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	Application has encountered an error. Please contact support on ...
	${requestScope['javax.servlet.error.message']}
	
</div>

<%@ include file="common/footer.jspf"%>
