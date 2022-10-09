package fr.ensicaen.webservices.controller;

import fr.ensicaen.webservices.annotation.HasPermission;
import fr.ensicaen.webservices.domain.Author;
import fr.ensicaen.webservices.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class AuthorController {
    @Autowired
    private AuthorService authorService;

    public AuthorController() {
        this.authorService = new AuthorService();
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,BORROW,CONSULT")
    @GetMapping("/authors")
    public List<Author> getAuthors() {
        return this.authorService.getAuthors();
    }

    @HasPermission(roles = "ADMINISTRATOR")
    @DeleteMapping("/authors")
    public HttpStatus deleteAuthors() {
        return this.authorService.deleteAuthors();
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,BORROW,CONSULT")
    @GetMapping("/author")
    public Optional<Author> getAuthor(@RequestParam Integer authorId) {
        return this.authorService.getAuthor(authorId);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR")
    @PostMapping("/author")
    public HttpStatus postAuthor(@RequestBody Author author) {
        return this.authorService.postAuthor(author);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR")
    @PutMapping("/author")
    public HttpStatus putAuthor(@RequestBody Author author) {
        return this.authorService.putAuthor(author);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR")
    @DeleteMapping("/author")
    public HttpStatus deleteAuthor(@RequestParam Integer authorId) {
        return this.authorService.deleteAuthor(authorId);
    }
}
