<%@ include file="./header.jspf" %>

<h4>New user registration form</h4>
<h7>Welcome to the family</h7>
<hr>

<form method="POST">
	<div class="form-group row">
		<label for="name" class="col-md-4">Name</label>
		<div class="col-md-8">
			<input type="text" class="form-control" name="name" id="name">
			<!-- For errors -->
			<div class="text-danger">${errors.name}</div>
		</div>
	</div>
	<br>
	<div class="form-group row">
		<label for="email" class="col-md-4">Email</label>
		<div class="col-md-8">
			<input type="email" class="form-control" name="email" id="email">
			<!-- For errors -->
			<div class="text-danger">${errors.email}</div>
		</div>
	</div>
	<br>
	<div class="form-group row">
		<label for="password" class="col-md-4">Password</label>
		<div class="col-md-8">
			<input type="password" class="form-control" name="password" id="password">
			<!-- For errors -->
			<div class="text-danger">${errors.password}</div>
		</div>
	</div>
	<br>
	<div class="form-group row">
		<label for="c_password" class="col-md-4">Confirm Password</label>
		<div class="col-md-8">
			<input type="password" class="form-control" name="c_password" id="c_password">
			<!-- For errors -->
			<div class="text-danger">${errors.c_password}</div>
		</div>
	</div>
	<br>
	<div class="form-group row">
		<label class="col-md-4"></label>
		<div class="col-md-8">
			<button class="btn btn-primary">Register</button>
			<input type="reset" class="btn btn-link" value="Reset">
		</div>
	</div>
</form>



<%@ include file="./footer.jspf"%>

