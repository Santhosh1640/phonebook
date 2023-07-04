<%@ include file="./header.jspf"%>

<h4>${title!=null ? title : 'Contact form' }</h4>  <!-- If title exists use title otherwise use 'Contact form'-->
<hr>

<form method="POST">
	<div class="form-group row">
		<label for="firstname" class="col-md-4">First Name</label>
		<div class="col-md-8">
			<input type="text" class="form-control" name="firstname" id="firstname" value="${contact.firstname}">
			<!-- For errors -->
			<div class="text-danger">${errors.firstname}</div>
		</div>
	</div>
	<br>

	<div class="form-group row">
		<label for="lastname" class="col-md-4">Last Name</label>
		<div class="col-md-8">
			<input type="text" class="form-control" name="lastname" id="lastname" value="${contact.lastname}">
			<!-- For errors -->
			<div class="text-danger">${errors.lastname}</div>
		</div>
	</div>
	<br>

	<div class="form-group row">
		<label for="email" class="col-md-4">Email</label>
		<div class="col-md-8">
			<input type="email" class="form-control" name="email" id="email"value="${contact.email}">
			<!-- For errors -->
			<div class="text-danger">${errors.email}</div>
		</div>
	</div>
	<br>

	<div class="form-group row">
		<label for="phone" class="col-md-4">Phone</label>
		<div class="col-md-8">
			<input type="text" class="form-control" name="phone" id="phone" value="${contact.phone}">
			<!-- For errors -->
			<div class="text-danger">${errors.phone}</div>
		</div>
	</div>
	<br>

	<div class="form-group row">
		<label for="avatar" class="col-md-4">Avatar</label>
		<div class="col-md-8">
			<input type="text" class="form-control" name="avatar" id="avatar" value="${contact.avatar}">
			<!-- For errors -->
			<div class="text-danger">${errors.avatar}</div>
		</div>
	</div>
	<br>

	<div class="form-group row">
		<label for="address" class="col-md-4">Address</label>
		<div class="col-md-8">
			<input type="text" class="form-control" name="address" id="address" value="${contact.address}">
			<!-- For errors -->
			<div class="text-danger">${errors.address}</div>
		</div>
	</div>
	<br>

	<div class="form-group row">
		<label for="city" class="col-md-4">City</label>
		<div class="col-md-8">
			<input type="text" class="form-control" name="city" id="city" value="${contact.city}">
			<!-- For errors -->
			<div class="text-danger">${errors.city}</div>
		</div>
	</div>
	<br>

	<div class="form-group row">
		<label for="pincode" class="col-md-4">Pincode</label>
		<div class="col-md-8">
			<input type="text" class="form-control" name="pincode" id="pincode" value="${contact.pincode}">
			<!-- For errors -->
			<div class="text-danger">${errors.pincode}</div>
		</div>
	</div>
	<br>
	
	<div class="form-group row">
		<label for="state" class="col-md-4">State</label>
		<div class="col-md-8">
			<input type="text" class="form-control" name="state" id="state" value="${contact.state}">
			<!-- For errors -->
			<div class="text-danger">${errors.state}</div>
		</div>
	</div>
	<br>
	
	<div class="form-group row">
		<label for="country" class="col-md-4">Country</label>
		<div class="col-md-8">
			<input type="text" class="form-control" name="country" id="country" value="${contact.country}">
			<!-- For errors -->
			<div class="text-danger">${errors.country}</div>
		</div>
	</div>
	<br>
	<div class="form-group row">
		<label class="col-md-4"></label>
		<div class="col-md-8">
			<button class="btn btn-primary">Add Contact</button>
			<input type="reset" class="btn btn-link" value="Reset">
		</div>
	</div>
</form>

<%@ include file="./footer.jspf"%>