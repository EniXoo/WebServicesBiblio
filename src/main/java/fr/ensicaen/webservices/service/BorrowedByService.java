package fr.ensicaen.webservices.service;

import fr.ensicaen.webservices.domain.BorrowedBy;
import fr.ensicaen.webservices.repository.BorrowedByRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowedByService {
    @Autowired
    private BorrowedByRepository borrowedByRepository;

    public List<BorrowedBy> getBorrowedsBy() {
        return this.borrowedByRepository.findAll();
    }

    public HttpStatus deleteBorrowedsBy() {
        try {
            this.borrowedByRepository.deleteAll();
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public Optional<BorrowedBy> getBorrowedBy(Integer borrowedById) {
        return this.borrowedByRepository.findById(borrowedById);
    }

    public HttpStatus postBorrowedBy(BorrowedBy borrowedBy) {
        try {
            this.borrowedByRepository.save(borrowedBy);
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public HttpStatus putBorrowedBy(BorrowedBy borrowedBy) {
        try {
            this.borrowedByRepository.update(borrowedBy.getBorrowedById(), borrowedBy.getBook(), borrowedBy.getUserId(), borrowedBy.getStartDate(), borrowedBy.getEndDate(), borrowedBy.getDuration());
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public HttpStatus deleteBorrowedBy(Integer borrowedById) {
        try {
            this.borrowedByRepository.deleteById(borrowedById);
            return HttpStatus.OK;
        } catch (IllegalArgumentException exception) {
            return HttpStatus.BAD_REQUEST;
        }
    }

    public List<BorrowedBy> getBorrowedByUser(Integer userId) {
        return this.borrowedByRepository.findByUserId(userId);
    }


    public List<BorrowedBy> getBorrowedByBook(Integer bookId) {
        return this.borrowedByRepository.findByBookBookId(bookId);
    }
}
