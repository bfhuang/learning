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

public class DisplayBookServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BookService bookService = new BookService(getBasicDataSource(getServletContext()));

		request.setAttribute("books", bookService.query());
		request.getRequestDispatcher("WEB-INF/pages/books.jsp").forward(request, response);
	}

	private DataSource getBasicDataSource(ServletContext servletContext) {
		ClassPathXmlApplicationContext applicationContextOfSpring =
				(ClassPathXmlApplicationContext) servletContext.getAttribute("applicationContextOfSpring");
		return (BasicDataSource) applicationContextOfSpring.getBean("basicDataSource");
	}
}
