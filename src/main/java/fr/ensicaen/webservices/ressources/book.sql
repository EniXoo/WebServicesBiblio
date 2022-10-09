CREATE TABLE IF NOT EXISTS Book
(
    bookid serial PRIMARY KEY,
    publisherid serial NOT NULL,
    bookname varchar (100) NOT NULL,
    bookmark varchar(50) NOT NULL,
    constraint fk_publisher
        foreign key(publisherid)
            references Publisher(publisherid)
)