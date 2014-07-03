package com.bookshelf.servlet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DisplayBookServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookService bookService = getBookService(getServletContext());

        request.setAttribute("books", bookService.query());
		request.getRequestDispatcher("WEB-INF/pages/books.jsp").forward(request, response);
	}

    private BookService getBookService(ServletContext servletContext) {
        ApplicationContext applicationContextOfSpring =
                (ClassPathXmlApplicationContext) servletContext.getAttribute("applicationContextOfSpring");
        return (BookService) applicationContextOfSpring.getBean("bookService");
    }
}
