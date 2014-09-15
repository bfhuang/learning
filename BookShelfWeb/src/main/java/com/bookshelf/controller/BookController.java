package com.bookshelf.controller;

import domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BookService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "add", method = GET)
    public String addBookForm() {
        return "addBook";
    }

//    No need to add the action to the form and the name for the form.
// This function will get the book's properties based on the property name.
    //should use redirect to get all books instead of calling the display method,
    // if in later way, the url of showing all books is 'add' and when you refresh the page,
//    it  will do post again
//    PRG(post redirect get) pattern
    @RequestMapping(value = "add", method = POST)
    public String addBook(@ModelAttribute Book book) {
        bookService.add(book);
        return "redirect:display";
    }

//    should keep the url meaningful
    @RequestMapping("display")
    public String display(ModelMap modelMap) {
        modelMap.put("books", bookService.query());
        return "books";
    }
}