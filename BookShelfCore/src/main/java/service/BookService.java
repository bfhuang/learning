package service;


import domain.Book;

import java.util.List;

public interface BookService {

    public void add(Book book);

    public List<Book> query();
}
