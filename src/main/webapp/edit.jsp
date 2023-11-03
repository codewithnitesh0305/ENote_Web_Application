<%@page import="com.User.Post"%>
<%@page import="com.DB.DBConnection"%>
<%@page import="com.DAO.PostDAO"%>
<%@page import="com.mysql.cj.protocol.a.NativeConstants.IntegerDataType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--     <%
    	userDetails user4 = (userDetails)session.getAttribute("userD");
    	if(user4 != null){
    		response.sendRedirect("login.jsp");
    		session.setAttribute("Login-error", "Please Login...");
    		
    	}
    %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="All_Content/content.jsp" %>
</head>
<body>
<%
	Integer noteId = Integer.parseInt(request.getParameter("note_id")); 
	PostDAO postDAO = new PostDAO(DBConnection.getConnection());
	Post post = postDAO.getDataById(noteId);
%>

	<!-- Edit Page  -->
<div class="container-fluid">
		<%@include file="All_Content/navBar.jsp"%>

		<h1 class="text-center mt-5">Edit Your Notes</h1>
		<div class="container mt-5">
			<div class="row">
				<div class="col-md-12">
					<form action="notesEditServlet" method="post">
					
					<input type="hidden" value="<%=noteId%>" name="noteId">
					
						<div class="form-group">
						
							
							<label for="exampleInputEmail1">Enter Title</label> <input
								type="text" class="form-control" id="exampleInputEmail1"
								aria-describedby="emailHelp" placeholder="" name="title" value="<%= post.getTitle()%>">
						</div>

						<div class="form-group">
							<label for="exampleInputEmail1">Enter Content</label>
							<textarea rows="9" cols="" class="form-control" name="text_area" ><%= post.getContent() %></textarea>
						</div>

						<div class="container text-center">
							
							<button type="submit" class="btn btn-primary">Edit Notes</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
<%@include file="All_Content/footer.jsp" %>
	
</body>
</html>