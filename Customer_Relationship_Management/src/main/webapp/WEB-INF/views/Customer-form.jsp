<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
	
<title>Save Customer</title>
</head>
<body>

	<div class="container">

		<h3>Customer Directory</h3>
		<hr>

		<p class="h4 mb-4">Customer Details</p>

		<form action="/Customer_Relationship_Management/customer/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Customer.id}" />

			<div class="form-inline">
				<input type="text" name="FirstName" value="${Customer.firstName}"
					class="form-control mb-4 col-4" placeholder="FirstName">



			</div>

			<div class="form-inline">

				<input type="text" name="LastName" value="${Customer.lastName}"
					class="form-control mb-4 col-4" placeholder="LastName">



			</div>

			<div class="form-inline">

				<input type="text" name="Email" value="${Customer.email}"
					class="form-control mb-4 col-4" placeholder="Email">



			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/Customer_Relationship_Management/customer/list">Back to Customer List</a>

	</div>
</body>
</html>







