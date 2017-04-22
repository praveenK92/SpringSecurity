<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h1>Title : ${title}</h1>
	<h1>Message : ${message}</h1>
	
	<sec:authorize access="hasRole('ROLE_USER')">
		<div>I have USER Rights too bro!</div>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_ADMIN')">
		<div>I have ADMIN Rights too bro!</div>
	</sec:authorize>
	<sec:authorize access="hasRole('ROLE_DBA')">
		<div>I have DBA Rights too bro!</div>
	</sec:authorize>
	
	<sec:authorize access="isAuthenticated() and principal.username=='sasuke'">
		<div>Sakura LOVES Sasuke</div>
	</sec:authorize>

	<sec:authorize access="hasRole('ROLE_USER')">
		<!-- For login user -->
		<c:url value="/logout" var="logoutUrl" />
		<form action="${logoutUrl}" method="post" id="logoutForm">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
		</form>
		<script>
			function formSubmit() {
				document.getElementById("logoutForm").submit();
			}
		</script>

		<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>
				User : ${pageContext.request.userPrincipal.name} | <a
					href="javascript:formSubmit()"> Logout</a>
			</h2>
		</c:if>


	</sec:authorize>
</body>
</html>