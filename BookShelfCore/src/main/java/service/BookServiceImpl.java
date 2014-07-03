package service;

import domain.Book;
import repository.BookRepository;
import repository.BookRepositoryImpl;

import java.util.List;

public class BookServiceImpl implements BookService {
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
