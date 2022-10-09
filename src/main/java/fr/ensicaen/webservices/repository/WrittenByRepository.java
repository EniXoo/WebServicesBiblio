package fr.ensicaen.webservices.repository;

import fr.ensicaen.webservices.domain.Author;
import fr.ensicaen.webservices.domain.Book;
import fr.ensicaen.webservices.domain.WrittenBy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WrittenByRepository extends JpaRepository<WrittenBy, Integer> {
    @Transactional
    @Modifying
    @Query("update WrittenBy set author = :author, book = :book where writtenById = :writtenById")
    void update(Integer writtenById, Author author, Book book);

    List<WrittenBy> findByBookBookId(Integer bookId);

    List<WrittenBy> findByAuthorAuthorId(Integer authorId);
}