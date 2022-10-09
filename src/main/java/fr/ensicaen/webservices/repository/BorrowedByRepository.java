package fr.ensicaen.webservices.repository;

import fr.ensicaen.webservices.domain.Book;
import fr.ensicaen.webservices.domain.BorrowedBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

public interface BorrowedByRepository extends JpaRepository<BorrowedBy, Integer> {
    @Transactional
    @Modifying
    @Query("update BorrowedBy set book = :book, userId = :userId, startDate = :startDate, endDate= :endDate,duration = :duration where borrowedById = :borrowedById")
    void update(Integer borrowedById, Book book, Integer userId, Date startDate, Date endDate, Integer duration);

    List<BorrowedBy> findByUserId(Integer userId);
    List<BorrowedBy> findByBookBookId(Integer bookId);
}