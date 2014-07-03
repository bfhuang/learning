package repository;

import domain.Book;

import java.util.List;

public interface BookRepository {

    public void insert(Book book);

    public List<Book> query();
}
