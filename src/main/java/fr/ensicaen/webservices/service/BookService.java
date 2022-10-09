package fr.ensicaen.webservices.service;

import fr.ensicaen.webservices.domain.Book;
import fr.ensicaen.webservices.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooks() {
        return this.bookRepository.findAll();
    }

    public HttpStatus deleteBooks() {
        try {
            this.bookRepository.deleteAll();
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public Optional<Book> getBook(Integer bookId) {
        return this.bookRepository.findById(bookId);
    }

    public HttpStatus postBook(Book book) {
        try {
            this.bookRepository.save(book);
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public HttpStatus putBook(Book book) {
        try {
            this.bookRepository.update(book.getBookId(), book.getPublisher(), book.getBookName(), book.getBookMark());
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public HttpStatus deleteBook(Integer bookId) {
        try {
            this.bookRepository.deleteById(bookId);
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public List<Book> getAvailablesBooks() {
        return this.bookRepository.findAvailables();
    }

    public List<Book> getUnavailablesBooks() {
        return this.bookRepository.findUnavailables();
    }

    public List<Book> getBooksByPublisher(Integer publisherId) {
        return this.bookRepository.findByPublisherPublisherId(publisherId);
    }
}
