package com.bookshelf;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;

public class AddBookServlet extends HttpServlet {

	public void doPost(HttpServletRequest request,
	                   HttpServletResponse response) throws ServletException, IOException {

		System.out.println("===========================");
		Book book = new Book();
		book.setIsbn(Integer.parseInt(request.getParameter("isbn")));
		book.setName(request.getParameter("name"));
		book.setPrice(Double.parseDouble(request.getParameter("price")));
		book.setAuthor(request.getParameter("author"));
		System.out.println("232323");
		ServletContext servletContext = getServletContext();
		BookService bookService = new BookService(getBasicDataSource(getServletContext()));
		bookService.insert(book);

		request.setAttribute("books", bookService.query());
		request.getRequestDispatcher("WEB-INF/pages/books.jsp").forward(request, response);
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

	private DataSource getBasicDataSource(ServletContext servletContext) {
		ClassPathXmlApplicationContext applicationContextOfSpring =
				(ClassPathXmlApplicationContext) servletContext.getAttribute("applicationContextOfSpring");
		return (BasicDataSource) applicationContextOfSpring.getBean("basicDataSource");
	}
}
