package fr.ensicaen.webservices.service;

import fr.ensicaen.webservices.domain.Publisher;
import fr.ensicaen.webservices.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService {
    @Autowired
    private PublisherRepository publisherRepository;

    public List<Publisher> getPublishers() {
        return this.publisherRepository.findAll();
    }

    public HttpStatus deletePublishers() {
        try {
            this.publisherRepository.deleteAll();
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public Optional<Publisher> getPublisher(Integer publisherId) {
        return this.publisherRepository.findById(publisherId);
    }

    public HttpStatus postPublisher(Publisher publisher) {
        try {
            this.publisherRepository.save(publisher);
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public HttpStatus putPublisher(Publisher publisher) {
        try {
            this.publisherRepository.update(publisher.getPublisherId(), publisher.getPublisherName());
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public HttpStatus deletePublisher(Integer publisherId) {
        try {
            this.publisherRepository.deleteById(publisherId);
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }
}
