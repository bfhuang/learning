package com.bookshelf;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class BookShelfServlet extends HttpServlet {

	public void doPost(HttpServletRequest request,
	                   HttpServletResponse response) throws ServletException, IOException {

		Book book = new Book();
		book.setIsbn(Integer.parseInt(request.getParameter("isbn")));
		book.setName(request.getParameter("name"));
		book.setPrice(Double.parseDouble(request.getParameter("price")));
		book.setAuthor(request.getParameter("author"));
        int add = 0;
		MySQLAccess mySQLAccess = new MySQLAccess();
		try {
			add = mySQLAccess.add(book);
		} catch (SQLException e) {
			e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
		}
		if(add == 0)
			response.getWriter().println("no");
		else
			response.getWriter().println("yes");
	}

	public void doGet(HttpServletRequest request,
	                  HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		writer.println("<h1>" + "BookShelf,get" + "</h1>");
		writer.println("<form action=\"add\" method='post'>" +
				"ISBN: <input type=\"text\" name=\"isbn\" />\n" +
				"Name: <input type=\"text\" name=\"name\" />\n" +
				"Price: <input type=\"text\" name=\"price\" />\n" +
				"author: <input type=\"text\" name=\"author\" />\n" +
				"<input type=\"submit\" value=\"Submit\" />\n" +
				"</form>"
		);
	}
}
