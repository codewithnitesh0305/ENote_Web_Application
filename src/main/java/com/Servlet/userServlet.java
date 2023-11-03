package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.tomcat.jakartaee.commons.lang3.ObjectUtils.Null;
import org.eclipse.jdt.internal.compiler.env.NameEnvironmentAnswer;

import com.DAO.userDAO;
import com.DB.DBConnection;
import com.User.userDetails;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/UserServlet")
public class userServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("user_name");
		String email = req.getParameter("user_email");
		String password = req.getParameter("user_password");
		
		userDetails user = new userDetails();
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		
		userDAO dao = new userDAO(DBConnection.getConnection());
		boolean f =  dao.addUser(user);

		
		HttpSession session = req.getSession();
		if(f) {
			session.setAttribute("reg-succ", "Register Successfully! ");
			resp.sendRedirect("register.jsp");
			
		}
		else {
			session.setAttribute("reg-err", "Something is wrong in server");
			resp.sendRedirect("regsiter.jsp");
		}
	}
	

}
