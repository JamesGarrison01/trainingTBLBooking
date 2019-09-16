package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.TourUserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TourUserDAO newUser = new TourUserDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		        // get request parameters for username and password
		        String userName = request.getParameter("loginTextBox");
		        String password = request.getParameter("passwordBox");
		        String userType = request.getParameter("userSelectDrop");

		        if (newUser.checkUserLogin(userName, password) == 1) {

		            Cookie userValidation = new Cookie("userType", userType);
		            response.addCookie(userValidation);
		            response.sendRedirect("pages/home.jsp");
		        } 
		        else {
		            RequestDispatcher rd = getServletContext().getRequestDispatcher("pages/login.html");
		            PrintWriter out = response.getWriter();
		            out.println("<font color=red>Either username or password is wrong.</font>");
		            rd.include(request, response);
		        }
	}
}
