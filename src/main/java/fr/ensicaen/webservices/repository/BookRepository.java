package fr.ensicaen.webservices.repository;

import fr.ensicaen.webservices.domain.Book;
import fr.ensicaen.webservices.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    @Transactional
    @Modifying
    @Query("update Book set publisher = :publisher, bookName = :bookName, bookMark = :bookMark WHERE bookId = :bookId")
    void update(@Param("bookId") Integer bookId, @Param("publisher") Publisher publisher, @Param("bookName") String bookName, @Param("bookMark") String bookMark);

    @Query(nativeQuery = true, value="select book.bookid,publisherid,bookname,bookmark from book\n" +
            "left join borrowedby b on book.bookid = b.bookid\n" +
            "where enddate < date('now') and enddate = (select max(enddate) from borrowedby where bookid = book.bookid)\n" +
            "union\n" +
            "select book.bookid,publisherid,bookname,bookmark from book\n" +
            "left join borrowedby b on book.bookid = b.bookid\n" +
            "where enddate is null")
    List<Book> findAvailables();

    @Query(nativeQuery = true, value="select book.bookid,publisherid,bookname,bookmark from book\n" +
            "right join borrowedby b on book.bookid = b.bookid\n" +
            "where enddate is null")
    List<Book> findUnavailables();

    List<Book> findByPublisherPublisherId(Integer publisherId);
}