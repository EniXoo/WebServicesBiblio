package fr.ensicaen.webservices.controller;

import fr.ensicaen.webservices.annotation.HasPermission;
import fr.ensicaen.webservices.domain.Book;
import fr.ensicaen.webservices.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    public BookController() {
        this.bookService = new BookService();
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,BORROW,CONSULT")
    @GetMapping("/books")
    public List<Book> getBooks() {
        return this.bookService.getBooks();
    }

    @HasPermission(roles = "ADMINISTRATOR")
    @DeleteMapping("/books")
    public HttpStatus deleteBooks() {
        return this.bookService.deleteBooks();
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,BORROW,CONSULT")
    @GetMapping("/book")
    public Optional<Book> getBook(@RequestParam Integer bookId) {
        return this.bookService.getBook(bookId);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR")
    @PostMapping("/book")
    public HttpStatus postBook(@RequestBody Book book) {
        return this.bookService.postBook(book);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR")
    @PutMapping("/book")
    public HttpStatus putBook(@RequestBody Book book) {
        return this.bookService.putBook(book);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR")
    @DeleteMapping("/book")
    public HttpStatus deleteBook(@RequestParam Integer bookId) {
        return this.bookService.deleteBook(bookId);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,BORROW,CONSULT")
    @GetMapping("/book/available")
    public List<Book> getAvailablesBooks() {
        return this.bookService.getAvailablesBooks();
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,BORROW,CONSULT")
    @GetMapping("/book/unavailable")
    public List<Book> getUnavailablesBooks() {
        return this.bookService.getUnavailablesBooks();
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,BORROW,CONSULT")
    @GetMapping("/book/publisher")
    public List<Book> getBooksByPublisher(@RequestParam Integer publisherId) {
        return this.bookService.getBooksByPublisher(publisherId);
    }
}
