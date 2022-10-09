package fr.ensicaen.webservices.repository;

import fr.ensicaen.webservices.domain.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
    @Transactional
    @Modifying
    @Query("update Publisher set publisherName = :publisherName WHERE publisherId = :publisherId")
    void update(Integer publisherId, String publisherName);
}