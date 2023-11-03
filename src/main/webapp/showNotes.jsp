<%@page import="com.User.Post"%>
<%@page import="java.util.List"%>
<%@page import="com.DB.DBConnection"%>
<%@page import="com.DAO.PostDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Don't access without login -->
<%
    	userDetails user3 = (userDetails)session.getAttribute("userD");
    	if(user3 == null){
    		response.sendRedirect("login.jsp");
    		session.setAttribute("Login-error", "Please Login.....");
 
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="All_Content/content.jsp"%>
</head>
<body>
	<%@include file="All_Content/navBar.jsp"%>
			<%
				String updateMsg = (String)session.getAttribute("updateMsg");
				if(updateMsg != null)
				{
			%>
				<div class="alert alert-success" role="alert"><%=updateMsg%></div>	
			<% 	}
				session.removeAttribute("updateMsg");
			%>

			<%
				String deleteMsg = (String)session.getAttribute("deleteMsg");
				if(deleteMsg != null)
				{
			%>
				<div class="alert alert-success" role="alert"><%=deleteMsg%></div>	
			<% 	}
				session.removeAttribute("deleteMsg");
			%>
	<div class="container">
		<h2 class="text-center">All Notes</h2>

		<div class="row">
			<div class="col-md-12">
				<%
						if(user3 != null){
							PostDAO postDAO = new PostDAO(DBConnection.getConnection());
							List<Post> post =  postDAO.getData(user3.getId());
							for(Post po: post)
							{
					%>
				<div class="card mt-3">

					<!-- Image Tag -->
					<img alt="Notes" src="All_Content/images/enotes.png" class="card-img-top mt-2 mx-auto" style="max-width: 100px;">

					<div class="card-body p-4">




						<h5 class="class-title"><%=po.getTitle() %></h5>
						<p><%=po.getContent() %></p>

						<P>
							<b class="tect-scucess">Published By: <%=user3.getName() %></b><br> <b
								class="text-primary"></b>
						</P>

						<div class="container text-center mt-3">
							
							<a href="deleteServlet?note_id=<%=po.getId()%>" class="btn btn-danger">Delete</a> 
							<a href="edit.jsp?note_id=<%=po.getId()%>"class="btn btn-primary">Edit</a>
						</div>

					</div>

				</div>
				<%
				}
							
						}
				%>

			</div>

		</div>
	</div>
	<%@include file="All_Content/footer.jsp"%>

</body>
</html>