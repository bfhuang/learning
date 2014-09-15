package com.bookshelf.controller;

import domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.BookService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(method = GET)
    public String retrieveBooks(ModelMap modelMap) {
        modelMap.put("books", bookService.query());
        return "books";
    }

    @RequestMapping(method = POST)
    public String addBook(@ModelAttribute("book") Book book, ModelMap modelMap) {
        bookService.add(book);
        return retrieveBooks(modelMap);
    }

    @RequestMapping("/add")
    public String addBook() {
        return "addBook";
    }
}
