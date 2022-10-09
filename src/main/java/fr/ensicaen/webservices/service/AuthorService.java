package fr.ensicaen.webservices.service;

import fr.ensicaen.webservices.domain.Author;
import fr.ensicaen.webservices.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    public List<Author> getAuthors() {
        return this.authorRepository.findAll();
    }

    public HttpStatus deleteAuthors() {
        try {
            this.authorRepository.deleteAll();
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }
    public Optional<Author> getAuthor(Integer authorId) {
        return this.authorRepository.findById(authorId);
    }

    public HttpStatus postAuthor(Author author) {
        try {
            this.authorRepository.save(author);
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public HttpStatus putAuthor(Author author) {
        try {
            this.authorRepository.update(author.getAuthorId(), author.getFirstName(), author.getLastName());
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public HttpStatus deleteAuthor(Integer authorId) {
        try {
            this.authorRepository.deleteById(authorId);
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }
}
