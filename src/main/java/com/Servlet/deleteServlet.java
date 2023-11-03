package com.Servlet;

import java.io.IOException;

import com.DAO.PostDAO;
import com.DB.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer noteId =  Integer.parseInt(req.getParameter("note_id"));
		PostDAO postDAO = new PostDAO(DBConnection.getConnection());
		boolean f = postDAO.detletNotes(noteId);
	
		if (f) {
			
			  //System.out.println("Data delete successfully");
			 HttpSession session = req.getSession();
			session.setAttribute("deleteMsg", "Note delete successfully");
			resp.sendRedirect("showNotes.jsp");
		}
		else {
			//System.out.println("Data is not delete");
			HttpSession session = req.getSession();
			session.setAttribute("worngMsg", "Something went wrong in server...");
			resp.sendRedirect("showNotes.jsp");
			
		}
		
	}
	

}
