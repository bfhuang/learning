package service;

import domain.Book;
import repository.BookRepository;

import java.util.List;

/**
 * Created by twer on 7/3/14.
 */
public class BookService {
    private BookRepository bookRepository;

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void add(Book book) {
        bookRepository.insert(book);
    }

    public List<Book> query() {
        return bookRepository.query();
    }
}
