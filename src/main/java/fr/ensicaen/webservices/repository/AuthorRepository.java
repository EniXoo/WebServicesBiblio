package fr.ensicaen.webservices.repository;

import fr.ensicaen.webservices.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    @Transactional
    @Modifying
    @Query("update Author set firstName = :firstName, lastName = :lastName WHERE authorId = :authorId")
    void update(@Param("authorId") Integer authorId, @Param("firstName") String firstName, @Param("lastName") String lastName);
}