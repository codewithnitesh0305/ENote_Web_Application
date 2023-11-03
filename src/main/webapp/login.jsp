<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<%@include file="All_Content/content.jsp"%>
</head>
<body>

	<%@include file="All_Content/navBar.jsp"%>
	<div class="container-fluid div-color mb-1">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-5">
					<div class="card-header text-center text-white bg-custom">
						<i class="fa fa-user-plus fa-3x" aria-hidden="true"></i>
						<h4>Login</h4>
				 </div>


					<%
					String InvalidMsg = (String) session.getAttribute("login-failed");
					if (InvalidMsg != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=InvalidMsg%></div>
					<%
					session.removeAttribute("login-failed");
					}
					%>

						<!--Access the notes without login error will throw  -->
					<%
					String withoutLogin = (String) session.getAttribute("Login-error");
					if (withoutLogin != null) {
					%>
					<div class="alert alert-danger" role="alert"><%=withoutLogin%></div>
					<%
					session.removeAttribute("Login-error");
					}
					%>
						<!-- Logout Message -->
					<%
						String logoutMsg = (String)session.getAttribute("logoutMsg");
						if(logoutMsg != null){
					%>
						<div class="alert alert-success" role="alert"><%=logoutMsg%></div>
					<%
						session.removeAttribute("logoutMsg");
						}
					%>
					<div class="card-body">
						<form action="loginServlet" method="post">
							
							<div class="form-group">
								<label>Enter Email</label> <input type="email"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" name="userEmail"
									required>
							</div>
							<div class="form-group">
								<label>Enter Password</label> <input type="password"
									class="form-control" id="exampleInputPassword1" name="userPassword" required>
							</div>

							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Login</button>
						</form>
					</div>
				</div>
			</div>
		</div>

	</div>
	<%@include file="All_Content/footer.jsp"%>
</body>
</html>