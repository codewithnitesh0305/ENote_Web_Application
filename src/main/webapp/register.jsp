<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<%@include file="All_Content/content.jsp"%>

<link >
</head>
<body>
	<%@include file="All_Content/navBar.jsp"%>
	<div class="container-fluid div-color mb-1">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-5">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
						<h4>Registration</h4>
					</div>
					<%
						String regMsg = (String)session.getAttribute("reg-succ");
						if(regMsg != null)
						{
						%>
							<div class="alert alert-success" role="alert"><%= regMsg %><a href="login.jsp">Login here..</a></div>
						<%
							session.removeAttribute("reg-succ");
						}
						
					%>
					
					<%
						String errMsg = (String)session.getAttribute("reg-err");
						if(errMsg != null)
						{
						%>
						<div class="alert alert-danger" role="alert"><%= errMsg %></div>
						<%
							session.removeAttribute("reg-err");
						}
						
					%>
						
					
						
					<div class="card-body">
						<form action="UserServlet" method="post">
							<div class="form-group">
								<label>Enter Full Name</label>
								 <input
									type="text" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="user_name" required>
							</div>
							<div class="form-group">
								<label>Enter Email</label>
								 <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="user_email" required>
							</div>
							<div class="form-group">
								<label>Enter Password</label>
								 <input
									type="password" class="form-control" id="exampleInputPassword1" name="user_password" required>
							</div>
							
							<button type="submit" class="btn btn-primary badge-pill btn-block">Redistered</button>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%@include file="All_Content/footer.jsp" %>
</body>
</html>