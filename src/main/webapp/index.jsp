<%@page import="java.sql.Connection"%>
<%@page import="com.DB.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.back-img{
			background: url("All_Content/images/home.jpg");
			width: 100%;
			height: 90vh;
			background-size: cover;
			
			
	}
</style>
<meta charset="UTF-8">
<title>Home Page</title>
<%@include file="All_Content/content.jsp" %>

</head>
<body>
	<%@include file="All_Content/navBar.jsp" %>
	<%-- <%
		Connection conn = DBConnection.getConnection();
		System.out.println(conn);
	%> --%>
	<div class="container-fluid back-img ">
		<div class="text-center">
			<h1 class="text-white"><i class="fa fa-book" aria-hidden="true"></i> E Notes - Save Your Notes</h1>
			<a href="login.jsp" class="btn btn-light"><i class="fa fa-user-circle-o" aria-hidden="true"></i> Login</a>
			<a href="register.jsp" class="btn btn-light"><i class="fa fa-user-plus" aria-hidden="true"></i>Register</a>
		</div>
	</div>
	<%@include file="All_Content/footer.jsp" %>
</body>
</html>