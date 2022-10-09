package fr.ensicaen.webservices.service;

import fr.ensicaen.webservices.domain.WrittenBy;
import fr.ensicaen.webservices.repository.WrittenByRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WrittenByService {
    @Autowired
    private WrittenByRepository writtenByRepository;

    public List<WrittenBy> getWrittenBys() {
        return this.writtenByRepository.findAll();
    }

    public HttpStatus deleteWrittenBys() {
        try {
            this.writtenByRepository.deleteAll();
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public Optional<WrittenBy> getWrittenBy(Integer writtenById) {
        return this.writtenByRepository.findById(writtenById);
    }

    public HttpStatus postWrittenBy(WrittenBy writtenBy) {
        try {
            this.writtenByRepository.save(writtenBy);
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public HttpStatus putWrittenBy(WrittenBy writtenBy) {
        try {
            this.writtenByRepository.update(writtenBy.getWrittenById(), writtenBy.getAuthor(), writtenBy.getBook());
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public HttpStatus deleteWrittenBy(Integer writtenById) {
        try {
            this.writtenByRepository.deleteById(writtenById);
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public List<WrittenBy> getWrittenByBook(Integer bookId) {
        return this.writtenByRepository.findByBookBookId(bookId);
    }

    public List<WrittenBy> getWrittenByAuthor(Integer authorId) {
        return this.writtenByRepository.findByAuthorAuthorId(authorId);
    }
}
