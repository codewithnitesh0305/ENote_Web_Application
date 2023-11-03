<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--Don't access without login  -->
        <%
    	userDetails user2 = (userDetails)session.getAttribute("userD");
    	if(user2 == null){
    		response.sendRedirect("login.jsp");
    		session.setAttribute("Login-error", "Please Login.....");
 
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<%@include file="All_Content/content.jsp" %>
</head>
<body>
<%@include file="All_Content/navBar.jsp" %>
	 <div class="container-fluid p-0">
	
		<div class="card  py-5">
			<div class="card-body text-center">
					<img alt="" src="All_Content/images/enotes.png" class="img-fluid" style="width: 500px">
					<h1>START TAKING YOUR NOTES</h1>
					<a href="addNotes.jsp" class="btn btn-outline-primary">Start Here</a>
			</div>
		</div>
		<%@include file="All_Content/footer.jsp" %>
	</div>

</body>
</html>