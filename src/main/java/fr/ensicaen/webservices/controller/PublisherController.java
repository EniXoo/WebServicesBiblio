package fr.ensicaen.webservices.controller;

import fr.ensicaen.webservices.annotation.HasPermission;
import fr.ensicaen.webservices.domain.Publisher;
import fr.ensicaen.webservices.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class PublisherController {
    @Autowired
    private PublisherService publisherService;

    public PublisherController() {
        this.publisherService = new PublisherService();
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,BORROW,CONSULT")
    @GetMapping("/publishers")
    public List<Publisher> getPublishers() {
        return this.publisherService.getPublishers();
    }

    @HasPermission(roles = "ADMINISTRATOR")
    @DeleteMapping("/publishers")
    public HttpStatus deletePublishers() {
        return this.publisherService.deletePublishers();
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,BORROW,CONSULT")
    @GetMapping("/publisher")
    public Optional<Publisher> getPublisher(@RequestParam Integer publisherId) {
        return this.publisherService.getPublisher(publisherId);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR")
    @PostMapping("/publisher")
    public HttpStatus postPublisher(@RequestBody Publisher publisher) {
        return this.publisherService.postPublisher(publisher);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR")
    @PutMapping("/publisher")
    public HttpStatus putPublisher(@RequestBody Publisher publisher) {
        return this.publisherService.putPublisher(publisher);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR")
    @DeleteMapping("/publisher")
    public HttpStatus deletePublisher(@RequestParam Integer publisherId) {
        return this.publisherService.deletePublisher(publisherId);
    }
}
