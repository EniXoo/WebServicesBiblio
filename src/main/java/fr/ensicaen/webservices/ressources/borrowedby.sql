CREATE TABLE IF NOT EXISTS BorrowedBy
(
    borrowedbyid serial PRIMARY KEY,
    bookid serial NOT NULL,
    userid serial NOT NULL,
    startdate date NOT NULL,
    enddate date,
    duration integer NOT NULL,
    constraint fk_book
        foreign key(bookid)
            references Book(bookid),
    constraint fk_user
        foreign key(userid)
            references users(userid)
)