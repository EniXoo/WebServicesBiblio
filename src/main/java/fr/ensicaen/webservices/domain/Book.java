package fr.ensicaen.webservices.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "book")
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="bookid")
    private Integer bookId;

    @Column(name = "bookname")
    private String bookName;

    @ManyToOne
    @JoinColumn(name="publisherid")
    private Publisher publisher;

    @Column(name = "bookmark")
    private String bookMark;

}
