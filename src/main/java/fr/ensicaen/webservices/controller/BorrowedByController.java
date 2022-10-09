package fr.ensicaen.webservices.controller;

import fr.ensicaen.webservices.annotation.HasPermission;
import fr.ensicaen.webservices.domain.BorrowedBy;
import fr.ensicaen.webservices.service.BorrowedByService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class BorrowedByController {
    @Autowired
    private BorrowedByService borrowedByService;

    public BorrowedByController() {
        this.borrowedByService = new BorrowedByService();
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,BORROW")
    @GetMapping("/borrowedBys")
    public List<BorrowedBy> getBorrowedsBy() {
        return this.borrowedByService.getBorrowedsBy();
    }

    @HasPermission(roles = "ADMINISTRATOR")
    @DeleteMapping("/borrowedBys")
    public HttpStatus deleteBorrowedsBy() {
        return this.borrowedByService.deleteBorrowedsBy();
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,BORROW")
    @GetMapping("/borrowedBy")
    public Optional<BorrowedBy> getBorrowedBy(@RequestParam Integer borrowedById) {
        return this.borrowedByService.getBorrowedBy(borrowedById);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,BORROW")
    @PostMapping("/borrowedBy")
    public HttpStatus postBorrowedBy(@RequestBody BorrowedBy borrowedBy) {
        return this.borrowedByService.postBorrowedBy(borrowedBy);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,BORROW")
    @PutMapping("/borrowedBy")
    public HttpStatus putBorrowedBy(@RequestBody BorrowedBy borrowedBy) {
        return this.borrowedByService.putBorrowedBy(borrowedBy);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,BORROW")
    @DeleteMapping("/borrowedBy")
    public HttpStatus deleteBorrowedBy(@RequestParam Integer borrowedById) {
        return this.borrowedByService.deleteBorrowedBy(borrowedById);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,BORROW")
    @GetMapping("/borrowedBy/user")
    public List<BorrowedBy> getBorrowedByUser(@RequestParam Integer userId) {
        return this.borrowedByService.getBorrowedByUser(userId);
    }

    @HasPermission(roles = "ADMINISTRATOR,CONTRIBUTOR,BORROW")
    @GetMapping("/borrowedBy/book")
    public List<BorrowedBy> getBorrowedByBook(@RequestParam Integer bookId) {
        return this.borrowedByService.getBorrowedByBook(bookId);
    }


}
