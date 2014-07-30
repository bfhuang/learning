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
import java.io.PrintWriter;

public class AddBookServlet extends HttpServlet {

	public void doPost(HttpServletRequest request,
	                   HttpServletResponse response) throws ServletException, IOException {


        BookService bookService = getBookService(getServletContext());
        bookService.add(getBook(request));

		request.setAttribute("books", bookService.query());
		request.getRequestDispatcher("WEB-INF/pages/books.jsp").forward(request, response);
	}

    private Book getBook(HttpServletRequest request) {
        Book book = new Book();
        book.setIsbn(Integer.parseInt(request.getParameter("isbn")));
        book.setName(request.getParameter("name"));
        book.setPrice(Double.parseDouble(request.getParameter("price")));
        book.setAuthor(request.getParameter("author"));
        return book;
    }

    public void doGet(HttpServletRequest request,
	                  HttpServletResponse response) throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		writer.println("<h1>" + "BookShelf,get" + "</h1>");
		writer.println("<form action=\"addBook\" method='post'>" +
				"ISBN: <input type=\"text\" name=\"isbn\" />\n" +
				"Name: <input type=\"text\" name=\"name\" />\n" +
				"Price: <input type=\"text\" name=\"price\" />\n" +
				"author: <input type=\"text\" name=\"author\" />\n" +
				"<input type=\"submit\" value=\"Submit\" />\n" +
				"</form>"
		);
	}

	private BookService getBookService(ServletContext servletContext) {
		ApplicationContext applicationContextOfSpring =
				(ClassPathXmlApplicationContext) servletContext.getAttribute("applicationContextOfSpring");
		return (BookService) applicationContextOfSpring.getBean("bookService");
	}
}
