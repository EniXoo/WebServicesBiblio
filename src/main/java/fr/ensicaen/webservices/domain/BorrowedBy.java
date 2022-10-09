package fr.ensicaen.webservices.domain;

import lombok.Data;

import javax.persistence.*;
import java.sql .Date;

@Data
@Entity
@Table(name = "borrowedby")
public class BorrowedBy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="borrowedbyid")
    private Integer borrowedById;

    @Column(name ="userid")
    public Integer userId;

    @Column(name ="startdate")
    public Date startDate;

    @Column(name ="enddate")
    public Date endDate;

    @Column(name ="duration")
    public Integer duration;

    @ManyToOne
    @JoinColumn(name ="bookid")
    public Book book;
}
