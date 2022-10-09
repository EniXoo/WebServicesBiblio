CREATE TABLE IF NOT EXISTS WrittenBy
(
    writtenbyid serial PRIMARY KEY,
    bookid serial NOT NULL,
    authorid serial NOT NULL,
    constraint fk_book
        foreign key(bookid)
            references Book(bookid),
    constraint fk_author
        foreign key(authorid)
            references Author(authorid)
)