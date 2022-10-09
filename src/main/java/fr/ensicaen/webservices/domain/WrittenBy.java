package fr.ensicaen.webservices.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "writtenby")
public class WrittenBy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="writtenbyid")
    private Integer writtenById;

    @ManyToOne
    @JoinColumn(name ="authorid")
    public Author author;

    @ManyToOne
    @JoinColumn(name ="bookid")
    public Book book;
}
