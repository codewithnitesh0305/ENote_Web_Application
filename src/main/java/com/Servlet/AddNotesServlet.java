package com.Servlet;

import java.io.IOException;

import org.apache.catalina.connector.Response;

import com.DAO.PostDAO;
import com.DB.DBConnection;
import com.User.Post;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddNotesServlet")
public class AddNotesServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int uId = Integer.parseInt(req.getParameter("uid"));
		String title = req.getParameter("title");
		String content = req.getParameter("text_area");
		
		PostDAO dao = new PostDAO(DBConnection.getConnection());
		boolean f = dao.addNotes(title, content, uId);
		
		if(f) {
			System.out.println("Data Insert");
			resp.sendRedirect("showNotes.jsp");
		}
		else {
			System.out.print("Not inssert");
		}
	}
	

}
