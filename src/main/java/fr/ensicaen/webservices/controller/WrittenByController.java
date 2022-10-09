package fr.ensicaen.webservices.controller;

import fr.ensicaen.webservices.annotation.HasPermission;
import fr.ensicaen.webservices.domain.WrittenBy;
import fr.ensicaen.webservices.service.WrittenByService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class WrittenByController {
    @Autowired
    private WrittenByService writtenByService;

    public WrittenByController() {
        this.writtenByService = new WrittenByService();
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,BORROW,CONSULT")
    @GetMapping("/writtenBys")
    public List<WrittenBy> getWrittenBys() {
        return this.writtenByService.getWrittenBys();
    }

    @HasPermission(roles = "ADMINISTRATOR")
    @DeleteMapping("/writtenBys")
    public HttpStatus deleteWrittenBys() {
        return this.writtenByService.deleteWrittenBys();
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,BORROW,CONSULT")
    @GetMapping("/writtenBy")
    public Optional<WrittenBy> getWrittenBy(@RequestParam Integer writtenById) {
        return this.writtenByService.getWrittenBy(writtenById);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR")
    @PostMapping("/writtenBy")
    public HttpStatus postWrittenBy(@RequestBody WrittenBy writtenBy) {
        return this.writtenByService.postWrittenBy(writtenBy);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR")
    @PutMapping("/writtenBy")
    public HttpStatus putWrittenBy(@RequestBody WrittenBy writtenBy) {
        return this.writtenByService.putWrittenBy(writtenBy);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR")
    @DeleteMapping("/writtenBy")
    public HttpStatus deleteWrittenBy(@RequestParam Integer writtenById) {
        return this.writtenByService.deleteWrittenBy(writtenById);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,CONSULT")
    @GetMapping("/writtenBy/book")
    public List<WrittenBy> getWrittenByBook(@RequestParam Integer bookId) {
        return this.writtenByService.getWrittenByBook(bookId);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,CONSULT")
    @GetMapping("/writtenBy/author")
    public List<WrittenBy> getWrittenByAuthor(@RequestParam Integer authorId) {
        return this.writtenByService.getWrittenByAuthor(authorId);
    }
}
