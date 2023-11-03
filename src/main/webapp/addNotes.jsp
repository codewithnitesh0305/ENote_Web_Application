<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- Don't access without login -->
    <%
    	userDetails user1 = (userDetails)session.getAttribute("userD");
    	if(user1 == null){
    		response.sendRedirect("login.jsp");
    		session.setAttribute("Login-error", "Please Login.....");
 
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Notes</title>
<%@include file="All_Content/content.jsp" %>
</head>
<body>

	<div class="container-fluid">
		<%@include file="All_Content/navBar.jsp"%>
		<h1 class="text-center mt-5">Add Your Notes</h1>
		<div class="container mt-5">
			<div class="row">
				<div class="col-md-12">
					<form action="AddNotesServlet" method="post">
						<div class="form-group">
						
						<%
							 userDetails us = (userDetails)session.getAttribute("userD");
							if(us != null)
							{%>
								<input type="hidden" value="<%= us.getId()%>" name="uid">
							<%}
						%>
						
						
						
							<label for="exampleInputEmail1">Enter Title</label> <input
								type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" placeholder="" name="title">
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">Enter Content</label>
							<textarea rows="9" cols="" class="form-control" name="text_area"></textarea>
						</div>

						<div class="container text-center">
							
							<button type="submit" class="btn btn-primary">Add Notes</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<%@include file="All_Content/footer.jsp" %>
</body>
</html>