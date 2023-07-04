<%@ include file="./header.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div>
	<c:forEach items="${requestScope.contacts}" var="c">
		<div class="card col-md-4">
			<img src="${c.avatar = ''?'./assets/images/harbajan.png':c.avatar}" class="card-img-top" alt="${c.firstname} ${c.lastname}">
			<div class="card-body">
				<h5 class="card-title">${c.firstname} ${c.lastname}</h5>
				<p class="card-text">${c.city} ${c.state}</p>
				<a href="./view-contact-details?id=${c.id}" class="btn btn-primary">View details</a>
			</div>
		</div>
		<br>
	</c:forEach>
</div>

<%@ include file="./footer.jspf"%>