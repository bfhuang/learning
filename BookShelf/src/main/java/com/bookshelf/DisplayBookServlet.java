package com.bookshelf;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DisplayBookServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MySQLAccess mySQLAccess = new MySQLAccess();

		request.setAttribute("books", mySQLAccess.query());
		request.getRequestDispatcher("WEB-INF/pages/books.jsp").forward(request, response);
	}
}
