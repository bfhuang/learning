package com.bookshelf.oldWay.servlet;

import domain.Book;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.BookService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class DisplayBookServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        BookService bookService = getBookService(getServletContext());
        Book book = new Book();
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(book);

        request.setAttribute("books", books);
		request.getRequestDispatcher("WEB-INF/pages/books.jsp").forward(request, response);
	}

    private BookService getBookService(ServletContext servletContext) {
        ApplicationContext applicationContextOfSpring =
                (ClassPathXmlApplicationContext) servletContext.getAttribute("applicationContextOfSpring");
        return (BookService) applicationContextOfSpring.getBean("bookService");
    }
}
