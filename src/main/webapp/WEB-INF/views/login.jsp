<%@ include file="./header.jspf"%>

<h4>Existing users login here</h4>
<hr>

<form method="POST">
	<div class="form-group row">
		<label for="email" class="col-md-4">Email</label>
		<div class="col-md-8">
			<input type="email" class="form-control" name="email" id="email" value="${param.email}">
			<!-- For errors -->
			<div class="text-danger">${errors.email}</div>
		</div>
	</div>
	<br>
	<div class="form-group row">
		<label for="password" class="col-md-4">Password</label>
		<div class="col-md-8">
			<input type="password" class="form-control" name="password"
				id="password">
			<!-- For errors -->
			<div class="text-danger">${errors.password}</div>
		</div>
	</div>
	<br>
	<div class="form-group row">
		<label class="col-md-4"></label>
		<div class="col-md-8">
			<button class="btn btn-primary">Login</button>
			<input type="reset" class="btn btn-link" value="Reset">
		</div>
	</div>
</form>

<%@ include file="./footer.jspf"%>