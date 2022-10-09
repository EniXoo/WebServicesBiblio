package fr.ensicaen.webservices.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "author")
public class Author
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="authorid")
    private Integer authorId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;
}
