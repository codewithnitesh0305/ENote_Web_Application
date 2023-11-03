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
@WebServlet("/notesEditServlet")
public class notesEditServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		try {
			Integer noteId = Integer.parseInt(req.getParameter("noteId"));
			String title = req.getParameter("title");
			String content = req.getParameter("text_area");
			
			PostDAO postDAO = new PostDAO(DBConnection.getConnection());
			boolean f =  postDAO.postUpdate(noteId, title, content);
			if (f) {
				System.out.println("Data Update Successfully");
				HttpSession session = req.getSession();
				session.setAttribute("updateMsg", "Note update Sucessfully");
				resp.sendRedirect("showNotes.jsp");
			}
			else {
				System.out.println("Data not update successfully");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	

}
