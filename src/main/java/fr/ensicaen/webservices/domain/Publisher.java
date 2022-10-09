package fr.ensicaen.webservices.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "publisher")
public class Publisher
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="publisherid")
    private Integer publisherId;

    @Column(name = "publishername")
    private String publisherName;

}
